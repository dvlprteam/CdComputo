/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelo.Personas;
import com.ecommerce.modelo.Imagenes;
import com.ecommerce.modelo.Tiposdocumento;
import com.ecommerce.modelo.Usuarios;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author emadrid
 */
public class ConsultasDao implements ConsultasIT {

    @Override
    public String getUrl(String codigo, Session session) throws Exception {
        String hql = "from Imagenes where codigo = :codigo";
        Query query = session.createQuery(hql);
        query.setString("codigo", codigo);
        Imagenes imagenes = (Imagenes) query.uniqueResult();
        return (imagenes != null) ? imagenes.getUrl() : "";
    }

    @Override
    public Usuarios getUser(Session session, String user, String pass) throws Exception {
        String hql = "from Usuarios where usunombre=:user and usupass=:pass";
        Query query = session.createQuery(hql);
        query.setString("user", user);
        query.setString("pass", pass);
        return (Usuarios) query.uniqueResult();
    }

    @Override
    public List<Tiposdocumento> allTiposDocumento(Session s) throws Exception {
        String hql = "from Tiposdocumento order by 1 asc";
        Query query = s.createQuery(hql);
        return query.list();
    }

    @Override
    public Personas getPersona(Session s, int tipoDoc, String documento) throws Exception {
        String hql = "from Personas where  tiposdocumento.tipdocid=:tipoDoc and perdocumento=:doc";
        Query q = s.createQuery(hql);
        q.setString("doc", documento);
        q.setInteger("tipoDoc", tipoDoc);
        if (q.list().isEmpty()) {
            return null;
        }
        return (Personas) q.list().get(0);
    }

}
