package com.lianlianpay.global.ew.openapi.model.account.receive;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/8/5
 */
@Data
public class DepositConfirmationCreateRes implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * Enum: "PROCESS" "REFUND"
     * Value: PROCESS:Process receipt REFUND：Request refund Action Type
     */
    private String actionType;

    /**
     * Time of request processing
     */
    private Long actionTime;

    /**
     * Receiving transaction id
     */
    private String id;

    /**
     * Enum: "PROCESSING" "PENDING" "REJECTED" "CANCELLED" "REFUNDING" "REFUNDED" "COMPLETED"
     * Status of Receiving.
     */
    private String status;
}
