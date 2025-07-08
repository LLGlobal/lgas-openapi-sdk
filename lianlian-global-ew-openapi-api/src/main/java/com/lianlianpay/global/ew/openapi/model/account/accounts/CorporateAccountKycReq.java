package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/10/22
 */
@Data
public class CorporateAccountKycReq implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * The user's region
     */
    private String region;

    /**
     * corporate_basic
     */
    private CorporateBasicInfo corporateBasic;

    /**
     * List of relevant personnel of the enterprise, including relevant personnel certificates and attachments.
     */
    private List<CorporateStaffBaseInfo> corporateMembers;

}
