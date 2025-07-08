package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/4/1
 */
@Data
public class BankAccountVerificationValidateReq implements Serializable {


    /**
     * Request id in the verification request.
     */
    private String requestId;


    /**
     * micro amount in the payment.
     */
    private String amount;
}
