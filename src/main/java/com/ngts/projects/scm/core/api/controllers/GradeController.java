package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.GradeDTO;
import com.ngts.projects.scm.core.api.service.GradeService;
import com.ngts.projects.scm.core.api.vo.GradeQueryVO;
import com.ngts.projects.scm.core.api.vo.GradeUpdateVO;
import com.ngts.projects.scm.core.api.vo.GradeVO;
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
@RequestMapping("/scm/api/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody GradeVO vO) {
        return gradeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        gradeService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody GradeUpdateVO vO) {
        gradeService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public GradeDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return gradeService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<GradeDTO> query(@Valid GradeQueryVO vO) {
        return gradeService.query(vO);
    }
}
