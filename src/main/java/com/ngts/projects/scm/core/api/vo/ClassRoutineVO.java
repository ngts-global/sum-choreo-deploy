package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class ClassRoutineVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "classRoutineId can not null")
    private Integer classRoutineId;

    @NotNull(message = "classId can not null")
    private Integer classId;

    @NotNull(message = "subjectId can not null")
    private Integer subjectId;

    @NotNull(message = "timeStart can not null")
    private Integer timeStart;

    @NotNull(message = "timeEnd can not null")
    private Integer timeEnd;

    @NotNull(message = "day can not null")
    private String day;

}
