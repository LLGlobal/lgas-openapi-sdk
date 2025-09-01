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
public class CorporateKycCertInfo implements Serializable {


    /**
     * Value: "CN"
     * Relevant personnel and personal certificates of enterprises must fill in the country
     *
     * Enterprise certificate is not required
     */
    private String companyDocCountry;

    /**
     * Value: "Unified_Social_Credit_ID"
     * Cert type
     */
    private String companyDocType;

    /**
     * Cert no
     */
    private String companyDocNumber;

    /**
     * Cert issue date
     */
    private Date certIssueDate;
    /**
     * Cert expiration date
     */
    private Date certExpirationDate;
    /**
     * Whether the certificate is permanently valid. The default value is false. Permanently valid: true
     */
    private Boolean isCertPermanent;

    /**
     * The file ID is the ID returned by the uploaded file.
     */
    private List<AttachmentInfo> attachments;
}
