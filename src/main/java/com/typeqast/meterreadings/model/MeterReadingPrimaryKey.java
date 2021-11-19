package com.typeqast.meterreadings.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
//@AllArgsConstructor
public class MeterReadingPrimaryKey implements Serializable {
    private String month;
    private Short year;
    private Long clientId;
}
