package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class GradeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "gradeId can not null")
    private Integer gradeId;

    @NotNull(message = "markFrom can not null")
    private Integer markFrom;

    @NotNull(message = "markUpto can not null")
    private Integer markUpto;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "gradePoint can not null")
    private String gradePoint;

    @NotNull(message = "comment can not null")
    private String comment;

}
