package com.typeqast.meterreadings.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MeterReadingPrimaryKey implements Serializable {
    private String month;
    private Short year;
    private Long clientId;
}
