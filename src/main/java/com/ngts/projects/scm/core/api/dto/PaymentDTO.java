package com.ngts.projects.scm.core.api.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class PaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer paymentId;

    private Integer invoiceId;

    private Integer studentId;

    private Integer amount;

    private Integer timestamp;

    private String paymentType;

    private String transactionId;

    private String method;

    private String description;

}
