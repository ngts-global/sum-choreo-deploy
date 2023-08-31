package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class MarkVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "markId can not null")
    private Integer markId;

    @NotNull(message = "studentId can not null")
    private Integer studentId;

    @NotNull(message = "subjectId can not null")
    private Integer subjectId;

    @NotNull(message = "classId can not null")
    private Integer classId;

    @NotNull(message = "examId can not null")
    private Integer examId;

    @NotNull(message = "markObtained can not null")
    private Integer markObtained;

    @NotNull(message = "markTotal can not null")
    private Integer markTotal;

    @NotNull(message = "attendance can not null")
    private Integer attendance;

    @NotNull(message = "comment can not null")
    private String comment;

}
