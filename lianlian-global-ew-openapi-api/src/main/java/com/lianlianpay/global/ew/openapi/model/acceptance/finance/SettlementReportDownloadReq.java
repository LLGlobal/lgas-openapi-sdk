package com.lianlianpay.global.ew.openapi.model.acceptance.finance;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/11/26
 */
@Data
public class SettlementReportDownloadReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Settlement report file id.
     */
    private String id;
}
