package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.LanguageDTO;
import com.ngts.projects.scm.core.api.service.LanguageService;
import com.ngts.projects.scm.core.api.vo.LanguageQueryVO;
import com.ngts.projects.scm.core.api.vo.LanguageUpdateVO;
import com.ngts.projects.scm.core.api.vo.LanguageVO;
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
@RequestMapping("/scm/api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody LanguageVO vO) {
        return languageService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        languageService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody LanguageUpdateVO vO) {
        languageService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public LanguageDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return languageService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<LanguageDTO> query(@Valid LanguageQueryVO vO) {
        return languageService.query(vO);
    }
}
