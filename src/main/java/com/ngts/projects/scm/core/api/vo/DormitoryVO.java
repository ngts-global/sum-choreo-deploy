package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class DormitoryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "dormitoryId can not null")
    private Integer dormitoryId;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "numberOfRoom can not null")
    private String numberOfRoom;

    @NotNull(message = "description can not null")
    private String description;

}
