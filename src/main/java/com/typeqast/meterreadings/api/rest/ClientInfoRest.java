package com.typeqast.meterreadings.api.rest;

import com.typeqast.meterreadings.api.rest.restinterface.IClientInfoRest;
import com.typeqast.meterreadings.dto.ClientInfoRequestDto;
import com.typeqast.meterreadings.model.ClientInfo;
import com.typeqast.meterreadings.model.converter.ClientInfoDtoConverter;
import com.typeqast.meterreadings.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientInfoRest implements IClientInfoRest {
    private final ClientService clientService;
    private final ClientInfoDtoConverter clientInfoDtoConverter;

    @Autowired
    public ClientInfoRest(ClientService clientService, ClientInfoDtoConverter clientInfoDtoConverter) {
        this.clientService = clientService;
        this.clientInfoDtoConverter = clientInfoDtoConverter;
    }

    @Override
    public void createClient(ClientInfoRequestDto dto) {
        ClientInfo client = clientInfoDtoConverter.convertClientInfoRequestDtoToClientInfo(dto);
        clientService.saveClient(client);
    }
}
