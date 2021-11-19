package com.typeqast.meterreadings.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MonthYearId implements Serializable {
    private String month;
    private Short year;
}
