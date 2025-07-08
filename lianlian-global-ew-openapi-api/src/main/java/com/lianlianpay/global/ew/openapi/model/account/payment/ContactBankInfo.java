package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/10/21
 */
@Getter
@Setter
@ToString
public class ContactBankInfo implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * Bank country code, Two-letter ISO 3166-2 country code.
     */
    private String bankCountryCode;

    /**
     * The name of the person or business that owns the bank account.
     */
    private String accountHolderName;

    /**
     * The type of entity that holds the account. This can be either INDIVIDUAL or CORPORATE.
     */
    private String accountHolderType;

    /**
     * Three-letter ISO 4217 currency code.
     */
    private String accountCurrency;

    /**
     * Account number.
     */
    private String accountNumber;

    /**
     * Enum: "SWIFT" "CNAPS" "SEPA" "FPS" "RTGS" "Wire" "ACH" "FastPayment"
     * Code of Clearing.
     */
    private String clearingSystem;

    /**
     * Bank SWIFT/BIC code.
     */
    private String swiftCode;

    /**
     * Uniquely identifies this particular bank account. You can use this attribute to check whether two bank accounts are the same.
     */
    private String iban;

    /**
     * For CN CNAPS, the code of this bank.
     */
    private String bankCode;

    /**
     * Branch code.
     */
    private String branchCode;

    /**
     * The routing transit number for the bank account.
     */
    private String routingNumber;

    /**
     * Sort code, digits only, 6 characters long.
     */
    private String sortCode;

    /**
     * Transit number, digits only, 5 characters long.
     */
    private String transitNumber;

    /**
     * Institution number, digits only, 3 characters long.
     */
    private String institutionNumber;
}
