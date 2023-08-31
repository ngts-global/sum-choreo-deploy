package com.ngts.projects.scm.core.api.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update ")
@EqualsAndHashCode(callSuper = false)
public class ExamUpdateVO extends ExamVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
