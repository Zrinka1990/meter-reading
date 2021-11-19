package com.typeqast.meterreadings.repository;

import com.typeqast.meterreadings.model.Meter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MeterRepository extends CrudRepository<Meter, String> {
    @Query("select sum(m.energyConsumptionKwH) from Meter  m " +
            "where m.clientId = :clientId and m.year = :year")
    Integer getEnergySumForCustomer(Long clientId, Short year);

    Set<Meter> getAllByClientIdAndYear(Long clientId, Short year);

    Meter getByClientIdAndYearAndMonth(Long clientId, Short year, String Month);
}
