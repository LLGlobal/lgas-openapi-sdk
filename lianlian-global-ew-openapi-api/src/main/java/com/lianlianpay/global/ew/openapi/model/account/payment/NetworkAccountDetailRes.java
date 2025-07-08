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
public class NetworkAccountDetailRes implements Serializable {


    private static final long serialVersionUID = -1L;

    /**
     * string
     * Unique identifier for the payee.
     */
    private String id;

    /**
     * string
     * Merchant ID as known by the client platform.
     */
    private String merchantClientId;

    /**
     * Enum: "CORPORATE" "INDIVIDUAL"
     * Payee entity type, one of INDIVIDUAL and CORPORATE
     */
    private String entityType;

    /**
     * object (NetworkBaseInfo)
     */
    private NetworkBaseInfo baseInfo;

    /**
     * The ID of File Folder object.
     */
    private String fileFolderId;

    /**
     * Enum: "REJECTED" "ACCEPTED" "PROCESSING"
     * Status of this Network Account in Lianian Global's system.
     */
    private String status;

    /**
     * Array of objects (Item)
     */
    private List<AdditionalInfo> additionalInfo;

    /**
     * string
     * User KYC name for this Payee.
     */
    private String userKycName;

    /**
     * Enum: "ACCEPTED" "PROCESSING" "DECLINED"
     * User KYC status for this Payee.
     */
    private String userKycStatus;
}
