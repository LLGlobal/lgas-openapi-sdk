package com.lianlianpay.global.ew.openapi.model.acceptance.payment.online;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/11/25
 */
@Data
public class PaymentRequestCancelRes implements Serializable {


    /**
     * result
     */
    private Boolean result;
}
