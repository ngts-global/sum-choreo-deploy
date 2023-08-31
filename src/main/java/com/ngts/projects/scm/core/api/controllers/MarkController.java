package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.MarkDTO;
import com.ngts.projects.scm.core.api.service.MarkService;
import com.ngts.projects.scm.core.api.vo.MarkQueryVO;
import com.ngts.projects.scm.core.api.vo.MarkUpdateVO;
import com.ngts.projects.scm.core.api.vo.MarkVO;
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
@RequestMapping("/scm/api/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody MarkVO vO) {
        return markService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        markService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody MarkUpdateVO vO) {
        markService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public MarkDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return markService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<MarkDTO> query(@Valid MarkQueryVO vO) {
        return markService.query(vO);
    }
}
