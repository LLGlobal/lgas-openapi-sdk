package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author huyl
 * @since 2024/10/22
 */
@Setter
@Getter
public class IndividualBasicInfo implements Serializable {


    /**
     * name
     */
    private String fullName;

    /**
     * name en
     */
    private String fullNameEn;

    /**
     * First name
     */
    private String firstName;

    /**
     * Middle name
     */
    private String middleName;

    /**
     * Last name
     */
    private String lastName;

    /**
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date birthday;

    /**
     * Contact address (residential address)
     */
    private AddressInfo residentialAddress;

    /**
     * phone
     */
    private String phone;

    /**
     * email
     */
    private String email;

    /**
     * Two-letter ISO 3166-2 country code of counterparty.
     */
    private String nationality;

    /**
     * Monthly earnings
     */
    private String monthlyIncome;

    /**
     * Business category one
     */
    private String businessCategory_1;

    /**
     * Business category two
     */
    private String businessCategory_2;

    /**
     * Expected to conduct business
     */
    private String expectBiz;

    /**
     * Relevant personal certs
     */
    private List<IndividualKycCertInfo> individualDoc;

    /**
     * The file ID is the ID returned by the uploaded file.
     */
    private List<AttachmentDesc> attachments;
}
