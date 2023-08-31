package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.NoticeboardDTO;
import com.ngts.projects.scm.core.api.service.NoticeboardService;
import com.ngts.projects.scm.core.api.vo.NoticeboardQueryVO;
import com.ngts.projects.scm.core.api.vo.NoticeboardUpdateVO;
import com.ngts.projects.scm.core.api.vo.NoticeboardVO;
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
@RequestMapping("/scm/api/noticeboard")
public class NoticeboardController {

    @Autowired
    private NoticeboardService noticeboardService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody NoticeboardVO vO) {
        return noticeboardService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        noticeboardService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody NoticeboardUpdateVO vO) {
        noticeboardService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public NoticeboardDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return noticeboardService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<NoticeboardDTO> query(@Valid NoticeboardQueryVO vO) {
        return noticeboardService.query(vO);
    }
}
