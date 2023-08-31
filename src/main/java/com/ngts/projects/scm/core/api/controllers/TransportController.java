package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.TransportDTO;
import com.ngts.projects.scm.core.api.service.TransportService;
import com.ngts.projects.scm.core.api.vo.TransportQueryVO;
import com.ngts.projects.scm.core.api.vo.TransportUpdateVO;
import com.ngts.projects.scm.core.api.vo.TransportVO;
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
@RequestMapping("/scm/api/transport")
public class TransportController {

    @Autowired
    private TransportService transportService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody TransportVO vO) {
        return transportService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        transportService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody TransportUpdateVO vO) {
        transportService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public TransportDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return transportService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<TransportDTO> query(@Valid TransportQueryVO vO) {
        return transportService.query(vO);
    }
}
