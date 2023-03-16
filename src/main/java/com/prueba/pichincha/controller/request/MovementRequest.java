package com.prueba.pichincha.controller.request;

import com.prueba.pichincha.entity.Status;
import lombok.Data;

@Data
public class MovementRequest {

    private String numberAccount;

    private Status type;

    private Long initialAmount;

    private String clientName;

    private double amount;

}
