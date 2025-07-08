package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/11/28
 */
@Data
public class AccountBankInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Value: "Checking" <br/>
     * ABA
     */
    private String aba;

    /**
     * Enum: "Checking" "Savings"
     * Type of account.
     */
    private String accountType;

    /**
     * The name of the person or business that owns the account.
     */
    private String accountHoldersName;

    /**
     * Bank SWIFT code.
     */
    private String swiftCode;

    /**
     * Account number.
     */
    private String bankAccountNumber;

    /**
     * Name of the bank associated with the routing number (e.g., WELLS FARGO).
     */
    private String bankName;

    /**
     * Bank country code, Two-letter ISO 3166-2 country code.
     */
    private String bankCountryRegion;

    private String bankCountryRegionName;

    /**
     * Bank detail address.
     */
    private String bankAddress;

    /**
     * The routing transit number for the bank account.
     */
    private String routingNumber;

    /**
     * ID of Bank.
     */
    private String bankId;

    /**
     * WIREABA.
     */
    private String wireaba;

    /**
     * The object creation time. Measured in milliseconds since the Unix epoch.
     */
    private Date createTime;

    /**
     * Channel code of Bank Account.
     */
    private String channelCode;
}
