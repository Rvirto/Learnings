package com.uol.client.endpoint;


import com.uol.client.model.Client;
import com.uol.client.repository.ClientRepository;
import com.uol.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientEndpoint {

    private ClientRepository clientRepository;

    private ClientService clientService;

    @Autowired
    public ClientEndpoint(ClientService clientService, ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<Client> findClientById(@PathVariable Long idClient) {
        Client client = clientService.findById(idClient);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{idClient}")
    public ResponseEntity<?> deleteClient(@PathVariable Long idClient) {
        clientRepository.deleteById(idClient);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idClient}")
    public ResponseEntity<Client> updateClient(@PathVariable Long idClient,
                                               @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(idClient, client);
        return ResponseEntity.ok(updatedClient);
    }

    @PostMapping
    public ResponseEntity<Client> registerClient(@RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }
}
