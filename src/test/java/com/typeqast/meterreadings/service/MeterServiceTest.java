package com.typeqast.meterreadings.service;

import com.typeqast.meterreadings.MeterReadingsApplication;
import com.typeqast.meterreadings.model.Meter;
import com.typeqast.meterreadings.repository.MeterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {MeterReadingsApplication.class})
class MeterServiceTest {
    private MeterService meterService;
    private String client = "clientA";
    private Short year = (short) 2018;

    @Mock
    private MeterRepository meterRepository;

    @BeforeEach
    void setUp() {
        meterService = new MeterService(meterRepository);
    }

    @Test
    void given_RequestForClientSent_When_MonthlyEnergyConsumptionForYearFetched_Then_ReturnTotalEnergyConsumption() {
        when(meterRepository.getEnergySumForCustomer(client, year)).thenReturn(30);
        assertThat(meterService.getTotalEnergyConsumptionForYear(client, year)).isEqualTo(30);
    }

    @Test
    void given_RequestForClientSent_When_MeterReadingPerYearRequested_Then_ReturnYearAndMonthlyEnergyConsumptions() {
        Set<Meter> yearlyMeterReadings = getYearlyMeterReadings();
        when(meterRepository.getAllByClientAndYear(client, year)).thenReturn(yearlyMeterReadings);
        Map<String, Short> expectedResult = getExpectedResultForMonthlyReadings();
        assertThat(meterService.meterReadingPerYear(client, year)).isEqualTo(expectedResult);
    }

    @Test
    void given_RequestForClientSent_When_MeterReadingPerYearAndMonthRequested_Then_ReturnYearMonthlyAndEnergyConsumption() {
        String month = "September";
        Meter meter = new Meter(month, year, 21, client);
        when(meterRepository.getByClientAndYearAndMonth(client, year, month)).thenReturn(meter);
        Map<String, Short> expectedResult = getExpectedResultForOneMonthReading();
        assertThat(meterService.meterReadingPerYearAndMonth(client, year, month)).isEqualTo(expectedResult);
    }

    private Set<Meter> getYearlyMeterReadings() {
        Meter meter1 = new Meter("January", year, 2, client);
        Meter meter2 = new Meter("February", year, 5, client);
        Meter meter3 = new Meter("March", year, 7, client);
        return Set.of(meter1, meter2, meter3);
    }

    private Map<String, Short> getExpectedResultForMonthlyReadings() {
        Map<String, Short> expectedResult = new LinkedHashMap<>();
        expectedResult.put("year", year);
        expectedResult.put("January", (short) 2);
        expectedResult.put("February", (short) 5);
        expectedResult.put("March", (short) 7);
        return expectedResult;
    }

    private Map<String, Short> getExpectedResultForOneMonthReading() {
        Map<String, Short> expectedResult = new LinkedHashMap<>();
        expectedResult.put("year", year);
        expectedResult.put("September", (short) 21);
        return expectedResult;
    }
//
}