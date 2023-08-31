package com.ngts.projects.scm.core.api.repository;

import com.ngts.projects.scm.core.api.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>, JpaSpecificationExecutor<Invoice> {

}