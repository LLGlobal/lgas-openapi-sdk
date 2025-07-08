package com.lianlianpay.global.ew.openapi.example.account.accounts;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.accounts.ReceivingAccountDetailRes;
import com.lianlianpay.global.ew.openapi.model.account.accounts.ReceivingAccountOpenReq;
import com.lianlianpay.global.ew.openapi.service.AccountService;

import java.util.Arrays;
import java.util.List;

/**
 * @author huyl
 * @since 2024/12/19
 */
public class ReceivingAccountsExample extends AuthExample {


    private final AccountService accountService;

    public ReceivingAccountsExample() {
        this.accountService = new AccountService(basicAuthClient());
    }

    /**
     * Open receiving account <br/>
     * There are accounts under application. Applications may not be initiated.
     * @return
     */
    public void openReceivingAccount() {
        ReceivingAccountOpenReq req = new ReceivingAccountOpenReq();
        req.setCurrency("EUR");
        req.setCountryCode("HK");
        req.setReceiveCategory(Arrays.asList("Advertising", "Cross Border Education"));

        Result<ReceivingAccountDetailRes> result = accountService.openReceivingAccount(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve all receiving accounts
     * @return
     */
    public void retrieveAllReceivingAccounts() {
        Result<List<ReceivingAccountDetailRes>> result = accountService.retrieveAllReceivingAccounts();
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve a receiving account <br/>
     * Retrieve the information of the Receiving Account with the matching ID.
     * @return
     */
    public void retrieveReceivingAccount() {
        String accountId = "accountId";
        Result<ReceivingAccountDetailRes> result = accountService.retrieveReceivingAccount(accountId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
