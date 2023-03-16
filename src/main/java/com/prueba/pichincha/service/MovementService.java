package com.prueba.pichincha.service;

import com.prueba.pichincha.controller.request.MovementRequest;
import com.prueba.pichincha.exception.MovementException;

public interface MovementService {

    void processMovement(MovementRequest movementRequest) throws MovementException;

    void findUserMovementByDate(String clientName, String initDate, String endDate);

}
