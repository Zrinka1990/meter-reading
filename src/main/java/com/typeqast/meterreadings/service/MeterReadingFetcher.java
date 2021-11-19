package com.typeqast.meterreadings.service;

import com.typeqast.meterreadings.exception.InvalidMonthFormatException;
import com.typeqast.meterreadings.model.MeterReading;
import com.typeqast.meterreadings.model.MeterReadingPrimaryKey;
import com.typeqast.meterreadings.repository.MeterReadingRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Service
public class MeterReadingFetcher {
    private final MeterReadingRepository meterRepository;

    public MeterReadingFetcher(MeterReadingRepository meterRepository) {
        this.meterRepository = meterRepository;
    }

    public void create(MeterReading meter) {
        checkIfValidMonthProvided(meter.getMonth());
        meterRepository.save(meter);
    }

    public void delete(MeterReadingPrimaryKey pk) {
        meterRepository.deleteById(pk);
    }

    public Integer fetchTotalEnergyConsumptionForYear(Long clientId, Short year) {
        return meterRepository.getEnergySumForCustomer(clientId, year);
    }

    public Map<String, Short> fetchMeterReadingPerYear(Long clientId, Short year) {
        Set<MeterReading> meters = meterRepository.getAllByClientIdAndYear(clientId, year);
        return getReadingPerYearMap(year, meters);
    }

    public Map<String, Short> fetchMeterReadingPerYearAndMonth(Long clientId, Short year, String month) {
        MeterReading meter = meterRepository.getByClientIdAndYearAndMonth(clientId, year, month);
        return getReadingsPerMonthAndYearMap(meter);
    }

    private void checkIfValidMonthProvided(String month) {
        try {
            Month.valueOf(month.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidMonthFormatException(month);
        }
    }

    private Map<String, Short> getReadingPerYearMap(Short year, Set<MeterReading> meterSet) {
        Map<String, Short> map = new LinkedHashMap<>();
        map.put("year", year);

        for (MeterReading meter : meterSet) {
            map.put(meter.getMonth(), Short.valueOf(meter.getEnergyConsumptionKwH().toString()));
        }

        return map;
    }

    private Map<String, Short> getReadingsPerMonthAndYearMap(MeterReading meter) {
        Map<String, Short> map = new LinkedHashMap<>();
        map.put("year", meter.getYear());
        map.put(meter.getMonth(), Short.valueOf(meter.getEnergyConsumptionKwH().toString()));
        return map;
    }
}
