package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/10/22
 */
@Getter
@Setter
public class IndividualKycReq implements Serializable {

    /**
     * region
     */
    private String region;

    /**
     * individual_basic
     */
    private IndividualBasicInfo individualBasic;
}
