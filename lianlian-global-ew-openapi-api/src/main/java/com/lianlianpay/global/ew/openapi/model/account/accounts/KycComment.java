package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/11/27
 */
@Data
public class KycComment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * kyc comment
     */
    private String kycComment;

    /**
     * kyc comment code
     */
    private String kycCommentCode;
}
