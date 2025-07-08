package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/10/22
 */
@Setter
@Getter
public class AddressInfo implements Serializable {


    /**
     * Country of address
     */
    private String addrCountry;

    /**
     * Province/State
     */
    private String state;

    /**
     * city
     */
    private String city;

    /**
     * district
     */
    private String district;

    /**
     * postal
     */
    private String postalCode;

    /**
     * Address line one
     */
    private String addressLineOne;

    /**
     * Address line two
     */
    private String addressLineTwo;

    /**
     * Enum: "BANK_OR_CARD_STATEMENT" "UTILITY_BILLS" "COUNCIL_TAX_BILL" "Brokerage_Statement" "LEASE_AGREEMENT_FOR_HOME" "RENTAL_AGREEMENT" "LAND_USED_RIGHT" "OTHER_GOVERNMENT_OFFICIAL_DOCUMENTS" "THE_HOUSE_OF_REGISTRATION"
     * Type of address proof For the enumeration value, pass the number in the expansion number.
     */
    private String addressProofType;

    /**
     * The attachment is the ID returned by the uploaded file.
     */
    private String attachment;

    /**
     * Expanded field one , return when querying, no more than 512 characters
     */
    private String extendOne;
}
