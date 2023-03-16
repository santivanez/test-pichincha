package com.prueba.pichincha.controller;

import com.prueba.pichincha.controller.request.MovementRequest;
import com.prueba.pichincha.exception.MovementException;
import com.prueba.pichincha.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.prueba.pichincha.controller.messages.GeneralAPIMessages.ADD_MOVEMENT_SUCCESS;
import static com.prueba.pichincha.controller.messages.GeneralAPIMessages.ERROR_MOVEMENT;

@RestController
@RequestMapping(value = "/movimientos")
public class MovementsController {

    MovementService movementService;

    @Autowired
    public MovementsController(MovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping()
    public ResponseEntity addMovement(@RequestBody MovementRequest movementRequest) {
        try {
            movementService.processMovement(movementRequest);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ADD_MOVEMENT_SUCCESS);
        } catch (MovementException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ERROR_MOVEMENT);
        }
    }

    @GetMapping(path = "/reporte/date/{initDate}/{endDate}")
    public void reportByDate(@RequestParam String clientName,
                             @PathVariable String initDate,
                             @PathVariable String endDate) {
        movementService.findUserMovementByDate(clientName, initDate, endDate);
    }

}
