package com.ngts.projects.scm.core.api.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "language")
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "phrase_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer phraseId;

    @Column(name = "phrase", nullable = false)
    private String phrase;

    @Column(name = "english", nullable = false)
    private String english;

}
