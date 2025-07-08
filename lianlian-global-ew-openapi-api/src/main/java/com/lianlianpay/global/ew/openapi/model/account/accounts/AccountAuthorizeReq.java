package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/10/24
 */
@Data
public class AccountAuthorizeReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * account_id
     * required
     * string
     * Authorize an account.
     */
    private String accountId;

    /**
     * client_id
     * required
     * string
     * App client id.
     */
    private String clientId;
}
