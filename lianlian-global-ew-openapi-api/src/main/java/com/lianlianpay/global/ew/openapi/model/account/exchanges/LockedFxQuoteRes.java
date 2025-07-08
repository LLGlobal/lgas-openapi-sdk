package com.lianlianpay.global.ew.openapi.model.account.exchanges;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class LockedFxQuoteRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * string
     * Unique ID for this quote wich will be used by Conversion.
     */
    private String id;

    /**
     * rate
     * string
     * The FX Quote represents how much of the quote currency is needed for you to get one unit of the base currency.
     */
    private String rate;

    /**
     * base_currency
     * string
     * It will be either sell_currency or buy_currency.
     */
    private String baseCurrency;

    /**
     * sell_currency
     * string
     * Sell currency, the currency that the client sells (in three-letter ISO 4217 format).
     */
    private String sellCurrency;

    /**
     * buy_currency
     * string
     * Buy currency, the currency that the client buys (in three-letter ISO 4217 format).
     */
    private String buyCurrency;

    /**
     * validity
     * string
     * Value: "T_0"
     * Quote validity period.
     */
    private String validity;

    /**
     * valid_strarting_after
     * long
     * The valid time of the exchange rate.
     */
    private Date validStrartingAfter;

    /**
     * valid_ending_before
     * long
     * The valid end time of the exchange rate.
     */
    private Date validEndingBefore;
}
