package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GradeRepository extends JpaRepository<Grade, Integer>, JpaSpecificationExecutor<Grade> {

}