package com.typeqast.meterreadings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MeterRequestDto {
    private Long clientId;
    private String month;
    private Short year;
    private Integer energyConsumptionKwH;
}
