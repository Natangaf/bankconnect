package com.bankconnect.bankconnect.controller;

import com.bankconnect.bankconnect.dto.TransitionDto;
import com.bankconnect.bankconnect.model.Transition;
import com.bankconnect.bankconnect.service.TransitionServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trasition")
public class TransitionController {

    private final TransitionServices transitionServices;

    public TransitionController(TransitionServices transitionServices) {
        this.transitionServices = transitionServices;
    }


    @PostMapping("/{id}/deposit")
    public ResponseEntity<Transition> depositClients(@RequestBody TransitionDto depositData, @PathVariable String id) throws Exception {

        final Transition transition =  transitionServices.clientDeposit(depositData,Long.parseLong(id));

        return new ResponseEntity<Transition>(transition, HttpStatus.CREATED);

    }
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Transition> withdrawClients(@RequestBody TransitionDto depositData, @PathVariable String id) throws Exception {

        final Transition transition =  transitionServices.clientWithdraw(depositData,Long.parseLong(id));

        return new ResponseEntity<Transition>(transition, HttpStatus.CREATED);

    }
}
