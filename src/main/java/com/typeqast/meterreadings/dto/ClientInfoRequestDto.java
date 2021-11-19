package com.typeqast.meterreadings.dto;

import lombok.Data;

@Data
public class ClientInfoRequestDto {
    private String client;
    private String street;
    public String number;
    public String city;
    public String country;
}
