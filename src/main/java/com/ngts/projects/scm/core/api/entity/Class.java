package com.ngts.projects.scm.core.api.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "class")
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "class_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;

    @Column(name = "teacher_id", nullable = false)
    private Integer teacherId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "name_numeric", nullable = false)
    private String nameNumeric;

}
