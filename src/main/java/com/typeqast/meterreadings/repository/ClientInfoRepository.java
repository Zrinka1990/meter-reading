package com.typeqast.meterreadings.repository;

import com.typeqast.meterreadings.model.ClientInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientInfoRepository extends CrudRepository<ClientInfo, Long> {

}
