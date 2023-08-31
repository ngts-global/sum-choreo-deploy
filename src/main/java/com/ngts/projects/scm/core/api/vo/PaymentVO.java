package com.ngts.projects.scm.core.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class PaymentVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "paymentId can not null")
    private Integer paymentId;

    @NotNull(message = "invoiceId can not null")
    private Integer invoiceId;

    @NotNull(message = "studentId can not null")
    private Integer studentId;

    @NotNull(message = "amount can not null")
    private Integer amount;

    @NotNull(message = "timestamp can not null")
    private Integer timestamp;

    @NotNull(message = "paymentType can not null")
    private String paymentType;

    @NotNull(message = "transactionId can not null")
    private String transactionId;

    @NotNull(message = "method can not null")
    private String method;

    @NotNull(message = "description can not null")
    private String description;

}
