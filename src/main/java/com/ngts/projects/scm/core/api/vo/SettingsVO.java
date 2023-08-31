package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class SettingsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "settingsId can not null")
    private Integer settingsId;

    @NotNull(message = "type can not null")
    private String type;

    @NotNull(message = "description can not null")
    private String description;

}
