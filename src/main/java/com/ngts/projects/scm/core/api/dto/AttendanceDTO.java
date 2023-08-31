package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@ApiModel("")
public class AttendanceDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer attendanceId;


    /**
     * 0 undefined , 1 present , 2  absent
     */
    @ApiModelProperty("0 undefined , 1 present , 2  absent")
    private Integer status;

    private Integer studentId;

    private Date date;

}
