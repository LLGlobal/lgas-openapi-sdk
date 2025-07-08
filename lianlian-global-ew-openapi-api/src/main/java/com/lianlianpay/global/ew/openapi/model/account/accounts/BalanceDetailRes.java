package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/11/28
 */
@Data
public class BalanceDetailRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier of the LianLian Global account.
     */
    private String accountId;

    /**
     * Three-letter ISO 4217 currency code.
     */
    private String currency;

    /**
     * Available amount.
     */
    private String availableAmount;

    /**
     * Balance auto recharge setting.
     */
    private BalanceRechargeSetting autoRechargeSetting;

    /**
     * Balance auto recharge propose setting.
     */
    private BalanceRechargeSetting autoRechargeProposeSetting;
}
