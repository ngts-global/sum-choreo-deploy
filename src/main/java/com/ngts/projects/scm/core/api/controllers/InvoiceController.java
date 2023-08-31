package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.InvoiceDTO;
import com.ngts.projects.scm.core.api.service.InvoiceService;
import com.ngts.projects.scm.core.api.vo.InvoiceQueryVO;
import com.ngts.projects.scm.core.api.vo.InvoiceUpdateVO;
import com.ngts.projects.scm.core.api.vo.InvoiceVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Api(tags = "")
@Validated
@RestController
@RequestMapping("/scm/api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody InvoiceVO vO) {
        return invoiceService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        invoiceService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody InvoiceUpdateVO vO) {
        invoiceService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public InvoiceDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return invoiceService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<InvoiceDTO> query(@Valid InvoiceQueryVO vO) {
        return invoiceService.query(vO);
    }
}
