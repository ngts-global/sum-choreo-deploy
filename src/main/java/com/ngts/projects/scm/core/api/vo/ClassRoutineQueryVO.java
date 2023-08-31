package com.ngts.projects.scm.core.api.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query ")
public class ClassRoutineQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer classRoutineId;

    private Integer classId;

    private Integer subjectId;

    private Integer timeStart;

    private Integer timeEnd;

    private String day;

}
