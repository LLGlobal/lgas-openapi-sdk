package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/3
 */
@Data
public class RequestPaymentCancelRes implements Serializable {

    /**
     * result
     */
    private Boolean result;
}
