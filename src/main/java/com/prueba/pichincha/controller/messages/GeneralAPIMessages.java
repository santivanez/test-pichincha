package com.prueba.pichincha.controller.messages;

public enum GeneralAPIMessages {

    ADD_MOVEMENT_SUCCESS("Movimiento creado exitosamente"),
    ADD_ACCOUNT_SUCCESS("Cuenta creada exitosamente"),
    ADD_CLIENT_SUCCESS("Cliente creado exitosamente"),
    ERROR_MOVEMENT("Error al crear movimiento"),
    ERROR_ACCOUNT("Error al crear cuenta"),
    ERROR_CLIENT("Error al crear clienta");

    public final String label;

    private GeneralAPIMessages(String label) {
        this.label = label;
    }

}
