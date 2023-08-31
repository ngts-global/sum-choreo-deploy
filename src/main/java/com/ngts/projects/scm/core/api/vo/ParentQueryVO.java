package com.ngts.projects.scm.core.api.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query ")
public class ParentQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer parentId;

    private Integer studentId;

    private String name;

    private String email;

    private String password;

    private String relationWithStudent;

    private String phone;

    private String address;

    private String profession;

}
