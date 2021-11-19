package com.typeqast.meterreadings.api.rest.restinterface;

import com.typeqast.meterreadings.dto.MeterRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("meter-reading-api/meter")
public interface IMeterRest {
    @PostMapping("/create")
    void createClient(@RequestBody MeterRequestDto dto);

    @GetMapping("/year-aggregate")
    Integer getYearAggregate(@RequestHeader(value = "client-id") Long clientId, @RequestParam Short year);

    @GetMapping("/readings-per-year")
    Map<String, Short> getReadingsPerYear(@RequestHeader(value = "client-id") Long clientId, @RequestParam Short year);

    @GetMapping("/readings-per-month-and-year")
    Map<String, Short> getReadingsPerMonthAndYear(
            @RequestHeader(value = "client-id") Long clientId, @RequestParam Short year, @RequestParam String month
    );
}
