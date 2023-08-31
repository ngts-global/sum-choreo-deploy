package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer bookId;

    private String name;

    private String description;

    private String author;

    private String classId;

    private String status;

    private String price;

}
