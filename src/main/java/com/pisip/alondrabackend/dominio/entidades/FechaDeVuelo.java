package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;
import java.sql.Date;

public class FechaDeVuelo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date fechaDeVuelo;
    private int idVuelo;
    private int idServiciosExtras;
    private int idPaquetes;
    private int idAgencia;

   
    public FechaDeVuelo() {
    }

   
    public FechaDeVuelo(Date fechaDeVuelo, int idVuelo, int idServiciosExtras,
                        int idPaquetes, int idAgencia) {
        this.fechaDeVuelo = fechaDeVuelo;
        this.idVuelo = idVuelo;
        this.idServiciosExtras = idServiciosExtras;
        this.idPaquetes = idPaquetes;
        this.idAgencia = idAgencia;
    }

   
    public Date getFechaDeVuelo() {
        return fechaDeVuelo;
    }

    public void setFechaDeVuelo(Date fechaDeVuelo) {
        this.fechaDeVuelo = fechaDeVuelo;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getIdServiciosExtras() {
        return idServiciosExtras;
    }

    public void setIdServiciosExtras(int idServiciosExtras) {
        this.idServiciosExtras = idServiciosExtras;
    }

    public int getIdPaquetes() {
        return idPaquetes;
    }

    public void setIdPaquetes(int idPaquetes) {
        this.idPaquetes = idPaquetes;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }
}
