package com.typeqast.meterreadings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MeterRequestDto {
    private String Client;
    private String month;
    private Short year;
    private Integer energyConsumptionKwH;
}
