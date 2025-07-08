package com.lianlianpay.global.ew.openapi.model.acceptance.payment.online;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Customer Info
 * @author huyl
 * @since 2024/10/18
 */
@Getter
@Setter
@ToString
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * merchant customer id.
     */
    private String customerId;

    /**
     * customer name.
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
