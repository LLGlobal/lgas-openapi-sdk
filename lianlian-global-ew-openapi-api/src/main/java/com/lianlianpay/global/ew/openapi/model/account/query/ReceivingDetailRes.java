package com.lianlianpay.global.ew.openapi.model.account.query;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class ReceivingDetailRes implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * id
     * string
     * Unique ID created by the LianLian Global.
     */
    private String id;

    /**
     * creditor_name
     * string
     * Name of creditor.
     */
    private String creditorName;

    /**
     * receive_currency
     * string
     * The receive currency (in three-letter ISO 4217 format).
     */
    private String receiveCurrency;

    /**
     * receive_amount
     * string
     * The received amount, main currency unit, rounded up to 2 decimal places.
     */
    private String receiveAmount;


    /**
     * entry_amount
     * string
     * The entry amount, main currency unit, rounded up to 2 decimal places.
     */
    private String entryAmount;

    /**
     * entry_currency
     * string
     * The entry currency (in three-letter ISO 4217 format).
     */
    private String entryCurrency;

    /**
     * fee
     * string
     * The Receiving fee amount, main currency unit, rounded up to 2 decimal places.
     */
    private String fee;

    /**
     * reference
     * string
     * This is the postscript information.
     */
    private String reference;

    /**
     * account_id
     * string
     * account ID.
     */
    private String accountId;

    /**
     * virtual_account_no
     * string
     * The Virtual Account NO.
     */
    private String virtual_account_no;

    /**
     * status
     * string
     * Enum: "PROCESSING" "FAILED" "CANCELLED" "REFUNDING" "REFUNDED" "COMPLETED"
     * Status of Receiving.
     */
    private String status;

    /**
     * failure_code
     * string
     * Failure code.
     */
    private String failureCode;

    /**
     * failure_reason
     * string
     * Failure reason.
     */
    private String failureReason;

    /**
     * create_time
     * long
     * The object creation time. Measured in milliseconds since the Unix epoch.
     */
    private Date createTime;
}
