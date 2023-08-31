package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class LanguageDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer phraseId;

    private String phrase;

    private String english;

}
