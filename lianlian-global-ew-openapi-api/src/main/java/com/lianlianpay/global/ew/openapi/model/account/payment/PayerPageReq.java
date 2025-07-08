package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/4/10
 */
@Data
public class PayerPageReq implements Serializable {

    private static final long serialVersionUID = -1L;

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
