package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/11/27
 */
@Data
public class CorporateInterimKycReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Array of objects (CorporateStaffBaseInfo)
     * List of relevant personnel of the enterprise, including relevant personnel certificates and attachments.
     */
    private CorporateBasicInfo corporateBasic;

    /**
     * Array of objects (CorporateStaffBaseInfo)
     * List of relevant personnel of the enterprise, including relevant personnel certificates and attachments.
     */
    private List<CorporateStaffBaseInfo> corporateMembers;

    /**
     * extra qa
     */
    private String extraQa;

    /**
     * Array of objects (AttachmentInfo)
     * The file ID is the ID returned by the uploaded file.
     */
    private List<AttachmentInfo> extraAttachments;
}
