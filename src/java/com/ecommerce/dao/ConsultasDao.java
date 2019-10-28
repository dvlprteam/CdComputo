/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

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

}
