package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/4/11
 */
@Data
public class PayerDisconnectRes implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean result;
}
