package com.prueba.pichincha.controller.request;

import com.prueba.pichincha.entity.Status;
import lombok.Data;

@Data
public class AccountRequest {

    private String clientName;
    private String numberAccount;
    private Status type;
    private Double initialBalance;

}
