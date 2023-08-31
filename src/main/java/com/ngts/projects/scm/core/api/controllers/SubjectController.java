package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.SubjectDTO;
import com.ngts.projects.scm.core.api.service.SubjectService;
import com.ngts.projects.scm.core.api.vo.SubjectQueryVO;
import com.ngts.projects.scm.core.api.vo.SubjectUpdateVO;
import com.ngts.projects.scm.core.api.vo.SubjectVO;
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
@RequestMapping("/scm/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody SubjectVO vO) {
        return subjectService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        subjectService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody SubjectUpdateVO vO) {
        subjectService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public SubjectDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return subjectService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<SubjectDTO> query(@Valid SubjectQueryVO vO) {
        return subjectService.query(vO);
    }
}
