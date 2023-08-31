package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class DormitoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer dormitoryId;

    private String name;

    private String numberOfRoom;

    private String description;

}
