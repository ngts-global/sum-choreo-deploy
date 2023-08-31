package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.RolesDTO;
import com.ngts.projects.scm.core.api.service.RolesService;
import com.ngts.projects.scm.core.api.vo.RolesQueryVO;
import com.ngts.projects.scm.core.api.vo.RolesUpdateVO;
import com.ngts.projects.scm.core.api.vo.RolesVO;
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
@RequestMapping("/scm/api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody RolesVO vO) {
        return rolesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        rolesService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody RolesUpdateVO vO) {
        rolesService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public RolesDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return rolesService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<RolesDTO> query(@Valid RolesQueryVO vO) {
        return rolesService.query(vO);
    }
}
