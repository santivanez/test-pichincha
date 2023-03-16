package com.prueba.pichincha.entity;

public enum Status {
    CORRIENTE("Corriente"),
    AHORROS("Ahorro");

    public final String label;

    private Status(String label) {
        this.label = label;
    }
}
