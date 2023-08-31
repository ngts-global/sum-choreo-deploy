package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@ApiModel("")
public class InvoiceDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer invoiceId;

    private Integer studentId;

    private Integer addFee;

    private Integer securityFee;

    private Integer tuitionFee;

    private Integer annualFee;

    private Integer stationaryFee;

    private Integer multimediaFee;

    private Integer others;

    private Integer amount;

    private Integer creationTimestamp;

    private Date dueDate;

    private String title;

    private String description;

    private String paymentTimestamp;

    private String paymentMethod;

    private String paymentDetails;


    /**
     * paid or unpaid
     */
    @ApiModelProperty("paid or unpaid")
    private String status;

}
