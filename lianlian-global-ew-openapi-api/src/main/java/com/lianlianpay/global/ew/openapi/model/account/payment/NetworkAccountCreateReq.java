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
public class NetworkAccountCreateReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Enum: "INDIVIDUAL" "CORPORATE"
     * Payee type, one of INDIVIDUAL and CORPORATE
     */
    private String entityType;

    /**
     * Merchant ID as known by the client platform.
     */
    private String merchantClientId;

    /**
     * object (NetworkBaseInfo)
     */
    private NetworkBaseInfo baseInfo;

    /**
     * Array of objects (Item)
     */
    private List<AdditionalInfo> additionalInfo;
}
