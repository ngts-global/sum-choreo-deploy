package com.ngts.projects.scm.core.api.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "subject_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;

    @Column(name = "class_id", nullable = false)
    private Integer classId;

    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "name", nullable = false)
    private String name;

}
