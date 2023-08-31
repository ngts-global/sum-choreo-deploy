package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class TeacherDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer teacherId;

    private String name;

    private String birthday;

    private String sex;

    private String religion;

    private String bloodGroup;

    private String address;

    private String phone;

    private String email;

    private String password;

}
