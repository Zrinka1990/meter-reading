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
//
//    public MeterReadingPrimaryKey meterReadingPrimaryKey(DeleteRequestDto dto) {
//        return new MeterReadingPrimaryKey(
//                dto.getMonth(),
//                dto.getYear(),
//                dto.getClientId()
//        );
//    }
}
