package com.ngts.projects.scm.core.api.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "grade")
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "grade_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeId;

    @Column(name = "mark_from", nullable = false)
    private Integer markFrom;

    @Column(name = "mark_upto", nullable = false)
    private Integer markUpto;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "grade_point", nullable = false)
    private String gradePoint;

    @Column(name = "comment", nullable = false)
    private String comment;

}
