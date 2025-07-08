package com.lianlianpay.global.ew.openapi.model.acceptance.finance;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/11/26
 */
@Data
public class SettlementReportPageReq implements Serializable {

    /**
     * The query page number.
     */
    private Integer page;

    /**
     * A maximum of 100 data items can be displayed on a page.
     */
    private Integer pageSize;

    /**
     * Transaction object creation period start time. Measured in millisecond since the Unix epoch.
     */
    private Date startTime;

    /**
     * Transaction object creation period start time. Measured in millisecond since the Unix epoch.
     */
    private Date endTime;
}
