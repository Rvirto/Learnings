package com.uol.client.endpoint;


import com.uol.client.model.Client;
import com.uol.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientEndpoint {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity<List<Client>> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<Client> findClientById(@PathVariable Long idClient) {
        Client client = clientRepository.getOne(idClient);
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
        return null;
    }
}
