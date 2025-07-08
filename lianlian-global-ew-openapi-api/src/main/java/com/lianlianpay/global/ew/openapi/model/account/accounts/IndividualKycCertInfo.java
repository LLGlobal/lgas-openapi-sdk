package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/10/22
 */
@Data
public class IndividualKycCertInfo implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * country
     */
    private String idCountry;
    /**
     * Enum: "PASSPORT" "ARMY_OFFICER_CERT" "SOLDIER_CERT" … 11 more
     * Cert type For the enumeration value, pass the number in the expansion number.
     */
    private String certType;
    /**
     * Cert no
     */
    private String certNo;
    /**
     * Cert issue date
     */
    private String certIssueDate;
    /**
     * Cert expiration date
     */
    private String certExpirationDate;
    /**
     * Whether the certificate is permanently valid. The default value is false. Permanently valid: true
     */
    private Boolean isCertPermanent;
    /**
     * The file ID is the ID returned by the uploaded file.
     */
    private List<AttachmentInfo> attachments;
}
