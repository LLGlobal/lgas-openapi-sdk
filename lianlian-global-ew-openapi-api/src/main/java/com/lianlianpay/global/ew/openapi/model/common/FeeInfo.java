package com.lianlianpay.global.ew.openapi.model.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/3
 */
@Data
public class FeeInfo implements Serializable {

    /**
     * The payout fee currency (in three-letter ISO 4217 format).
     */
    private String currency;

    /**
     * The payout fee amount.
     */
    private String amount;

    /**
     * The payout fee paid by.
     * Enum : "PAYER" or "PAYEE"
     */
    private String paidBy;
}
