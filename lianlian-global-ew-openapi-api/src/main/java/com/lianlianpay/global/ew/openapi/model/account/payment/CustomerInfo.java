package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/4
 */
@Data
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Merchant ID as known by the client platform.
     */
    private String merchantClientId;

    /**
     * Merchant name as known by the client platform.
     */
    private String merchantClientName;

    /**
     * merchant customer id.
     */
    private String customerId;

    /**
     * Customer name.
     */
    private String customerName;

    /**
     * Customer country code, Two-letter ISO 3166-2 country code.
     */
    private String customerCountry;

    /**
     * INDIVIDUAL CORPORATE.
     */
    private String customerType;
}
