package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class CardAuthorizationDetailRes implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * id
     * string
     * Transaction id.
     */
    private String id;

    /**
     * original_id
     * string
     * Original transaction id. The original pre-authorized transaction id. Represents the same transaction. An authorization type of AUTH_REVERSAL will have this value.
     */
    private String originalId;

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
     * status
     * string
     * Enum: "SUCCESS" "DECLINED"
     * .
     */
    private String status;

    /**
     * merchant_category_code
     * string
     * Merchant category code
     */
    private String merchantCategoryCode;

    /**
     * merchant_name
     * string
     * Merchant name.
     */
    private String merchantName;

    /**
     * transaction_currency
     * string
     * Transaction currency(ISO 4217).
     */
    private String transactionCurrency;

    /**
     * transaction_amount
     * string
     * Transaction amount.
     */
    private String transactionAmount;

    /**
     * auth_type
     * string
     * Auth type AUTH, AUTH_REVERSAL.
     */
    private String authType;

    /**
     * failure_code
     * string
     * This field occurs when an declined occurs.
     */
    private String failureCode;

    /**
     * failure_reason
     * string
     * This field occurs when a declined occurs.
     */
    private String failureReason;

    /**
     * create_time
     * long
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date createTime;
}
