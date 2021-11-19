package com.typeqast.meterreadings.model;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ClientInfo {
    @Id
    private String client;

    @Column(unique=true)
    private String address;

    @OneToMany(mappedBy = "client")
    private Set<Meter> meter;
}
