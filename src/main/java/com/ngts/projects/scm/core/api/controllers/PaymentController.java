package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.PaymentDTO;
import com.ngts.projects.scm.core.api.service.PaymentService;
import com.ngts.projects.scm.core.api.vo.PaymentQueryVO;
import com.ngts.projects.scm.core.api.vo.PaymentUpdateVO;
import com.ngts.projects.scm.core.api.vo.PaymentVO;
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
@RequestMapping("/scm/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody PaymentVO vO) {
        return paymentService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        paymentService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody PaymentUpdateVO vO) {
        paymentService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public PaymentDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return paymentService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<PaymentDTO> query(@Valid PaymentQueryVO vO) {
        return paymentService.query(vO);
    }
}
