package com.ngts.projects.scm.core.api.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "dormitory")
public class Dormitory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dormitory_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dormitoryId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "number_of_room", nullable = false)
    private String numberOfRoom;

    @Column(name = "description", nullable = false)
    private String description;

}
