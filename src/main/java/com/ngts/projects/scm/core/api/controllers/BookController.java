package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.dto.BookDTO;
import com.ngts.projects.scm.core.api.service.BookService;
import com.ngts.projects.scm.core.api.vo.BookQueryVO;
import com.ngts.projects.scm.core.api.vo.BookUpdateVO;
import com.ngts.projects.scm.core.api.vo.BookVO;
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
@RequestMapping("/scm/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody BookVO vO) {
        return bookService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        bookService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody BookUpdateVO vO) {
        bookService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public BookDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return bookService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<BookDTO> query(@Valid BookQueryVO vO) {
        return bookService.query(vO);
    }
}
