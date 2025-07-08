package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/4/1
 */
@Data
public class BankAccountVerificationPageReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The query page number.
     */
    private Integer page;

    /**
     * The query page size. A maximum of 100 data items can be displayed on a page.
     */
    private Integer pageSize;

    /**
     * Search by name
     */
    private String keyword;
}
