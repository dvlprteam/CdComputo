package com.ecommerce.modelo;
// Generated 24/10/2019 07:41:37 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Estadosusuario generated by hbm2java
 */
public class Estadosusuario  implements java.io.Serializable {


     private int estusuid;
     private String estusudescripcion;
     private Date estusufechacreacion;
     private Date estusufechainactivo;
     private boolean estusuactivo;
     private Set usuarioses = new HashSet(0);

    public Estadosusuario() {
    }

	
    public Estadosusuario(int estusuid, String estusudescripcion, Date estusufechacreacion, boolean estusuactivo) {
        this.estusuid = estusuid;
        this.estusudescripcion = estusudescripcion;
        this.estusufechacreacion = estusufechacreacion;
        this.estusuactivo = estusuactivo;
    }
    public Estadosusuario(int estusuid, String estusudescripcion, Date estusufechacreacion, Date estusufechainactivo, boolean estusuactivo, Set usuarioses) {
       this.estusuid = estusuid;
       this.estusudescripcion = estusudescripcion;
       this.estusufechacreacion = estusufechacreacion;
       this.estusufechainactivo = estusufechainactivo;
       this.estusuactivo = estusuactivo;
       this.usuarioses = usuarioses;
    }
   
    public int getEstusuid() {
        return this.estusuid;
    }
    
    public void setEstusuid(int estusuid) {
        this.estusuid = estusuid;
    }
    public String getEstusudescripcion() {
        return this.estusudescripcion;
    }
    
    public void setEstusudescripcion(String estusudescripcion) {
        this.estusudescripcion = estusudescripcion;
    }
    public Date getEstusufechacreacion() {
        return this.estusufechacreacion;
    }
    
    public void setEstusufechacreacion(Date estusufechacreacion) {
        this.estusufechacreacion = estusufechacreacion;
    }
    public Date getEstusufechainactivo() {
        return this.estusufechainactivo;
    }
    
    public void setEstusufechainactivo(Date estusufechainactivo) {
        this.estusufechainactivo = estusufechainactivo;
    }
    public boolean isEstusuactivo() {
        return this.estusuactivo;
    }
    
    public void setEstusuactivo(boolean estusuactivo) {
        this.estusuactivo = estusuactivo;
    }
    public Set getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set usuarioses) {
        this.usuarioses = usuarioses;
    }




}

