package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransportRepository extends JpaRepository<Transport, Integer>, JpaSpecificationExecutor<Transport> {

}