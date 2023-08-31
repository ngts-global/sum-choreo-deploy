package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;


@Data
@ApiModel("Save ")
public class InvoiceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "invoiceId can not null")
    private Integer invoiceId;

    @NotNull(message = "studentId can not null")
    private Integer studentId;

    @NotNull(message = "addFee can not null")
    private Integer addFee;

    @NotNull(message = "securityFee can not null")
    private Integer securityFee;

    @NotNull(message = "tuitionFee can not null")
    private Integer tuitionFee;

    @NotNull(message = "annualFee can not null")
    private Integer annualFee;

    @NotNull(message = "stationaryFee can not null")
    private Integer stationaryFee;

    @NotNull(message = "multimediaFee can not null")
    private Integer multimediaFee;

    @NotNull(message = "others can not null")
    private Integer others;

    @NotNull(message = "amount can not null")
    private Integer amount;

    @NotNull(message = "creationTimestamp can not null")
    private Integer creationTimestamp;

    @NotNull(message = "dueDate can not null")
    private Date dueDate;

    @NotNull(message = "title can not null")
    private String title;

    @NotNull(message = "description can not null")
    private String description;

    @NotNull(message = "paymentTimestamp can not null")
    private String paymentTimestamp;

    @NotNull(message = "paymentMethod can not null")
    private String paymentMethod;

    @NotNull(message = "paymentDetails can not null")
    private String paymentDetails;


    /**
     * paid or unpaid
     */
    @NotNull(message = "status can not null")
    @ApiModelProperty("paid or unpaid")
    private String status;

}
