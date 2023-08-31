package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class UsersVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "email can not null")
    private String email;

    @NotNull(message = "password can not null")
    private String password;

    @NotNull(message = "username can not null")
    private String username;

}
