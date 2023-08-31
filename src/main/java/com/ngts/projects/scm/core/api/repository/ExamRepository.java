package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExamRepository extends JpaRepository<Exam, Integer>, JpaSpecificationExecutor<Exam> {

}