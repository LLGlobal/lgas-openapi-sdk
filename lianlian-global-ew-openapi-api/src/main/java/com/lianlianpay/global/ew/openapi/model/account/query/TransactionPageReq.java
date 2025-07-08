package com.lianlianpay.global.ew.openapi.model.account.query;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class TransactionPageReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * page
     * required
     * integer
     * The query page number.
     */
    private Integer page;

    /**
     * page_size
     * required
     * integer
     * The default value is 20. A maximum of 100 data items can be displayed on a page.
     */
    private Integer pageSize;

    /**
     * search
     * string
     * Search by name, Transaction ID or Business Order ID.
     */
    private String search;

    /**
     * start_time
     * long
     * Transaction object creation period start time. Measured in millisecond since the Unix epoch.
     */
    private Date startTime;

    /**
     * end_time
     * long
     * Transaction object creation period end time. Measured in millisecond since the Unix epoch.
     */
    private Date endTime;

    /**
     * status
     * string
     * Enum: "PENDING" "PROCESSING" "COMPLETED" "CANCELED" "REFUNDING" "REFUNDED" "FAILED"
     * Status of transaction.
     */
    private String status;

    /**
     * type
     * string
     * Enum: "PAYOUT" "RECEIPT" "CONVERSION" "WITHDRAWAL" "CARD_PAYMENT" "ADD_FUNDS" "RECEIVING" "REFUND" "PROMO_COMMISSION" "STANDING_PAYMENT"
     * Type of transaction.
     */
    private String type;

    /**
     * currency
     * string
     * Three-letter ISO 4217 currency code.
     */
    private String currency;
}
