package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.ClassRoutineDTO;
import com.ngts.projects.scm.core.api.service.ClassRoutineService;
import com.ngts.projects.scm.core.api.vo.ClassRoutineQueryVO;
import com.ngts.projects.scm.core.api.vo.ClassRoutineUpdateVO;
import com.ngts.projects.scm.core.api.vo.ClassRoutineVO;
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
@RequestMapping("/scm/api/classRoutine")
public class ClassRoutineController {

    @Autowired
    private ClassRoutineService classRoutineService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody ClassRoutineVO vO) {
        return classRoutineService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        classRoutineService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ClassRoutineUpdateVO vO) {
        classRoutineService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public ClassRoutineDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return classRoutineService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<ClassRoutineDTO> query(@Valid ClassRoutineQueryVO vO) {
        return classRoutineService.query(vO);
    }
}
