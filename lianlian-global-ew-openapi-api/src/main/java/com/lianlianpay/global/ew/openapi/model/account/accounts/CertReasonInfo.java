package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/11/27
 */
@Data
public class CertReasonInfo implements Serializable {

   private static final long serialVersionUID = -1L;

    /**
     * cert expire day
     */
    private String certExpireDay;

    /**
     * cert no
     */
    private String certNo;

    /**
     * cert type
     */
    private String certType;

    /**
     * Staff type
     */
    private String companyMemberType;
}
