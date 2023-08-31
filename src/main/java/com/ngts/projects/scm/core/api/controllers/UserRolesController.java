package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.UserRolesDTO;
import com.ngts.projects.scm.core.api.service.UserRolesService;
import com.ngts.projects.scm.core.api.vo.UserRolesQueryVO;
import com.ngts.projects.scm.core.api.vo.UserRolesUpdateVO;
import com.ngts.projects.scm.core.api.vo.UserRolesVO;
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
@RequestMapping("/scm/api/userRoles")
public class UserRolesController {

    @Autowired
    private UserRolesService userRolesService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody UserRolesVO vO) {
        return userRolesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userRolesService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserRolesUpdateVO vO) {
        userRolesService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public UserRolesDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userRolesService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<UserRolesDTO> query(@Valid UserRolesQueryVO vO) {
        return userRolesService.query(vO);
    }
}
