package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class ServiceOpenReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * agreed_to_terms_and_conditions
     * required
     * boolean
     * Agree to abide by LLG Card's terms and conditions.
     *
     * true Agree to the agreement.false Disables creation.
     */
    private Boolean agreedToTermsAndConditions;

    /**
     * agreement_id
     * string <= 128 characters
     * As the agreement corresponding to the account.The agreement ID is the ID returned by the File Folder.
     */
    private String agreementId;

    /**
     * payment_method
     * required
     * Array of strings
     * Items Enum: "Advertising / Affiliate marketing" "Digital content & product" "E-commerce" "Education" "Logistics services" "Professional services" "Travel" "Other business service"
     * Payment method.
     */
    private List<String> paymentMethod;
}
