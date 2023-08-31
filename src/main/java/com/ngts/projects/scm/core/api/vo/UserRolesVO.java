package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class UserRolesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "roleId can not null")
    private Integer roleId;

    private Long userId;

}
