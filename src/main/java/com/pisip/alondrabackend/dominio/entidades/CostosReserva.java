package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class CostosReserva implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int idCostosReservas;   // PK
    private final int idReservas;         // FK
    private final int idCostos;           // FK

    private CostosReserva(
            int idCostosReservas,
            int idReservas,
            int idCostos) {

        this.idCostosReservas = idCostosReservas;
        this.idReservas = idReservas;
        this.idCostos = idCostos;
    }

    // Reglas de negocio y validaciones se pueden agregar aquí

    public int getIdCostosReservas() {
        return idCostosReservas;
    }

    public int getIdReservas() {
        return idReservas;
    }

    public int getIdCostos() {
        return idCostos;
    }

    @Override
    public String toString() {
        return "CostosReserva [" +
                "idCostosReservas=" + idCostosReservas +
                ", idReservas=" + idReservas +
                ", idCostos=" + idCostos +
                "]";
    }
}