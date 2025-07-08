package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/10/24
 */
@Data
public class AccountCreateReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * email
     * required
     * string <= 64 characters ^(([\w-\.\+]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,10}|[0-9]{1,3})(\]?))$])
     * Unique identifier for the Account.
     */
    private String email;

    /**
     * country_code
     * required
     * string
     * Enum: "US" "VN" "SG" "ID" "PH" "KH" "MY" "KR" "AU" "AE" "DE" "FR" "IT" "NL" "BE" "LU" "IE" "ES" "PT" "AT" "FI" "LT" "LV" "EE" "SK" "SI" "GR" "MT" "CY" "PL" "TH" "GB" "CN" "HK"
     * Two-letter ISO 3166-2 country code of counterparty.
     */
    private String countryCode;

    /**
     * entity_type
     * required
     * string
     * Enum: "CORPORATE" "INDIVIDUAL"
     * Entity type
     */
    private String entityType;

    /**
     * phone_district
     * string
     * Enum: "CN" "US" "MO" "CA" "KR" "AU" "GB" "DE" "SG" "FR" "IN" "IT" "RU" "MY" "NL" "SE" "MX" "ID" "NZ" "CH" "PH" "BE" "VN" "PL" "AT" "DK" "BR" "TH" "IL" "ZA" "UA" "AE" "FI" "CL" "PT
     * "NO" "TR" "AR" "IE" "MN" "BD" "EG" "SA" "PK" "PE" "HU" "CO" Hide
     * Mobile number area
     * CN +86 HK +852 US +1 TW +886 MO +853 CA +1
     * JP +81 KR +82 AU +61 GB +44 DE +49 SG +65
     * FR +33 IN +91 IT +39 RU +7 ES +34 MY +60
     * NL +31 SE +46 MX +52 ID +62 NZ +64 CH +41
     * PH +63 BE +32 VN +84 PL +48 AT +43 DK +45
     * BR +55 TH +66 IL +972 ZA +269 UA +380 AE +971
     * FI +358 CL +56 PT +351 NO +47 TR +90 AR +54
     * IE +353 MN +976 BD +880 EG +20 SA +966 PK +92
     * PE +51 HU +36 CO +57
     */
    private String phoneDistrict;

    /**
     * phone
     * string <= 11 characters ^[0-9]*$
     * The user's phone
     */
    private String phone;

    /**
     * identifier
     * required
     * string <= 64 characters
     * The identifier of the customer.
     */
    private String identifier;

    /**
     * agreed_to_terms_and_conditions
     * required
     * boolean
     * Agree to abide by LLG's terms and conditions.
     * true Agree to the agreement.false Disables creation.
     */
    private Boolean agreedToTermsAndConditions;

    /**
     * agreement_id
     * string <= 128 characters
     * As the agreement corresponding to the account.The agreement ID is the ID returned by the File Folder.
     */
    private String agreementId;

}
