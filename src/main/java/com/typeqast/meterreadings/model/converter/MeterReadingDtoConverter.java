package com.typeqast.meterreadings.model.converter;

import com.typeqast.meterreadings.dto.DeleteRequestDto;
import com.typeqast.meterreadings.dto.MeterRequestDto;
import com.typeqast.meterreadings.model.MeterReading;
import com.typeqast.meterreadings.model.MeterReadingPrimaryKey;
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

    public MeterReadingPrimaryKey convertDeleterRequestToMeterReadingPrimaryKey(DeleteRequestDto dto) {
        MeterReadingPrimaryKey pk = new MeterReadingPrimaryKey();
        pk.setMonth(dto.getMonth());
        pk.setYear(dto.getYear());
        pk.setClientId(dto.getClientId());
        return pk;
    }
}
