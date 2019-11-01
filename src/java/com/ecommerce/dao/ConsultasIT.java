/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.modelo.Personas;
import com.ecommerce.modelo.Tiposdocumento;
import com.ecommerce.modelo.Usuarios;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author emadrid
 */
public interface ConsultasIT {

    Usuarios getUser(Session session, String user, String pass) throws Exception;

    List<Tiposdocumento> allTiposDocumento(Session s) throws Exception;

    Personas getPersona(Session s, int tipoDoc, String documento)throws Exception;
    
    
    String getUrl(String codigo, Session session) throws Exception;
}
