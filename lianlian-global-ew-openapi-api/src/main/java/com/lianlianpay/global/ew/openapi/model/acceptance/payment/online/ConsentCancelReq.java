package com.lianlianpay.global.ew.openapi.model.acceptance.payment.online;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/11/26
 */
@Data
public class ConsentCancelReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * Request id in the consent request.
     */
    private String requestId;
}
