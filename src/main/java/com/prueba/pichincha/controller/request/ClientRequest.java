package com.prueba.pichincha.controller.request;

import lombok.Data;

@Data
public class ClientRequest {

    private String name;
    private String address;
    private String phone;
    private String password;
    private boolean status;

}
