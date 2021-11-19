package com.typeqast.meterreadings.api.rest.restinterface;

import com.typeqast.meterreadings.dto.DeleteRequestDto;
import com.typeqast.meterreadings.dto.MeterRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("meter-reading-api/meter")
public interface IMeterReadingRest {
    @PostMapping("/create")
    void createMeterReading(@RequestBody MeterRequestDto dto);

    @PostMapping("/delete")
    void deleteMeterReading(@RequestBody DeleteRequestDto dto);

    @GetMapping("/year-aggregate")
    Integer getYearlyMeterReadingAggregate(
            @RequestHeader(value = "client-id") Long clientId, @RequestParam Short year
    );

    @GetMapping("/year")
    Map<String, Short> getMeterReadingsPerYear(
            @RequestHeader(value = "client-id") Long clientId, @RequestParam Short year
    );

    @GetMapping("/month-and-year")
    Map<String, Short> getMeterReadingsPerMonthAndYear(
            @RequestHeader(value = "client-id") Long clientId, @RequestParam Short year, @RequestParam String month
    );
}
