package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class ClassVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "classId can not null")
    private Integer classId;

    @NotNull(message = "teacherId can not null")
    private Integer teacherId;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "nameNumeric can not null")
    private String nameNumeric;

}
