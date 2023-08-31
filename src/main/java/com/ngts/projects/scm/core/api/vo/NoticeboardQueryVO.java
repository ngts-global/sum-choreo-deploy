package com.ngts.projects.scm.core.api.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query ")
public class NoticeboardQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer noticeId;

    private Integer createTimestamp;

    private String noticeTitle;

    private String notice;

}
