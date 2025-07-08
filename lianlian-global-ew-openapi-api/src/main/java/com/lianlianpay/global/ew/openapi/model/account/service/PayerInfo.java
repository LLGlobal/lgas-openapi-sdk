package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class PayerInfo implements Serializable {


    private static final long serialVersionUID = -1L;

    /**
     * payer_name
     * required
     * string <= 30 characters
     * Chinese spelling letters (PIN YIN) are used if Chinese names are submitted.
     * The first letter of the first name is capitalized. In Pinyin, the last name
     * is before the first name. In English, the last name is after the first name, separated by spaces.
     */
    private String payerName;

    /**
     * payer_id_type
     * required
     * string
     * Enum: "ID" "PASSPORT" "OTHER"
     * Payer id type
     */
    private String payerIdType;

    /**
     * payer_id_no
     * required
     * string <= 20 characters
     * Payer id no
     */
    private String payerIdNo;

    /**
     * payer_nationality
     * required
     * string <= 2 characters
     * The country code of payer’s nationality. a 2-letter code.
     */
    private String payerNationality;

    /**
     * payer_permanent_country
     * required
     * string <= 2 characters
     * The country code of permanent residence.
     */
    private String payerPermanentCountry;

    /**
     * payer_permanent_city
     * required
     * string <= 40 characters
     * City.
     */
    private String payerPermanentCity;

    /**
     * payer_permanent_address
     * required
     * string <= 80 characters
     * Address.
     */
    private String payerPermanentAddress;

    /**
     * payer_birthday
     * required
     * string <= 8 characters
     * Format: 'YYYYMMDD'
     */
    private String payerBirthday;
}
