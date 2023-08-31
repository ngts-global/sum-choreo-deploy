package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.ParentDTO;
import com.ngts.projects.scm.core.api.service.ParentService;
import com.ngts.projects.scm.core.api.vo.ParentQueryVO;
import com.ngts.projects.scm.core.api.vo.ParentUpdateVO;
import com.ngts.projects.scm.core.api.vo.ParentVO;
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
@RequestMapping("/scm/api/parent")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody ParentVO vO) {
        return parentService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        parentService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ParentUpdateVO vO) {
        parentService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public ParentDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return parentService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<ParentDTO> query(@Valid ParentQueryVO vO) {
        return parentService.query(vO);
    }
}
