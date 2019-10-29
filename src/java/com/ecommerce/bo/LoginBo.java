/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.bo;

import com.ecommerce.bean.BeanLogin;
import com.ecommerce.dao.ConsultasDao;
import com.ecommerce.dao.ConsultasIT;
import com.ecommerce.dao.InsertDao;
import com.ecommerce.dao.InsertIT;
import com.ecommerce.modelo.Estadospersona;
import com.ecommerce.modelo.Estadosusuario;
import com.ecommerce.modelo.Personas;
import com.ecommerce.modelo.Tiposdocumento;
import com.ecommerce.modelo.Tipossexo;
import com.ecommerce.modelo.Usuarios;
import com.ecommerce.utility.DigestHandler;
import com.ecommerce.utility.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

/**
 *
 * @author emadrid
 */
public class LoginBo {

    private ConsultasIT consultasDAO = new ConsultasDao();
    private InsertIT insertDAO = new InsertDao();

    public void getAllTipoDoc(BeanLogin login) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            login.setTiposdocumentos(getConsultasDAO().allTiposDocumento(session));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            session.flush();
            session.close();
        }

    }

    public void validarUser(BeanLogin login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Usuarios usuarios = getConsultasDAO().getUser(session, login.getUser(), login.getPass());
            if (usuarios == null) {
                RequestContext.getCurrentInstance().execute("alert(User no encontrado)");
                return;
            }
            System.out.println("Sí se encontro el usuario");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public boolean registrarPersona(BeanLogin login) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Personas per = getConsultasDAO().getPersona(session, login.getTipoDocPer(), login.getPersonas().getPerdocumento());// Consulta en persona para saber si ya existe.
            if (per == null) {
                RequestContext.getCurrentInstance().execute("alert('Persona ya registrada en neustro sistema');");
                return false;
            }
            if (login.getPersonas().getPernombre1() == null) {
                RequestContext.getCurrentInstance().execute("alert('Digite primer nombre.');");
                return false;
            }
            if (login.getPersonas().getPerapellido1() == null) {
                RequestContext.getCurrentInstance().execute("alert('Digite primer nombre.');");
                return false;
            }
            login.getPersonas().setTipossexo(new Tipossexo(1, null, null, null, true));
            login.getPersonas().setTiposdocumento(new Tiposdocumento(login.getTipoDocPer(), null, null, null, true));
            login.getPersonas().setPerfechacreacion(new Date());
            login.getPersonas().setEstadospersona(new Estadospersona(1, null, null, true));
            getInsertDAO().createPersona(session, login.getPersonas());
            Usuarios usuarios = new Usuarios();
            usuarios.setUsupass(DigestHandler.encryptSHA2(login.getPass()));
            usuarios.setEstadosusuario(new Estadosusuario(1, null, null, true));
            usuarios.setUsufechacreacion(new Date());
            usuarios.setUsunombre(login.getUser());
            usuarios.setPersonas(login.getPersonas());
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            session.flush();
            session.close();
        }

    }

    /**
     * @return the consultasDAO
     */
    public ConsultasIT getConsultasDAO() {
        return consultasDAO;
    }

    /**
     * @param consultasDAO the consultasDAO to set
     */
    public void setConsultasDAO(ConsultasIT consultasDAO) {
        this.consultasDAO = consultasDAO;
    }

    /**
     * @return the insertDAO
     */
    public InsertIT getInsertDAO() {
        return insertDAO;
    }

    /**
     * @param insertDAO the insertDAO to set
     */
    public void setInsertDAO(InsertIT insertDAO) {
        this.insertDAO = insertDAO;
    }

}
