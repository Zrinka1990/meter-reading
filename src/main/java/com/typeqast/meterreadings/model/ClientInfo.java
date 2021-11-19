package com.typeqast.meterreadings.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client", uniqueConstraints = { @UniqueConstraint(columnNames = { "address"}) })

@Getter
@Setter
@NoArgsConstructor
public class ClientInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long clientId;

    private String clientName;

    @Column(unique=true)
    private String address;

    @OneToMany(mappedBy = "clientId")
    private Set<MeterReading> meter;
}
