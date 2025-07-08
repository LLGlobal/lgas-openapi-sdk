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
public class NetworkAccountConnectRes implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * LianLian Network Account Object ID. Merchant shall use this ID to contact LianLian for any payment issues.
     */
    private String id;

    /**
     * Client's ID for this Merchant.
     */
    private String merchantClientId;

    /**
     * Merchant name as known by the client platform.
     */
    private String merchantClientName;

    /**
     * URL to redirect merchant to in order to start agreement signing on LianLian platform.
     */
    private String signingUrl;

    /**
     * Additional info to be used by customer support if needed.
     */
    private List<AdditionalInfo> additionalInfo;

    /**
     * State of merchant signing process.
     */
    private Boolean signingComplete;

    /**
     * Unique identifier for the Agreement created by the LianLian.
     */
    private String agreementNo;
}
