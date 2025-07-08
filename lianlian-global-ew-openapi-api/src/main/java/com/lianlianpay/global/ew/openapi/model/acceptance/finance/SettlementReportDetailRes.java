package com.lianlianpay.global.ew.openapi.model.acceptance.finance;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/11/26
 */
@Data
public class SettlementReportDetailRes implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * id
     * string
     * Unique ID created by the LianLian Global.
     */
    private String id;

    /**
     * file_id
     * string
     * File id for settlement report.
     */
    private String fileId;

    /**
     * payment_count
     * integer
     * Number of payment transactions.
     */
    private Integer paymentCount;

    /**
     * refund_count
     * integer
     * Number of refund transactions.
     */
    private Integer refundCount;

    /**
     * amount
     * string <money>
     * The amount to collect, main currency unit, rounded up to 2 decimal places.
     */
    private String amount;

    /**
     * currency
     * string
     * The currency to collect (in three-letter ISO 4217 format).
     */
    private String currency;

    /**
     * create_time
     * integer
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date createTime;
}
