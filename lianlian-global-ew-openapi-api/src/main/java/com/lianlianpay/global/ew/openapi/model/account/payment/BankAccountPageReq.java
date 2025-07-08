package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/2
 */
@Data
public class BankAccountPageReq implements Serializable {

    /**
     * The query page number.
     */
    private Integer page;

    /**
     * A maximum of 100 data items can be displayed on a page.
     */
    private Integer pageSize;

    /**
     * Search by name
     */
    private String keyword;
}
