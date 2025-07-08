package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class CardLimitSetReq implements Serializable {

    private static final long serialVersionUID = -1L;


    /**
     * card_name
     * required
     * string
     * Card name.
     */
    private String cardId;

    /**
     * per_transaction_limit
     * required
     * string
     * Per transaction limit.Main currency unit, rounded up to 2 decimal places.
     */
    private String perTransactionLimit;

    /**
     * daily_limit
     * required
     * string
     * Daily limit.Main currency unit, rounded up to 2 decimal places.
     */
    private String dailyLimit;

    /**
     * monthly_limit
     * required
     * string
     * Monthly limit.Main currency unit, rounded up to 2 decimal places.
     */
    private String monthlyLimit;

    /**
     * accumulated_spend_limit
     * required
     * string
     * Accumulated spend limit.Main currency unit, rounded up to 2 decimal places.
     */
    private String accumulatedSpendLimit;
}
