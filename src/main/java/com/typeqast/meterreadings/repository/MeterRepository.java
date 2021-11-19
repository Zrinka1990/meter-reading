package com.typeqast.meterreadings.repository;

import com.typeqast.meterreadings.model.Meter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MeterRepository extends CrudRepository<Meter, String> {
    @Query("select sum(m.energyConsumptionKwH) from Meter  m " +
            "where m.client = :client and m.year = :year")
    Integer getEnergySumForCustomer(String client, Short year);

    Set<Meter> getAllByClientAndYear(String client, Short year);

    Meter getByClientAndYearAndMonth(String client, Short year, String Month);
}
