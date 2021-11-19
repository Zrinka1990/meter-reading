package com.typeqast.meterreadings.model;

import lombok.*;

@Data
@AllArgsConstructor
public class ClientAddress {
    private String street;
    public String number;
    public String city;
    public String country;

    public String getFullAddress() {
        return String.format("%s %s, %s, %s", street, number, city, country);
    }
}
