package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.ClassDTO;
import com.ngts.projects.scm.core.api.service.ClassService;
import com.ngts.projects.scm.core.api.vo.ClassQueryVO;
import com.ngts.projects.scm.core.api.vo.ClassUpdateVO;
import com.ngts.projects.scm.core.api.vo.ClassVO;
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
@RequestMapping("/scm/api/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody ClassVO vO) {
        return classService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        classService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ClassUpdateVO vO) {
        classService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public ClassDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return classService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<ClassDTO> query(@Valid ClassQueryVO vO) {
        return classService.query(vO);
    }
}
