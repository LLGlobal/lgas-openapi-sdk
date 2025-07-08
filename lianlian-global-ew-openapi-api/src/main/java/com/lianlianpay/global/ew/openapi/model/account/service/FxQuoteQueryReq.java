package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class FxQuoteQueryReq implements Serializable {


    private static final long serialVersionUID = -1L;

    /**
     * pay_currency
     * required
     * string
     * Pay currency, the currency that the client sells (in three-letter ISO 4217 format).Currently only supported in USD.
     */
    private String payCurrency;
}
