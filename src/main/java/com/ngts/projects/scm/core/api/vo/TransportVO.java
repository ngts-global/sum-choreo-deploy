package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class TransportVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "transportId can not null")
    private Integer transportId;

    @NotNull(message = "routeName can not null")
    private String routeName;

    @NotNull(message = "numberOfVehicle can not null")
    private String numberOfVehicle;

    @NotNull(message = "description can not null")
    private String description;

    @NotNull(message = "routeFare can not null")
    private String routeFare;

}
