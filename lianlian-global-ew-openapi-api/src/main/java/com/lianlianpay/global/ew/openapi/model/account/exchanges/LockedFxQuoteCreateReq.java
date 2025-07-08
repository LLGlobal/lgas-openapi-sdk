package com.lianlianpay.global.ew.openapi.model.account.exchanges;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class LockedFxQuoteCreateReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * sell_currency
     * required
     * string
     * Sell currency, the currency that the client sells (in 3-letter ISO-4217 format).
     */
    private String sellCurrency;

    /**
     * buy_currency
     * required
     * string
     * Buy currency, the currency that the client buys (in 3-letter ISO-4217 format).
     */
    private String buyCurrency;

    /**
     * validity
     * string
     * Value: "T_0"
     * When is the rate valid.
     */
    private String validity;
}
