package com.typeqast.meterreadings.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name = "meter")
@IdClass(MonthYearId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeterReading {
    @Id
    private String month;

    @Id
    private Short year;

    private Integer energyConsumptionKwH;

    private Long clientId;
}
