package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubjectRepository extends JpaRepository<Subject, Integer>, JpaSpecificationExecutor<Subject> {

}