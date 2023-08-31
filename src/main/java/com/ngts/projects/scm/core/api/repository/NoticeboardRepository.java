package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Noticeboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NoticeboardRepository extends JpaRepository<Noticeboard, Integer>, JpaSpecificationExecutor<Noticeboard> {

}