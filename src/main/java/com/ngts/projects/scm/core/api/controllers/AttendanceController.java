package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.AttendanceDTO;
import com.ngts.projects.scm.core.api.service.AttendanceService;
import com.ngts.projects.scm.core.api.vo.AttendanceQueryVO;
import com.ngts.projects.scm.core.api.vo.AttendanceUpdateVO;
import com.ngts.projects.scm.core.api.vo.AttendanceVO;
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
@RequestMapping("/scm/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody AttendanceVO vO) {
        return attendanceService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        attendanceService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody AttendanceUpdateVO vO) {
        attendanceService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public AttendanceDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return attendanceService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<AttendanceDTO> query(@Valid AttendanceQueryVO vO) {
        return attendanceService.query(vO);
    }
}
