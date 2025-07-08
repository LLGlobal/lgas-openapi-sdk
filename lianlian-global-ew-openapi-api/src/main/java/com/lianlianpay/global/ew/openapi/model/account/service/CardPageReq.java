package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class CardPageReq implements Serializable {

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
     * A maximum of 100 data items can be displayed on a page.
     */
    private Integer pageSize;

    /**
     * search
     * string
     * Supports card name and last four digits of card number.
     */
    private String search;

    /**
     * status
     * string
     * Enum: "APPLYING" "VALID" "CANCEL" "ABNORMAL" "EXPIRED"
     */
    private String status;
}
