package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/4/29
 */
@Data
public class EstimateBeneficiary implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * country
     * required
     * string
     * Two-letter ISO 3166-2 country code.
     */
    private String country;

    /**
     * clearing_system
     * string
     * clearing system.
     */
    private String clearingSystem;
}
