package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Users;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users, Integer> {

    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}