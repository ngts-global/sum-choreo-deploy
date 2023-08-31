package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ParentRepository extends JpaRepository<Parent, Integer>, JpaSpecificationExecutor<Parent> {

}