package com.typeqast.meterreadings.api.rest;

import com.typeqast.meterreadings.dto.MeterRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("meter-reading-api/meter")
public interface IMeterRest {
    @PostMapping("/create")
    void createClient(@RequestBody MeterRequestDto dto);

    @GetMapping("/year-aggregate")
    Integer getYearAggregate(@RequestParam String client, @RequestParam Short year);

    @GetMapping("/readings-per-year")
    Map<String, Short> getReadingsPerYear(@RequestParam String client, @RequestParam Short year);

    @GetMapping("/readings-per-month-and-year")
    Map<String, Short> getReadingsPerMonthAndYear(
            @RequestParam String client, @RequestParam Short year, @RequestParam String month
    );
}
