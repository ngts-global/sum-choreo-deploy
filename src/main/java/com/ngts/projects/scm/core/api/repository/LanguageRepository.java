package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LanguageRepository extends JpaRepository<Language, Integer>, JpaSpecificationExecutor<Language> {

}