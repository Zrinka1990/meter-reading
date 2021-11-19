package com.typeqast.meterreadings.service;

import com.typeqast.meterreadings.exception.InvalidMonthFormatException;
import com.typeqast.meterreadings.model.MeterReading;
import com.typeqast.meterreadings.repository.MeterRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Service
public class MeterReadingFetcher {
    private final MeterRepository meterRepository;

    public MeterReadingFetcher(MeterRepository meterRepository) {
        this.meterRepository = meterRepository;
    }

    public void create(MeterReading meter) {
        checkIfValidMonthProvided(meter.getMonth());
        meterRepository.save(meter);
    }

    public Integer getTotalEnergyConsumptionForYear(Long clientId, Short year) {
        return meterRepository.getEnergySumForCustomer(clientId, year);
    }

    public Map<String, Short> meterReadingPerYear(Long clientId, Short year) {
        Set<MeterReading> meters = meterRepository.getAllByClientIdAndYear(clientId, year);
        return convertReadingPerYear(year, meters);
    }

    public Map<String, Short> meterReadingPerYearAndMonth(Long clientId, Short year, String month) {
        MeterReading meter = meterRepository.getByClientIdAndYearAndMonth(clientId, year, month);
        return getMap(meter);
    }

    private void checkIfValidMonthProvided(String month) {
        try {
            Month.valueOf(month.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidMonthFormatException(month);
        }
    }

    private Map<String, Short> convertReadingPerYear(Short year, Set<MeterReading> meterSet) {
        Map<String, Short> map = new LinkedHashMap<>();
        map.put("year", year);

        for (MeterReading meter : meterSet) {
            map.put(meter.getMonth(), Short.valueOf(meter.getEnergyConsumptionKwH().toString()));
        }

        return map;
    }

    private Map<String, Short> getMap(MeterReading meter) {
        Map<String, Short> map = new LinkedHashMap<>();
        map.put("year", meter.getYear());
        map.put(meter.getMonth(), Short.valueOf(meter.getEnergyConsumptionKwH().toString()));
        return map;
    }
}
