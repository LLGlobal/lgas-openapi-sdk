package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/11/28
 */
@Data
public class BalanceRechargeSetting implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * Minimum amount of balance, if the balance is under minimum amount, it will be auto recharged.
     */
    private String balanceMinimumAmount;

    /**
     * Auto recharge amount to LianLian Global balance account from bank, single time.
     */
    private String autoRechargeAmount;
}
