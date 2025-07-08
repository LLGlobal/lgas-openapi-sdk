package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class FxQuoteDetailRes implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * The FX Quote represents how much of the quote currency is needed for you to get one unit of the base currency.
     */
    private String rate;

    /**
     * Pay currency, the currency that the client sells (in three-letter ISO 4217 format).
     */
    private String payCurrency;

    /**
     * Send currency, the currency that the client buys (in three-letter ISO 4217 format).
     */
    private String sendCurrency;

    /**
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date fxDate;
}
