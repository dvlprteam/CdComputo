/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.bean;

import com.ecommerce.bo.LoginBo;
import com.ecommerce.modelo.Personas;
import com.ecommerce.modelo.Tiposdocumento;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author emadrid
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class BeanLogin {

    private String user;
    private String pass;
    private List<Tiposdocumento> tiposdocumentos = new ArrayList<>();
    private int tipoDocPer;
    private LoginBo loginBo;
    private Personas personas = new Personas();

    @PostConstruct
    public void init() {
        try {
            setLoginBo(new LoginBo());
            getLoginBo().getAllTipoDoc(this);
            setPersonas(new Personas());
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(BeanLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String autenticar() {
        try {
            getLoginBo().validarUser(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void registrarUser() {
        try {
            if (getLoginBo().registrarPersona(this)) {
                RequestContext.getCurrentInstance().execute("alert('Persona registrada exitosamente');");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the loginBo
     */
    public LoginBo getLoginBo() {
        return loginBo;
    }

    /**
     * @param loginBo the loginBo to set
     */
    public void setLoginBo(LoginBo loginBo) {
        this.loginBo = loginBo;
    }

    /**
     * @return the tiposdocumentos
     */
    public List<Tiposdocumento> getTiposdocumentos() {
        return tiposdocumentos;
    }

    /**
     * @param tiposdocumentos the tiposdocumentos to set
     */
    public void setTiposdocumentos(List<Tiposdocumento> tiposdocumentos) {
        this.tiposdocumentos = tiposdocumentos;
    }

    /**
     * @return the tipoDocPer
     */
    public int getTipoDocPer() {
        return tipoDocPer;
    }

    /**
     * @param tipoDocPer the tipoDocPer to set
     */
    public void setTipoDocPer(int tipoDocPer) {
        this.tipoDocPer = tipoDocPer;
    }

    /**
     * @return the personas
     */
    public Personas getPersonas() {
        return personas;
    }

    /**
     * @param personas the personas to set
     */
    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

}
