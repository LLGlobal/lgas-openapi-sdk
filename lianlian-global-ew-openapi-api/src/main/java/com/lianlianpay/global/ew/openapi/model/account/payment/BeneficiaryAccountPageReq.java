package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/3
 */
@Data
public class BeneficiaryAccountPageReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * The query page number.
     */
    private Integer page;

    /**
     *  A maximum of 100 data items can be displayed on a page.
     */
    private Integer pageSize;

    /**
     * Enum: "UNDER_REVIEW" "ACCEPTED" "REJECTED"
     * Status of transaction.
     */
    private String status;
}
