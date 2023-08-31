package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class TransportDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer transportId;

    private String routeName;

    private String numberOfVehicle;

    private String description;

    private String routeFare;

}
