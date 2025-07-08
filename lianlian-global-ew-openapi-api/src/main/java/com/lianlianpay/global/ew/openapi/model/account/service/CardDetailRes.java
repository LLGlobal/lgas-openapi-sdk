package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class CardDetailRes implements Serializable {

    /**
     * card_id
     * string
     * Card id.
     *
     * card_name
     * string
     * Card name.
     *
     * contact_email
     * string
     * Contact email.
     *
     * currency
     * string
     * Currency.The limit is based on this currency.
     *
     * per_transaction_limit
     * string
     * Per transaction limit.Main currency unit, rounded up to 2 decimal places.
     *
     * daily_limit
     * string
     * Daily limit.Main currency unit, rounded up to 2 decimal places.
     *
     * monthly_limit
     * string
     * Monthly limit.Main currency unit, rounded up to 2 decimal places.
     *
     * accumulated_spend_limit
     * string
     * Accumulated spend limit.Main currency unit, rounded up to 2 decimal places.
     *
     * status
     * string
     * Enum: "APPLYING" "VALID" "CANCEL" "ABNORMAL" "EXPIRED" Hide
     * .
     *
     * card_number
     * string
     * Masked card number.
     *
     * create_time
     * long
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */

    /**
     * card_id
     * string
     * Card id.
     */
    private String cardId;

    /**
     * card_name
     * string
     * Card name.
     */
    private String cardName;

    /**
     * contact_email
     * string
     * Contact email.
     */
    private String contactEmail;

    /**
     * currency
     * string
     * Currency.The limit is based on this currency.
     */
    private String currency;

    /**
     * per_transaction_limit
     * string
     * Per transaction limit.Main currency unit, rounded up to 2 decimal places.
     */
    private String perTransactionLimit;

    /**
     * daily_limit
     * string
     * Daily limit.Main currency unit, rounded up to 2 decimal places.
     */
    private String dailyLimit;

    /**
     * monthly_limit
     * string
     * Monthly limit.Main currency unit, rounded up to 2 decimal places.
     */
    private String monthlyLimit;

    /**
     * accumulated_spend_limit
     * string
     * Accumulated spend limit.Main currency unit, rounded up to 2 decimal places.
     */
    private String accumulatedSpendLimit;

    /**
     * status
     * string
     * Enum: "APPLYING" "VALID" "CANCEL" "ABNORMAL" "EXPIRED"
     */
    private String status;

    /**
     * card_number
     * string
     * Masked card number.
     */
    private String cardNumber;

    /**
     * create_time
     * long
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date createTime;
}
