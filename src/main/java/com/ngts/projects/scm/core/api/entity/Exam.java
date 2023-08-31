package com.ngts.projects.scm.core.api.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "exam")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "exam_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "comment", nullable = false)
    private String comment;

}
