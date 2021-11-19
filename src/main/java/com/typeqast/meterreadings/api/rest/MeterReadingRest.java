package com.typeqast.meterreadings.api.rest;

import com.typeqast.meterreadings.api.rest.restinterface.IMeterReadingRest;
import com.typeqast.meterreadings.dto.DeleteRequestDto;
import com.typeqast.meterreadings.dto.MeterRequestDto;
import com.typeqast.meterreadings.model.MeterReading;
import com.typeqast.meterreadings.model.MeterReadingPrimaryKey;
import com.typeqast.meterreadings.model.converter.MeterReadingDtoConverter;
import com.typeqast.meterreadings.service.MeterReadingFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MeterReadingRest implements IMeterReadingRest {
    private final MeterReadingDtoConverter converter;
    private final MeterReadingFetcher service;

    @Autowired
    public MeterReadingRest(MeterReadingDtoConverter converter, MeterReadingFetcher service) {
        this.converter = converter;
        this.service = service;
    }

    @Override
    public void createMeterReading(MeterRequestDto dto) {
        MeterReading meter = converter.convertRequestDtoMeter(dto);
        service.create(meter);
    }

    @Override
    public void deleteMeterReading(DeleteRequestDto dto) {
        MeterReadingPrimaryKey pk = converter.meterReadingPrimaryKey(dto);
        service.delete(pk);
    }

    @Override
    public Integer getYearlyMeterReadingAggregate(Long clientId, Short year) {
        return service.getTotalEnergyConsumptionForYear(clientId, year);
    }

    @Override
    public Map<String, Short> getMeterReadingsPerYear(Long clientId, Short year) {
        return service.meterReadingPerYear(clientId, year);
    }

    @Override
    public Map<String, Short> getMeterReadingsPerMonthAndYear(Long clientId, Short year, String month) {
        return service.meterReadingPerYearAndMonth(clientId, year, month);
    }
}
