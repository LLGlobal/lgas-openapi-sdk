package com.lianlianpay.global.ew.openapi.model.account.query;

import com.lianlianpay.global.ew.openapi.model.common.BankInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class RechargeDetailRes implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * creditor_name
     * string
     * Name of creditor.
     */
    private String creditorName;

    /**
     * creditor_account_no
     * string
     * Account NO of creditor.
     */
    private String creditorAccountNo;

    /**
     * receive_amount
     * string
     * The received amount, main currency unit, rounded up to 2 decimal places.
     */
    private String receiveAmount;

    /**
     * receive_currency
     * string
     * The receive currency (in three-letter ISO 4217 format).
     */
    private String receiveCurrency;

    /**
     * pay_amount
     * string
     * The amount actually paid, main currency unit, rounded up to 2 decimal places.
     */
    private String payAmount;

    /**
     * pay_currency
     * string
     * The currency actually paid (in three-letter ISO 4217 format).
     */
    private String payCurrency;

    /**
     * reference
     * string
     * This is the postscript information.
     */
    private String reference;

    /**
     * account_id
     * string
     * Balance Account ID.
     */
    private String accountId;

    /**
     * fee
     * string
     * The Recharge fee amount, main currency unit, rounded up to 2 decimal places.
     */
    private String fee;

    /**
     * user_id
     * string
     * Unique identifier of the User.
     */
    private String userId;

    /**
     * name
     * string
     * Name of User.
     */
    private String name;

    /**
     * status
     * string
     * Enum: "PROCESSING" "FAILED" "CANCELLED" "REFUNDING" "REFUNDED" "COMPLETED" Hide
     * Status of Recharge.
     */
    private String status;

    /**
     * create_time
     * long
     * The object creation time. Measured in milliseconds since the Unix epoch.
     */
    private Date createTime;

    /**
     * top_up_account_info
     * object (Bank)
     */
    private BankInfo topUpAccountInfo;
}
