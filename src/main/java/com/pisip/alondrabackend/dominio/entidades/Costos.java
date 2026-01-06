package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Costos implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int idCostos;

    private Costos(int idCostos) {
        this.idCostos = idCostos;
    }

    public int getIdCostos() {
        return idCostos;
    }

    @Override
    public String toString() {
        return "Costos [idCostos=" + idCostos + "]";
    }
}