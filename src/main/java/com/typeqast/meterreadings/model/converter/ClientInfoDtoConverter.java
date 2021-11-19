package com.typeqast.meterreadings.model.converter;

import com.typeqast.meterreadings.dto.ClientInfoRequestDto;
import com.typeqast.meterreadings.model.ClientAddress;
import com.typeqast.meterreadings.model.ClientInfo;
import org.springframework.stereotype.Component;

@Component
public class ClientInfoDtoConverter {
    public ClientInfo convertClientInfoRequestDtoToClientInfo(ClientInfoRequestDto dto) {
        ClientInfo client = new ClientInfo();
        client.setClientName(dto.getClientName());
        client.setAddress(createAddressFromDto(dto).getFullAddress());
        return client;
    }

    private ClientAddress createAddressFromDto(ClientInfoRequestDto dto) {
        return new ClientAddress(
                dto.getStreet(),
                dto.getNumber(),
                dto.getCity(),
                dto.getCountry()
        );
    }
}
