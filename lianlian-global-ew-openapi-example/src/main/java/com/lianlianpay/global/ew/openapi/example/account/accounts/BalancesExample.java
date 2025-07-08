package com.lianlianpay.global.ew.openapi.example.account.accounts;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.accounts.BalanceDetailRes;
import com.lianlianpay.global.ew.openapi.service.AccountService;

import java.util.List;

/**
 * @author huyl
 * @since 2024/12/19
 */
public class BalancesExample extends AuthExample {

    private final AccountService accountService;

    public BalancesExample() {
        accountService = new AccountService(basicAuthClient());
    }

    public void retrieveAllBalances() {
        Result<List<BalanceDetailRes>> result = accountService.retrieveAllBalances();
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
