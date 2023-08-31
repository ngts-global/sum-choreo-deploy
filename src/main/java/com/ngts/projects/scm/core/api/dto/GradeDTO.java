package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class GradeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer gradeId;

    private Integer markFrom;

    private Integer markUpto;

    private String name;

    private String gradePoint;

    private String comment;

}
