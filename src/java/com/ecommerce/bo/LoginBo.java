/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.bo;

import com.ecommerce.bean.BeanLogin;
import com.ecommerce.dao.ConsultasDao;
import com.ecommerce.dao.ConsultasIT;
import com.ecommerce.modelo.Usuarios;
import com.ecommerce.utility.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author emadrid
 */
public class LoginBo {

    private ConsultasIT consultasDAO = new ConsultasDao();

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
                System.out.println("No se encontro el usuario");
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

}
