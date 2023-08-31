package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class NoticeboardVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "noticeId can not null")
    private Integer noticeId;

    @NotNull(message = "createTimestamp can not null")
    private Integer createTimestamp;

    @NotNull(message = "noticeTitle can not null")
    private String noticeTitle;

    @NotNull(message = "notice can not null")
    private String notice;

}
