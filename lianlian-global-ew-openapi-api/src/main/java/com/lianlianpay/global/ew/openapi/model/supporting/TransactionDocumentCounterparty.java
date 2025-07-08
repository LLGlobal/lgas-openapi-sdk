package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/4/29
 */
@Data
public class TransactionDocumentCounterparty implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * name
     * string
     * Name of the counterparty, corporate name or name of an individual.
     */
    private String name;

    /**
     * country_code
     * string
     * Enum: "US" "VN" "SG" "ID" "PH" "KH" "MY" "KR" "AU" "AE" "DE" "FR" "IT" "NL" "BE" "LU" "IE" "ES" "PT" "AT" "FI" "LT" "LV" "EE" "SK" "SI" "GR" "MT" "CY" "PL" "TH" "GB" "CN" "HK"
     * Two-letter ISO 3166-2 country code of counterparty.
     */
    private String countryCode;
}
