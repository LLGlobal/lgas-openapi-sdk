package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/11/27
 */
@Data
public class AccountDetailRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * account ID. Once this new account is created, it will be connected to your account and becomes the key value you communicate with LLG for any activities in the future.
     */
    private String accountId;

    /**
     * Unique identifier for the Account.
     */
    private String email;

    /**
     * Merchant name as known by the client platform.
     */
    private String name;

    /**
     * Two-letter ISO 3166-2 country code of counterparty.
     */
    private String countryCode;

    /**
     * Entity type
     */
    private String entityType;

    /**
     * Mobile number area
     */
    private String phoneDistrict;

    /**
     * The user's phone
     */
    private String phone;

    /**
     * The identifier of the customer.
     */
    private String identifier;

    /**
     * Enum: "INIT" "UNDER_REVIEW" "ACTIVE" "SUSPENDED" "CLOSED"
     * status
     */
    private String status;

    /**
     * Enum: "UNDER_REVIEW" "PROCESSING" "ACTION_REQUIRED" "AUDIT_SUCCESS" "AUDIT_TERMINATED"
     * KycStatus
     */
    private String kycStatus;

    /**
     * kyc comments.
     */
    private List<KycComment> kycComments;

    /**
     * kyc interim case list.
     */
    private List<InterimCase> interimCases;
}
