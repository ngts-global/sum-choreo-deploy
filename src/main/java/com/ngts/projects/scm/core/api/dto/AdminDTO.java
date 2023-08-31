package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class AdminDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer adminId;

    private String name;

    private String email;

    private String password;

    private String level;

}
