package com.typeqast.meterreadings.api.rest.restinterface;

import com.typeqast.meterreadings.dto.ClientInfoRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("meter-reading-api/client")
public interface IClientInfoRest {
    @PostMapping("/create")
    void createClient(@RequestBody ClientInfoRequestDto dto);
}
