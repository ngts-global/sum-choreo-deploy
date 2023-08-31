package com.ngts.projects.scm.core.api.controllers;

import com.ngts.projects.scm.core.api.payload.response.MessageResponse;
import com.ngts.projects.scm.core.api.service.StudentService;
import com.ngts.projects.scm.core.api.vo.StudentUpdateVO;
import com.ngts.projects.scm.core.api.vo.StudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.NoSuchElementException;

@Api(tags = "Students API")
@Validated
@RestController
@RequestMapping("/scm/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @ApiOperation("Save ")
    @PreAuthorize("hasRole('ADMIN')")
    public String save(@Valid @RequestBody StudentVO vO) {
        return studentService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody StudentUpdateVO vO) {
        studentService.update(id, vO);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Retrieve by ID ")
    public ResponseEntity<?>  getById(@Valid @NotNull @PathVariable("id") Integer id) {
        try {
             return ResponseEntity.badRequest().body(studentService.getById(id));
        }catch(NoSuchElementException exception) {
            return ResponseEntity.badRequest().body(new MessageResponse("Student Id not Found !"));
        }

    }

    /*
        @GetMapping
        @PreAuthorize("hasRole('ADMIN')")
        @ApiOperation("Retrieve by query ")
        public Page<StudentDTO> query(@Valid StudentQueryVO vO) {
            return studentService.query(vO);
        }
    */
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("Retrieve all students ")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.badRequest().body(studentService.getAllStudents());
    }


}
