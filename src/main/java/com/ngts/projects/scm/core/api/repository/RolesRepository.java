package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.ERole;
import com.ngts.projects.scm.core.api.entity.Roles;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface RolesRepository extends CrudRepository<Roles, Integer> {

    Optional<Roles> findByName(ERole name);
}