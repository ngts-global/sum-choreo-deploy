package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.ClassRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClassRoutineRepository extends JpaRepository<ClassRoutine, Integer>, JpaSpecificationExecutor<ClassRoutine> {

}