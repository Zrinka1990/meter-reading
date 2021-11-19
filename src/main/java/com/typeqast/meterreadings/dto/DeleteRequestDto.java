package com.typeqast.meterreadings.dto;

import lombok.Data;

@Data
public class DeleteRequestDto {
    private Long clientId;
    private String month;
    private Short year;
}
