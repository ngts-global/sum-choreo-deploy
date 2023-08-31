package com.ngts.projects.scm.core.api.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query ")
public class DormitoryQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer dormitoryId;

    private String name;

    private String numberOfRoom;

    private String description;

}
