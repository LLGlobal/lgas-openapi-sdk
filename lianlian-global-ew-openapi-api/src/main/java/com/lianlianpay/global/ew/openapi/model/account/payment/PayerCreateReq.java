package com.lianlianpay.global.ew.openapi.model.account.payment;

import com.lianlianpay.global.ew.openapi.model.common.AdditionalInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/12/3
 */
@Data
public class PayerCreateReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * string <= 128 characters
     * Merchant ID as known by the client platform.
     */
    private String merchantClientId;

    /**
     * Enum: "INDIVIDUAL" "CORPORATE"
     * Payer type, one of INDIVIDUAL and CORPORATE
     */
    private String payerType;

    /**
     * payer name.
     */
    private String payerName;

    /**
     * string <= 18 characters
     * cert no.
     */
    private String certNo;

    /**
     * Enum: "ID_CARD" "NUM_LICENSE"
     * Cert type, one of ID_CARD and NUM_LICENSE
     */
    private String certType;

    /**
     * Two-letter ISO 3166-2 country code.
     */
    private String countryCode;

    /**
     * phone number.
     */
    private String phoneNumber;

    /**
     * phone district. Two-letter ISO 3166-2 country code.
     */
    private String phoneDistrict;

    /**
     * The ID of File Folder object.
     */
    private String fileFolderId;

    /**
     * object (Address)
     */
    private ContactAddress address;

    /**
     * additionalInfo
     * Array of item
     */
    private List<AdditionalInfo> additionalInfo;
}
