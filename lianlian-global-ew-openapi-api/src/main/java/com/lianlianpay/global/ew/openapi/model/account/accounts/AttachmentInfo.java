package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/11/27
 */
@Data
public class AttachmentInfo implements Serializable {


    /**
     * File id
     */
    private String fileId;

    /**
     * Enum: "FRONT" "BACK" "HAND_HOLD" "INNER" "OTHER"
     * File flag
     */
    private String fileFlag;


    /**
     * Enum: "HOUSEHOLD_REGISTER" "PROOF_OF_LEGAL_REP" "POWER_OF_ATTORNEY" "EQUITY_STRUCTURE_CHART" "PROOF_OF_SHARE_HOLDER" "EQUITY_TRANSFER_AGREEMENT" "SS_4" "TAX_RETURN" "ECOMMERCE_OPERATION_CERTIFICATE"
     * attachment type
     */
    private String attachmentType;
}
