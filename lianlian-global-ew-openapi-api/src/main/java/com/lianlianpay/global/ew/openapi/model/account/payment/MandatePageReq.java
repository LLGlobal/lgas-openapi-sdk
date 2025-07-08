package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/4
 */
@Data
public class MandatePageReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The query page number.
     */
    private Integer page;

    /**
     * A maximum of 100 data items can be displayed on a page.
     */
    private Integer pageSize;

    /**
     * Search by request_id ,ID or Business Order ID.
     */
    private String search;

    /**
     * Transaction object creation period start time. Measured in millisecond since the Unix epoch.
     */
    private Date startTime;

    /**
     * Transaction object creation period end time. Measured in millisecond since the Unix epoch.
     */
    private Date endTime;

    /**
     * Enum: "ACTIVE" "CANCELED" "EXPIRED"
     * Status of transaction.
     */
    private String status;
}
