package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author huyl
 * @since 2024/10/22
 */
@Getter
@Setter
public class CorporateStaffBaseInfo implements Serializable {



    /**
     * Enum: "LEGALPERSON" "UBO" "AUTH_USER"
     * company_member_type
     */
    private String companyMemberType;

    /**
     * full_name
     * if the nationality is CN, it must be a chinese name
     */
    private String fullName;

    /**
     * full_name_en
     */
    private String fullNameEn;

    /**
     * first_name
     */
    private String firstName;

    /**
     * middle_name
     */
    private String middleName;

    /**
     * last_name
     */
    private String lastName;

    /**
     * birthday. Measured in seconds since the Unix epoch. It's a long type number.
     */
    private LocalDate birthday;

    /**
     * Contact address (residential address)
     */
    private AddressInfo residentialAddress;

    /**
     * email
     */
    private String email;

    /**
     * Two-letter ISO 3166-2 country code of counterparty.
     */
    private String nationality;

    /**
     * Personal related documents
     */
    private List<IndividualKycCertInfo> individualDoc;

}
