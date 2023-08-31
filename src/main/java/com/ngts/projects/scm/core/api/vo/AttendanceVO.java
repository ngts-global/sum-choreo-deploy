package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;


@Data
@ApiModel("Save ")
public class AttendanceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "attendanceId can not null")
    private Integer attendanceId;


    /**
     * 0 undefined , 1 present , 2  absent
     */
    @NotNull(message = "status can not null")
    @ApiModelProperty("0 undefined , 1 present , 2  absent")
    private Integer status;

    @NotNull(message = "studentId can not null")
    private Integer studentId;

    @NotNull(message = "date can not null")
    private Date date;

}
