package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.TeacherDTO;
import com.ngts.projects.scm.core.api.service.TeacherService;
import com.ngts.projects.scm.core.api.vo.TeacherQueryVO;
import com.ngts.projects.scm.core.api.vo.TeacherUpdateVO;
import com.ngts.projects.scm.core.api.vo.TeacherVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Api(tags = "")
@Validated
@RestController
@RequestMapping("/scm/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody TeacherVO vO) {
        return teacherService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        teacherService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody TeacherUpdateVO vO) {
        teacherService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public TeacherDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return teacherService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<TeacherDTO> query(@Valid TeacherQueryVO vO) {
        return teacherService.query(vO);
    }


    @GetMapping("/all")
    @ApiOperation("Retrieve all Teachers ")
    public List<TeacherDTO> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
}
