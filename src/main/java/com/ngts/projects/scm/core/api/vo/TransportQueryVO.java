package com.ngts.projects.scm.core.api.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query ")
public class TransportQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer transportId;

    private String routeName;

    private String numberOfVehicle;

    private String description;

    private String routeFare;

}
