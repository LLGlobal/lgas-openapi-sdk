package com.lianlianpay.global.ew.openapi.model.account.payment;

import com.lianlianpay.global.ew.openapi.model.common.AdditionalInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author huyl
 * @since 2024/12/3
 */
@Data
public class PayerDetailRes implements Serializable {

   private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for the payer.
     */
    private String id;

    /**
     * Merchant ID as known by the client platform.
     */
    private String merchantClientId;

    /**
     * Enum: "CORPORATE" "INDIVIDUAL"
     * Payer entity type, one of INDIVIDUAL and CORPORATE
     */
    private String payerType;

    /**
     * payer name.
     */
    private String payerName;

    /**
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
     * address
     */
    private ContactAddress address;

    /**
     * Enum: "REJECTED" "ACCEPTED" "PROCESSING"
     * Status of this Contact in Lianian Global's system.
     */
    private String status;

    /**
     * failure code.
     */
    private String failureCode;

    /**
     * failure reason.
     */
    private String failureReason;

    /**
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date createTime;

    /**
     * The object update time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date updateTime;

    /**
     * additionalInfo
     * Array of item
     */
    private List<AdditionalInfo> additionalInfo;
}
