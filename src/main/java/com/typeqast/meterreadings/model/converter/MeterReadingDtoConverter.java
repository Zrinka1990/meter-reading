package com.typeqast.meterreadings.model.converter;

import com.typeqast.meterreadings.dto.MeterRequestDto;
import com.typeqast.meterreadings.model.Meter;
import org.springframework.stereotype.Component;

@Component
public class MeterReadingDtoConverter {
    public Meter convertRequestDtoMeter(MeterRequestDto dto) {
        return new Meter(
                dto.getMonth(),
                dto.getYear(),
                dto.getEnergyConsumptionKwH(),
                dto.getClient());
    }
}
