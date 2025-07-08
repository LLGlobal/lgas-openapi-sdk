package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/11/27
 */
@Data
public class IndividualInterimKycReq implements Serializable {


    /**
     * object (IndividualBaseInfo)
     */
    private IndividualBasicInfo individualBasic;
    /**
     * string
     * extra qa
     */
    private String extraQa;
    /**
     * Array of objects (AttachmentInfo)
     */
    private List<AttachmentInfo> extraAttachments;
}
