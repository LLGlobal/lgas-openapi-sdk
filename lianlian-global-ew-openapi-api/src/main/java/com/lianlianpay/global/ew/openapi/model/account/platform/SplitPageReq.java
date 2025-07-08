package com.lianlianpay.global.ew.openapi.model.account.platform;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/4
 */
@Data
public class SplitPageReq implements Serializable {

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
     * Unique identifier for the Account Object ID.
     */
    private String accountId;

    /**
     * Transaction object creation period start time. Measured in seconds since the Unix epoch.
     */
    private Date startTime;

    /**
     * Transaction object creation period end time. Measured in seconds since the Unix epoch.
     */
    private Date endTime;

    /**
     * Enum: "WAIT_DEPOSIT" "VERIFIED" "SETTLING" "COMPLETED"
     * Status of transaction.
     */
    private String status;
}
