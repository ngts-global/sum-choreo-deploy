package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer>, JpaSpecificationExecutor<Attendance> {

}