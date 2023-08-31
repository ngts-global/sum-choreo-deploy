package com.ngts.projects.scm.core.api.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query ")
public class GradeQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer gradeId;

    private Integer markFrom;

    private Integer markUpto;

    private String name;

    private String gradePoint;

    private String comment;

}
