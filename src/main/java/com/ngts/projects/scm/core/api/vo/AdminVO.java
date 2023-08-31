package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class AdminVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "adminId can not null")
    private Integer adminId;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "email can not null")
    private String email;

    @NotNull(message = "password can not null")
    private String password;

    @NotNull(message = "level can not null")
    private String level;

}
