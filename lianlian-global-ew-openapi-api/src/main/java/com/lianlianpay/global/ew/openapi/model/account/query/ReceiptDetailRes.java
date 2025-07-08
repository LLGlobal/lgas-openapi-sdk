package com.lianlianpay.global.ew.openapi.model.account.query;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class ReceiptDetailRes implements Serializable {

    /**
     * id
     * string
     * Unique ID created by the LianLian Global.
     *
     * business_order_id
     * string
     * Business Order ID.
     *
     * account_id
     * string
     * Unique identifier of the LianLian Global account.
     *
     * receive_amount
     * string
     * The receive amount, main currency unit, rounded up to 2 decimal places.
     *
     * receive_currency
     * string
     * The receive currency (in three-letter ISO 4217 format).
     *
     * payer_name
     * string
     * Name of payer.
     *
     * payer_source_id_type
     * string
     * Enum: "EMAIL" "MOBILE"
     * Payer's email or mobile.
     *
     * payer_source_id
     * string
     * Payer's email or mobile.
     *
     * fee
     * string
     * The Receipt fee amount, main currency unit, rounded up to 2 decimal places.
     *
     * context
     * string
     * payee_source_id
     * string
     * Payee's email or mobile.
     *
     * name
     * string
     * Name of receipt from.
     *
     * message
     * string
     * This is the postscript information from payer.
     *
     * user_id
     * string
     * Unique identifier of the User.
     *
     * status
     * string
     * Enum: "PROCESSING" "FAILED" "CANCELLED" … 3 more
     * Status of Receipt.
     *
     * create_time
     * long
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */

    /**
     * id
     * string
     * Unique ID created by the LianLian Global.
     */
    private String id;

    /**
     * business_order_id
     * string
     * Business Order ID.
     */
    private String businessOrderId;

    /**
     * account_id
     * string
     * Unique identifier of the LianLian Global account.
     */
    private String accountId;

    /**
     * receive_amount
     * string
     * The receive amount, main currency unit, rounded up to 2 decimal places.
     */
    private String receiveAmount;

    /**
     * receive_currency
     * string
     * The receive currency (in three-letter ISO 4217 format).
     */
    private String receiveCurrency;

    /**
     * payer_name
     * string
     * Name of payer.
     */
    private String payerName;

    /**
     * payer_source_id_type
     * string
     * Enum: "EMAIL" "MOBILE"
     * Payer's email or mobile.
     */
    private String payerSourceIdType;

    /**
     * payer_source_id
     * string
     * Payer's email or mobile.
     */
    private String payerSourceId;

    /**
     * fee
     * string
     * The Receipt fee amount, main currency unit, rounded up to 2 decimal places.
     */
    private String fee;

    /**
     * context
     * string
     */
    private String context;

    /**
     * payee_source_id
     * string
     * Payee's email or mobile.
     */
    private String payeeSourceId;

    /**
     * name
     * string
     * Name of receipt from.
     */
    private String name;

    /**
     * message
     * string
     * This is the postscript information from payer.
     */
    private String message;

    /**
     * user_id
     * string
     * Unique identifier of the User.
     */
    private String userId;

    /**
     * status
     * string
     * Enum: "PROCESSING" "FAILED" "CANCELLED" "REFUNDING" "REFUNDED" "COMPLETED"
     * Status of Receipt.
     */
    private String status;

    /**
     * create_time
     * long
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date createTime;
}
