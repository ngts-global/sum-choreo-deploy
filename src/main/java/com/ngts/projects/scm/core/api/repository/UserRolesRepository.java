package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer>, JpaSpecificationExecutor<UserRoles> {

}