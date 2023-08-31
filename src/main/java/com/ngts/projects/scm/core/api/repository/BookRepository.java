package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

}