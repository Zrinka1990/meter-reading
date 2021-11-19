package com.typeqast.meterreadings.service;

import com.typeqast.meterreadings.exception.ClientWIthSameAddressAlreadyExistsException;
import com.typeqast.meterreadings.model.ClientInfo;
import com.typeqast.meterreadings.repository.ClientInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientInfoRepository clientInfoRepository;

    @Autowired
    public ClientService(ClientInfoRepository clientInfoRepository) {
        this.clientInfoRepository = clientInfoRepository;
    }

    public void createClient(ClientInfo client) throws ClientWIthSameAddressAlreadyExistsException {
        try {
            clientInfoRepository.save(client);
        } catch (RuntimeException e) {
            throw new ClientWIthSameAddressAlreadyExistsException(client.getAddress());
        }
    }
}
