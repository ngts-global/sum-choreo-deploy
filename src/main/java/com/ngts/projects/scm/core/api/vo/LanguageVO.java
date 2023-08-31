package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class LanguageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "phraseId can not null")
    private Integer phraseId;

    @NotNull(message = "phrase can not null")
    private String phrase;

    @NotNull(message = "english can not null")
    private String english;

}
