package com.ngts.projects.scm.core.api.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "class_routine")
public class ClassRoutine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_routine_id", nullable = false)
    private Integer classRoutineId;

    @Column(name = "class_id", nullable = false)
    private Integer classId;

    @Column(name = "subject_id", nullable = false)
    private Integer subjectId;

    @Column(name = "time_start", nullable = false)
    private Integer timeStart;

    @Column(name = "time_end", nullable = false)
    private Integer timeEnd;

    @Column(name = "day", nullable = false)
    private String day;

}
