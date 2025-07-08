package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/11/27
 */
@Data
public class ModuleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Enum: "COMPANY_INFO" "LEGAL_PERSON" "AUTH_USER" "UBO" "INDIVIDUAL_INFO" "CORPORATE MEMO" "ATTACHMENTS"
     * module type
     */
    private String moduleType;
}
