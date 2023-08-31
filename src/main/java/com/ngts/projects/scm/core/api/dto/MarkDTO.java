package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class MarkDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer markId;

    private Integer studentId;

    private Integer subjectId;

    private Integer classId;

    private Integer examId;

    private Integer markObtained;

    private Integer markTotal;

    private Integer attendance;

    private String comment;

}
