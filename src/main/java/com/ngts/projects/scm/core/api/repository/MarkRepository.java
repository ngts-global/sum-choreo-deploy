package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MarkRepository extends JpaRepository<Mark, Integer>, JpaSpecificationExecutor<Mark> {

}