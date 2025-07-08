package com.lianlianpay.global.ew.openapi.model.account.payment;

import com.lianlianpay.global.ew.openapi.model.common.AdditionalInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/12/2
 */
@Data
public class NetworkAccountConnectReq implements Serializable {


    private static final long serialVersionUID = -1L;

    /**
     * Merchant ID as known by the client platform.
     */
    private String merchantClientId;

    /**
     * string <= 128 characters
     * Merchant name as known by the client platform.
     */
    private String merchantClientName;

    /**
     * Enum: "US" "VN" "SG" "ID" "PH" "KH" "MY" "KR" "AU" "AE" "DE" "FR" "IT" "NL" "BE" "LU" "IE" "ES" "PT" "AT" "FI" "LT" "LV" "EE" "SK" "SI" "GR" "MT" "CY" "PL" "TH" "GB" "CN" "HK"<br/>
     * Two-letter ISO 3166-2 country code of counterparty.<br/>
     */
    private String countryCode;

    /**
     * Value: "ECOMMERCE-SEND-PAYMENT"
     * Signing agreement type.
     */
    private String agreementType;

    /**
     * URL Lianlian will redirect to at the end of a successful signing process.
     */
    private String redirectUrl;

    /**
     * Additional info to be used by customer support if needed.<br/>
     * When agreement_type is ECOMMERCE-SEND-PAYMENT, 3 name keys are established.<br/>
     * cert_no:The Cert number of counterparty on client side.(If you want to verify consistency, you can pass this value.)<br/>
     * store_name:Store name as known by the calling platform.<br/>
     * shop_url:URL of merchant store if URL can’t be algorithmically produced from merchant_id.<br/>
     */
    private List<AdditionalInfo> additionalInfo;

}
