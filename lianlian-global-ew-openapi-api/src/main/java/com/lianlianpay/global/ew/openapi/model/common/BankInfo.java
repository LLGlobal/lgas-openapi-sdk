package com.lianlianpay.global.ew.openapi.model.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/3
 */
@Data
public class BankInfo implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * string
     * Bank country code, Two-letter ISO 3166-2 country code.
     */
    private String bankCountryCode;

    /**
     * string
     * The name of the person or business that owns the bank account.
     */
    private String holderName;

    /**
     * string
     * The type of entity that holds the account. This can be either INDIVIDUAL or CORPORATE.
     */
    private String holderType;

    /**
     * string
     * Three-letter ISO 4217 currency code.
     */
    private String accountCurrency;

    /**
     * string
     * Account number.
     */
    private String accountNumber;

    /**
     * string
     * Name of the bank associated with the routing number (e.g., WELLS FARGO).
     */
    private String bankName;

    /**
     * string
     * Bank detail address.
     */
    private String bankAddress;

    /**
     * string
     * Enum: "SWIFT" "CNAPS" "SEPA" "FPS" "RTGS" "Wire" "FastPayment"
     * Code of Clearing.
     */
    private String clearingCode;

    /**
     * string
     * Bank SWIFT/BIC code.
     */
    private String swiftCode;

    /**
     * string
     * Uniquely identifies this particular bank account. You can use this attribute to check whether two bank accounts are the same.
     */
    private String iban;

    /**
     * string
     * For CN CNAPS, the code of this bank.
     */
    private String bankCode;

    /**
     * string
     * The routing transit number for the bank account.
     */
    private String routingNumber;

    /**
     * string
     * Sort code, digits only, 6 characters long.
     */
    private String sortCode;

    /**
     * string
     * Transit number, digits only, 5 characters long.
     */
    private String transitNumber;

    /**
     * string
     * Institution number, digits only, 3 characters long.
     */
    private String institutionNumber;
}
