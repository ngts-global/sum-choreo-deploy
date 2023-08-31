package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DormitoryRepository extends JpaRepository<Dormitory, Integer>, JpaSpecificationExecutor<Dormitory> {

}