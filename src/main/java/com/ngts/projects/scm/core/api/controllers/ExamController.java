package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.ExamDTO;
import com.ngts.projects.scm.core.api.service.ExamService;
import com.ngts.projects.scm.core.api.vo.ExamQueryVO;
import com.ngts.projects.scm.core.api.vo.ExamUpdateVO;
import com.ngts.projects.scm.core.api.vo.ExamVO;
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
@RequestMapping("/scm/api/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody ExamVO vO) {
        return examService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        examService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ExamUpdateVO vO) {
        examService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public ExamDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return examService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<ExamDTO> query(@Valid ExamQueryVO vO) {
        return examService.query(vO);
    }
}
