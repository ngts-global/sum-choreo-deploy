package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class UsersDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String email;

    private String password;

    private String username;

}
