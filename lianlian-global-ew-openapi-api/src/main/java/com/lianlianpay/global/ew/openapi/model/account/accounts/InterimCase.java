package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/11/27
 */
@Data
public class InterimCase implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * Enum: "INIT" "PROCESSING" "ACTION_REQUIRED"
     * status of interim case
     */
    private String caseStatus;

    /**
     * deadline time of interim case
     */
    private String deadlineTime;

    /**
     * comments of common interim case
     */
    private List<KycComment> reasonInfos;

    /**
     * comments of cert interim case
     */
    private List<CertReasonInfo> certReasonInfos;

    /**
     * require attachments
     */
    private List<AttachmentDesc> requireAttachments;

    /**
     * extra qa
     */
    private String extraQa;

    /**
     * require modules
     */
    private List<ModuleInfo> requireModules;

}
