package com.ngts.projects.scm.core.api.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "admin_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "level", nullable = false)
    private String level;

}
