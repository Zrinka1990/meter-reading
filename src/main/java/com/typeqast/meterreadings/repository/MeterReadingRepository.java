package com.typeqast.meterreadings.repository;

import com.typeqast.meterreadings.model.MeterReading;
import com.typeqast.meterreadings.model.MeterReadingPrimaryKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MeterReadingRepository extends CrudRepository<MeterReading, MeterReadingPrimaryKey> {
    @Query("select sum(m.energyConsumptionKwH) from MeterReading  m " +
            "where m.clientId = :clientId and m.year = :year")
    Integer getEnergySumForCustomer(Long clientId, Short year);

    Set<MeterReading> getAllByClientIdAndYear(Long clientId, Short year);

    MeterReading getByClientIdAndYearAndMonth(Long clientId, Short year, String Month);
}
