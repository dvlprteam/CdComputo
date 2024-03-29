package com.ecommerce.modelo;
// Generated 24/10/2019 07:41:37 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Estadosdatospersona generated by hbm2java
 */
public class Estadosdatospersona  implements java.io.Serializable {


     private int estdatperid;
     private String estdatperdescripcion;
     private Date estdatperfechacreacion;
     private Date estdatperfechainactivo;
     private boolean estdatperactivo;
     private Set datospersonas = new HashSet(0);

    public Estadosdatospersona() {
    }

	
    public Estadosdatospersona(int estdatperid, String estdatperdescripcion, Date estdatperfechacreacion, boolean estdatperactivo) {
        this.estdatperid = estdatperid;
        this.estdatperdescripcion = estdatperdescripcion;
        this.estdatperfechacreacion = estdatperfechacreacion;
        this.estdatperactivo = estdatperactivo;
    }
    public Estadosdatospersona(int estdatperid, String estdatperdescripcion, Date estdatperfechacreacion, Date estdatperfechainactivo, boolean estdatperactivo, Set datospersonas) {
       this.estdatperid = estdatperid;
       this.estdatperdescripcion = estdatperdescripcion;
       this.estdatperfechacreacion = estdatperfechacreacion;
       this.estdatperfechainactivo = estdatperfechainactivo;
       this.estdatperactivo = estdatperactivo;
       this.datospersonas = datospersonas;
    }
   
    public int getEstdatperid() {
        return this.estdatperid;
    }
    
    public void setEstdatperid(int estdatperid) {
        this.estdatperid = estdatperid;
    }
    public String getEstdatperdescripcion() {
        return this.estdatperdescripcion;
    }
    
    public void setEstdatperdescripcion(String estdatperdescripcion) {
        this.estdatperdescripcion = estdatperdescripcion;
    }
    public Date getEstdatperfechacreacion() {
        return this.estdatperfechacreacion;
    }
    
    public void setEstdatperfechacreacion(Date estdatperfechacreacion) {
        this.estdatperfechacreacion = estdatperfechacreacion;
    }
    public Date getEstdatperfechainactivo() {
        return this.estdatperfechainactivo;
    }
    
    public void setEstdatperfechainactivo(Date estdatperfechainactivo) {
        this.estdatperfechainactivo = estdatperfechainactivo;
    }
    public boolean isEstdatperactivo() {
        return this.estdatperactivo;
    }
    
    public void setEstdatperactivo(boolean estdatperactivo) {
        this.estdatperactivo = estdatperactivo;
    }
    public Set getDatospersonas() {
        return this.datospersonas;
    }
    
    public void setDatospersonas(Set datospersonas) {
        this.datospersonas = datospersonas;
    }




}


