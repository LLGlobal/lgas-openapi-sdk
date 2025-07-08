package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class SensitiveCardDetailRes implements Serializable {

    private static final long serialVersionUID = -1L;

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
     * card_number
     * string
     * Card Number.
     */
    private String cardNumber;

    /**
     * currency
     * string
     * Currency.The limit is based on this currency.
     */
    private String currency;

    /**
     * cvv
     * string
     * Card Verification Value.
     */
    private String cvv;

    /**
     * expiry_date
     * string
     * Expiry date. example:12/29
     */
    private String expiryDate;
}
