package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SettingsRepository extends JpaRepository<Settings, Integer>, JpaSpecificationExecutor<Settings> {

}