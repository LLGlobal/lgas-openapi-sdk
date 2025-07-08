package com.lianlianpay.global.ew.openapi.model.account.payment;

import com.lianlianpay.global.ew.openapi.model.common.AdditionalInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/10/21
 */
@Data
public class BankAccountRes implements Serializable {

    private static final long serialVersionUID = -1L;


    /**
     * Unique identifier for the Bank Account.
     */
    private String id;

    /**
     * Enum: "CORPORATE" "INDIVIDUAL"
     * Payee type, one of INDIVIDUAL and CORPORATE
     */
    private String entityType;

    /**
     * Two-letter ISO 3166-2 country code.
     */
    private String countryCode;

    /**
     * Mandatory if payee_type = INDIVIDUAL.
     */
    private String email;

    /**
     * name.
     * If empty, bank_account_detail.account_holder_name will be used by default.
     */
    private String name;

    /**
     * Merchant ID as known by the client platform.
     */
    private String merchantClientId;

    /**
     * Payer merchant ID as known by the client platform.
     */
    private String payerMerchantClientId;

    /**
     * Address
     */
    private ContactAddress address;

    /**
     * For required fields you can use this endpoint:
     */
    private ContactBankInfo bankAccountDetail;

    /**
     * When the country/region is CN, the following information needs to be filled .
     * cert_no: is When the type is INDIVIDUAL, fill in the personal identification number (ID_CARD). CORPORATE supports USCC (Uniform Social Credit Code)
     * cert_type: is When the type is INDIVIDUAL, fill in the ID_CARD. CORPORATE fill in the NUM_LICENSE
     * phone_number: contact phone number
     * phone_district: contact phone district
     */
    private List<AdditionalInfo> additionalInfo;

    /**
     * The ID of File Folder object.
     */
    private String fileFolderId;

    /**
     * Enum: "REJECTED" "ACCEPTED" "PROCESSING"
     * Status of this Account in Lianian Global's system.
     */
    private String status;
}
