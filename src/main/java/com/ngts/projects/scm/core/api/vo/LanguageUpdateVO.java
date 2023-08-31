package com.ngts.projects.scm.core.api.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update ")
@EqualsAndHashCode(callSuper = false)
public class LanguageUpdateVO extends LanguageVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
