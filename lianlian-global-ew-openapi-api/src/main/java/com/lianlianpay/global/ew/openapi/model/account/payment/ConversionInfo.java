package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/3
 */
@Data
public class ConversionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Sell currency, the currency that the client sells (in three-letter ISO 4217 format).
     */
    private String sellCurrency;

    /**
     * Amount in sell_currency that the client sells. Required if buy_amount is not specified.
     */
    private String sellAmount;

    /**
     * The LockFX Quote is used to execute the conversion. Echoes the request’s LockFX Quote, if provided.
     */
    private String rateId;

    /**
     * The FX Quote represents how much of the quote currency is needed for you to get one unit of the base currency.
     */
    private String rate;

    /**
     * It will be either sell_currency or buy_currency.
     */
    private String baseCurrency;

    /**
     * Buy currency, the currency that the client buys (in three-letter ISO 4217 format).
     */
    private String buyCurrency;

    /**
     * Amount in buy_currency that the client buys. Required if sell_amount is not specified. Main currency unit, rounded up to 2 decimal places.
     */
    private String buyAmount;

    /**
     * Status of the conversion.
     */
    private String status;

    /**
     * The object creation time. Measured in milliseconds since the Unix epoch.
     */
    private Date createTime;
}
