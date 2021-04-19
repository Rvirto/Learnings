package com.uol.client.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "client")
public class Client {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @NotNull
    private String name;

    @NotNull
    private Long age;

    @NotNull
    private String ipCreation;

    @NotNull
    private String locationGeographic;

    @NotNull
    private String maxTemperature;

    @NotNull
    private String minTemperature;
}
