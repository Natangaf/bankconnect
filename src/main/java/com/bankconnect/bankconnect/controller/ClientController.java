package com.bankconnect.bankconnect.controller;

import com.bankconnect.bankconnect.dto.ClientDto;
import com.bankconnect.bankconnect.model.Client;
import com.bankconnect.bankconnect.service.ClientServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientServices clientServices;

    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody final ClientDto clientData) {
        Client createdClient = clientServices.createClient(clientData);

        return new ResponseEntity<Client>(createdClient, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Client>> readClients() {
        final List<Client> allClient = clientServices.readClient();

        return new ResponseEntity<List<Client>>(allClient, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> retrieverClients(@PathVariable String id) throws Exception {
        final Client client = clientServices.retriverClient(Long.parseLong(id));

        return new ResponseEntity<Client>(client, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClients(@PathVariable String id,@RequestBody final ClientDto clientData) throws Exception {

        final Client client = clientServices.updateClient(clientData,Long.parseLong(id));

        return new ResponseEntity<Client>(client, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletedClients(@PathVariable String id) throws Exception {

         clientServices.deleteClient(Long.parseLong(id));

        return new ResponseEntity<Void>( HttpStatus.NO_CONTENT);

    }

}
