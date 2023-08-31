package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.UsersDTO;
import com.ngts.projects.scm.core.api.service.UsersService;
import com.ngts.projects.scm.core.api.vo.UsersQueryVO;
import com.ngts.projects.scm.core.api.vo.UsersUpdateVO;
import com.ngts.projects.scm.core.api.vo.UsersVO;
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
@RequestMapping("/scm/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody UsersVO vO) {
        return usersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        usersService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UsersUpdateVO vO) {
        usersService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public UsersDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return usersService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<UsersDTO> query(@Valid UsersQueryVO vO) {
        return usersService.query(vO);
    }
}
