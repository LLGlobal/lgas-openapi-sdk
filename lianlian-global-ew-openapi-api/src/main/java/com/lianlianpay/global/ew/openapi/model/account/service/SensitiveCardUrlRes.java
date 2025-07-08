package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class SensitiveCardUrlRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * card_id
     * String
     * Card id.
     */
    private String cardId;

    /**
     * card_name
     * String
     * Card name.
     */
    private String cardName;

    /**
     * contact_email
     * String
     * Contact email.
     */
    private String contactEmail;

    /**
     * currency
     * String
     * Currency.The limit is based on this currency.
     */
    private String currency;

    /**
     * status
     * String
     * Enum: "APPLYING" "VALID" "CANCEL" "ABNORMAL" "EXPIRED"
     */
    private String status;

    /**
     * card_number
     * String
     * Masked card number
     */
    private String cardNumber;

    /**
     * return_url
     * String
     * The URL where the user is redirected after he or she approves the Retrieve sensitive detail.
     */
    private String returnUrl;

    /**
     * create_time
     * Long
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date createTime;
}
