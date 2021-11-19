package com.typeqast.meterreadings.api.rest;

import com.typeqast.meterreadings.dto.MeterRequestDto;
import com.typeqast.meterreadings.model.Meter;
import com.typeqast.meterreadings.model.converter.MeterReadingDtoConverter;
import com.typeqast.meterreadings.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MeterRest implements IMeterRest{
    private final MeterReadingDtoConverter converter;
    private final MeterService service;

    @Autowired
    public MeterRest(MeterReadingDtoConverter converter, MeterService service) {
        this.converter = converter;
        this.service = service;
    }

    @Override
    public void createClient(MeterRequestDto dto) {
        Meter meter = converter.convertRequestDtoMeter(dto);
        service.create(meter);
    }

    @Override
    public Integer getYearAggregate(String client, Short year) {
        return service.getTotalEnergyConsumptionForYear(client, year);
    }

    @Override
    public Map<String, Short> getReadingsPerYear(String client, Short year) {
        return service.meterReadingPerYear(client, year);
    }

    @Override
    public Map<String, Short> getReadingsPerMonthAndYear(String client, Short year, String month) {
        return service.meterReadingPerYearAndMonth(client, year, month);
    }
}
