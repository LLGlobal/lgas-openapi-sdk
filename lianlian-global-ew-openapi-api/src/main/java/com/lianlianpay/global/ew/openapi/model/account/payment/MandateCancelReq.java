package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/4
 */
@Data
public class MandateCancelReq implements Serializable {


    private static final long serialVersionUID = -1L;

    /**
     * Request id in the mandate request.
     */
    private String requestId;
}
