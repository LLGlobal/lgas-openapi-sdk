package com.lianlianpay.global.ew.openapi.model.account.accounts;

import com.lianlianpay.global.ew.openapi.model.common.AdditionalInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/11/27
 */
@Data
public class AssociateAccountRelateReq implements Serializable {


    /**
     * Associate Account. Account ID. Once this new account is created, it will be connected to your account and becomes the key value you communicate with LLG for any activities in the future.
     */
    private String accountId;

    /**
     * Structured field names and values used to define the business information.
     */
    private List<AdditionalInfo> additionalInfo;
}
