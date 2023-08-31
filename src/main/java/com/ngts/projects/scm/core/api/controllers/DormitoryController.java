package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.DormitoryDTO;
import com.ngts.projects.scm.core.api.service.DormitoryService;
import com.ngts.projects.scm.core.api.vo.DormitoryQueryVO;
import com.ngts.projects.scm.core.api.vo.DormitoryUpdateVO;
import com.ngts.projects.scm.core.api.vo.DormitoryVO;
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
@RequestMapping("/scm/api/dormitory")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody DormitoryVO vO) {
        return dormitoryService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        dormitoryService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody DormitoryUpdateVO vO) {
        dormitoryService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public DormitoryDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return dormitoryService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<DormitoryDTO> query(@Valid DormitoryQueryVO vO) {
        return dormitoryService.query(vO);
    }
}
