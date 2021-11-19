package com.typeqast.meterreadings.model.converter;

import com.typeqast.meterreadings.dto.MeterRequestDto;
import com.typeqast.meterreadings.model.MeterReading;
import org.springframework.stereotype.Component;

@Component
public class MeterReadingDtoConverter {
    public MeterReading convertRequestDtoMeter(MeterRequestDto dto) {
        return new MeterReading(
                dto.getMonth(),
                dto.getYear(),
                dto.getEnergyConsumptionKwH(),
                dto.getClientId());
    }
}
