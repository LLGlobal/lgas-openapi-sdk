package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class CardSettlementDetailRes implements Serializable {


    private static final long serialVersionUID = -1L;

    /**
     * Transaction id.
     */
    private String id;

    /**
     * Original transaction id.The original pre-authorized transaction id. Represents the same transaction.
     */
    private String originalId;

    /**
     * Card id.
     */
    private String cardId;

    /**
     * Card name.
     */
    private String cardName;

    /**
     * Enum: "PROCESSING" "SUCCESS"
     */
    private String status;

    /**
     * Merchant category code
     */
    private String merchantCategoryCode;

    /**
     * Merchant name.
     */
    private String merchantName;

    /**
     * Transaction currency(ISO 4217).
     */
    private String transactionCurrency;

    /**
     * Transaction amount.
     */
    private String transactionAmount;

    /**
     * Auth type SETTLE, SETTLE_REVERSE.
     */
    private String settlementType;

    /**
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date createTime;
}
