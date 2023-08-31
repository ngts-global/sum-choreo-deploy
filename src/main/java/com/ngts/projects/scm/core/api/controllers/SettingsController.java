package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.SettingsDTO;
import com.ngts.projects.scm.core.api.service.SettingsService;
import com.ngts.projects.scm.core.api.vo.SettingsQueryVO;
import com.ngts.projects.scm.core.api.vo.SettingsUpdateVO;
import com.ngts.projects.scm.core.api.vo.SettingsVO;
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
@RequestMapping("/scm/api/settings")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody SettingsVO vO) {
        return settingsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        settingsService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody SettingsUpdateVO vO) {
        settingsService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public SettingsDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return settingsService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<SettingsDTO> query(@Valid SettingsQueryVO vO) {
        return settingsService.query(vO);
    }
}
