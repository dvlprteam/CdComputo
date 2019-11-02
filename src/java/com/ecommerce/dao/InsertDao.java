/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelo.Personas;
import com.ecommerce.modelo.Usuarios;
import org.hibernate.Session;

/**
 *
 * @author emadrid
 */
public class InsertDao implements InsertIT {

    @Override
    public void createPersona(Session session, Personas personas) throws Exception {
        session.save(personas);
    }

    @Override
    public void createUsuario(Session session, Usuarios usuario) throws Exception {
        session.save(usuario);
    }

}
