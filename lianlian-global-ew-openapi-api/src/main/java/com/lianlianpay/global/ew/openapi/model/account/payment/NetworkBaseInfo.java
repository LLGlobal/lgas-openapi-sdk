package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/2
 */
@Data
public class NetworkBaseInfo implements Serializable {


   private static final long serialVersionUID = -1L;

    /**
     * string
     * Two-letter ISO 3166-2 country code.
     */
    private String countryCode;

    /**
     * string
     * Mandatory if entity_type = CORPORATE.
     */
    private String corporateName;

    /**
     * string <= 64 characters ^(([\w-\.\+]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,10}|[0-9]{1,3})(\]?))$
     * Email for this payee.
     */
    private String email;

    /**
     * string <= 64 characters
     * First name of this payee, Mandatory if entity_type = INDIVIDUAL.
     */
    private String firstName;

    /**
     * string <= 64 characters
     * Middle name of this payee, Mandatory if entity_type = INDIVIDUAL.
     */
    private String middleName;

    /**
     * string <= 64 characters
     * Last name of this payee, Mandatory if entity_type = INDIVIDUAL.
     */
    private String lastName;

    /**
     * string <= 128 characters
     * Nickname for this payee.
     */
    private String nickname;
}
