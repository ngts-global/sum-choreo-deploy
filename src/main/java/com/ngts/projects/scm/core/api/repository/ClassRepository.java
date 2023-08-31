package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClassRepository extends JpaRepository<Class, Integer>, JpaSpecificationExecutor<Class> {

}