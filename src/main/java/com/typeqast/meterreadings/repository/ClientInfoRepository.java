package com.typeqast.meterreadings.repository;

import com.typeqast.meterreadings.model.ClientInfo;
import com.typeqast.meterreadings.model.Meter;
import com.typeqast.meterreadings.model.MonthYearId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientInfoRepository extends CrudRepository<ClientInfo, MonthYearId> {

}
