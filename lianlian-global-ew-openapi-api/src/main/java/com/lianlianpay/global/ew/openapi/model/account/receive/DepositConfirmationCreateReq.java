package com.lianlianpay.global.ew.openapi.model.account.receive;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2025/8/5
 */
@Data
public class DepositConfirmationCreateReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * Unique request reference number
     */
    private String requestId;

    /**
     * Receiving transaction id
     */
    private String id;

    /**
     * Enum: "ECOMMERCE" "GOODS_TRADE"
     * The type of business.
     */
    private String businessType;

    /**
     * Enum: "PROCESS" "REFUND"
     * Value: PROCESS:Process receipt REFUND：Request refund Action Type
     */
    private String actionType;

    /**
     * Array of objects (DepositTransactionDocument)
     */
    private List<DepositTransactionDocument> transactionDocumentList;

    /**
     * The reason is required when action_type=REFUND
     */
    private String reason;
}
