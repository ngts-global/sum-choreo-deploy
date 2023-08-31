package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class ExamVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "examId can not null")
    private Integer examId;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "date can not null")
    private String date;

    @NotNull(message = "comment can not null")
    private String comment;

}
