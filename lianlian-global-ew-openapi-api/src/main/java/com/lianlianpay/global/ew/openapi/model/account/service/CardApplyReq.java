package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class CardApplyReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * card_name
     * required
     * string <= 64 characters
     * Card name.
     */
    private String cardName;

    /**
     * contact_email
     * required
     * string
     * Contact email.If the mailbox is filled in. Card related notifications will be sent to this email address.
     */
    private String contactEmail;

    /**
     * currency
     * string
     * Enum: "USD" "EUR" "SGD" "HKD"
     * Settle currency.
     */
    private String currency;

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
