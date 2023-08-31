package com.ngts.projects.scm.core.api.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "transport")
public class Transport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "transport_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transportId;

    @Column(name = "route_name", nullable = false)
    private String routeName;

    @Column(name = "number_of_vehicle", nullable = false)
    private String numberOfVehicle;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "route_fare", nullable = false)
    private String routeFare;

}
