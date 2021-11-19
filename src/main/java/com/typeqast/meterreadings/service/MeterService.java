package com.typeqast.meterreadings.service;

import com.typeqast.meterreadings.model.Meter;
import com.typeqast.meterreadings.repository.MeterRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Service
public class MeterService {
    private final MeterRepository meterRepository;

    public MeterService(MeterRepository meterRepository) {
        this.meterRepository = meterRepository;
    }

    public void create(Meter meter) {
        meterRepository.save(meter);
    }

    public Integer getTotalEnergyConsumptionForYear(String client, Short year) {
        return meterRepository.getEnergySumForCustomer(client, year);
    }

    public Map<String, Short> meterReadingPerYear(String client, Short year) {
        Set<Meter> meters = meterRepository.getAllByClientAndYear(client, year);
        return convertReadingPerYear(year, meters);
    }

    public Map<String, Short> meterReadingPerYearAndMonth(String client, Short year, String month) {
        Meter meter = meterRepository.getByClientAndYearAndMonth(client, year, month);
        return getMap(meter);
    }

    private Map<String, Short> convertReadingPerYear(Short year, Set<Meter> meterSet) {
        Map<String, Short> map = new LinkedHashMap<>();
        map.put("year", year);

        for (Meter meter : meterSet) {
            map.put(meter.getMonth(), Short.valueOf(meter.getEnergyConsumptionKwH().toString()));
        }

        return map;
    }

    private Map<String, Short> getMap(Meter meter) {
        Map<String, Short> map = new LinkedHashMap<>();
        map.put("year", meter.getYear());
        map.put(meter.getMonth(), Short.valueOf(meter.getEnergyConsumptionKwH().toString()));
        return map;
    }
}
