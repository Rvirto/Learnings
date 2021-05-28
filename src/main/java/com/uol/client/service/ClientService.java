package com.uol.client.service;

import com.uol.client.dto.GeographicLocationDTO;
import com.uol.client.dto.LocationDTO;
import com.uol.client.exception.NotFoundException;
import com.uol.client.model.Client;
import com.uol.client.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    private GeographicLocationService geographicLocationService;

    private LocationService locationService;

    @Autowired
    public ClientService(ClientRepository clientRepository,
                         GeographicLocationService geographicLocationService,
                         LocationService locationService) {
        this.clientRepository = clientRepository;
        this.geographicLocationService = geographicLocationService;
        this.locationService = locationService;
    }

    public Client findById(Long idClient) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new NotFoundException("Could not find Client with idClient = " + idClient));
        return client;
    }

    public Client updateClient(Long idClient, Client client) {
        Client clientFound = findById(idClient);

        BeanUtils.copyProperties(client, clientFound, "idClient");

        return saveClient(clientFound);
    }

    public Client saveClient(Client client) {
        GeographicLocationDTO geographicLocationDTO = geographicLocationService.getGeographicLocation();
        LocationDTO locationDTO = locationService.getLocation(geographicLocationDTO.getLocation());


        client.setIpCreation(geographicLocationDTO.getIp());
        client.setLocationGeographic(geographicLocationDTO.getCity());
        client.setMaxTemperature(locationDTO.getMaxTemp());
        client.setMinTemperature(locationDTO.getMinTemp());

        Client savedClient = clientRepository.save(client);
        return savedClient;
    }

    public void deleteClient(Long idClient) {
        findById(idClient);
        clientRepository.deleteById(idClient);
    }
}
