package com.lianlianpay.global.ew.openapi.model.account.query;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class CardPayoutDetailRes implements Serializable {

    private static final long serialVersionUID = -1L;

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
     * transaction_currency
     * string
     * The transaction currency (in three-letter ISO 4217 format).
     */
    private String transactionCurrency;

    /**
     * transaction_amount
     * string
     * The transaction amount, main currency unit, rounded up to 2 decimal places.
     */
    private String transactionAmount;

    /**
     * settle_currency
     * string
     * The settled currency (in three-letter ISO 4217 format).
     */
    private String settleCurrency;

    /**
     * settle_amount
     * string
     * The settled amount, main currency unit, rounded up to 2 decimal places.
     */
    private String settleAmount;

    /**
     * pay_currency
     * string
     * The paid currency (in three-letter ISO 4217 format).
     */
    private String payCurrency;

    /**
     * pay_amount
     * string
     * The paid amount, main currency unit, rounded up to 2 decimal places.
     */
    private String payAmount;

    /**
     * fee_currency
     * string
     * The fee currency (in three-letter ISO 4217 format).
     */
    private String feeCurrency;

    /**
     * fee_amount
     * string
     * The fee amount, main currency unit, rounded up to 2 decimal places.
     */
    private String feeAmount;

    /**
     * card_no
     * string
     * The card NO that paid by.
     */
    private String cardNo;

    /**
     * merchant_category_code
     * string
     * Category code of merchant.
     */
    private String merchantCategoryCode;

    /**
     * merchant_name_location
     * string
     * Merchant name (e.g., AMAZON).
     */
    private String merchantNameLocation;

    /**
     * status
     * string
     * Enum: "PROCESSING" "FAILED" "CANCELLED" "REFUNDING" "REFUNDED" "COMPLETED" Hide
     * Status of Card Payout.
     */
    private String status;

    /**
     * create_time
     * long
     * The object creation time. Measured in milliseconds since the Unix epoch.
     */
    private Date createTime;
}
