package com.typeqast.meterreadings.exception;

import lombok.Getter;

@Getter
public class ClientWIthSameAddressAlreadyExistsException extends RuntimeException {
    private final String address;

    public ClientWIthSameAddressAlreadyExistsException(String address){
        super(createMessage(address));
        this.address = address;
    }

    private static String createMessage(String address){
        return "Client with that address already exists: " + address;
    }
}
