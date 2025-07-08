package com.lianlianpay.global.ew.openapi.example.account.payment;

import com.lianlianpay.global.ew.openapi.client.BasicAuthClient;
import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.payment.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.service.AccountService;

/**
 * @author huyl
 * @since 2024/12/18
 */
public class BankAccountsExample extends AuthExample {


    private final AccountService accountService;

    public BankAccountsExample() {
        BasicAuthClient defaultBasicAuthClient = super.basicAuthClient();
        this.accountService = new AccountService(defaultBasicAuthClient);
    }

    /**
     * Example of connect bank account
     */
    public void connectBankAccount() {
        BankAccountConnectReq req = new BankAccountConnectReq();
        req.setCountryCode("US");
        req.setEmail("test@test.com");
        req.setName("test");
        ContactAddress address = new ContactAddress();
        address.setCountryCode("US");
        address.setState("CA");
        address.setCity("San Francisco");
        address.setPostcode("94107");
        address.setLine1("1 Market St");
        req.setAddress(address);
        ContactBankInfo bankAccountDetail = new ContactBankInfo();
        bankAccountDetail.setBankCountryCode("US");
        bankAccountDetail.setAccountHolderName("test");
        bankAccountDetail.setAccountHolderType("INDIVIDUAL");
        bankAccountDetail.setAccountCurrency("USD");
        bankAccountDetail.setAccountNumber("123456789");
        bankAccountDetail.setClearingSystem("SWIFT");
        bankAccountDetail.setSwiftCode("CITIUSKK");
        req.setBankAccountDetail(bankAccountDetail);
        req.setFileFolderId("fileFolderId");
        Result<BankAccountRes> result = accountService.connectBankAccount(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }

        if (result.isBadRequest()) {
            // do anything when bad request
            System.out.println(result.getError());
        }

        if (result.isUnauthorized()) {
            // do anything when unauthorized
            System.out.println(result.getError());
        }
    }

    /**
     * Retrieve all Bank Accounts.
     */
    public void retrieveAllBankAccounts() {
        BankAccountPageReq req = new BankAccountPageReq();
        req.setPage(1);
        req.setPageSize(10);
        Result<PageResult<BankAccountRes>> result = accountService.retrieveAllBankAccounts(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }

        if (result.isBadRequest()) {
            // do anything when bad request
            System.out.println(result.getError());
        }

        if (result.isForbidden()) {
            // do anything when forbidden
            System.out.println(result.getError());
        }

        if (result.isNotFound()) {
            // do anything when not found
            System.out.println(result.getError());
        }
    }

    /**
     * Retrieve a specific bank account by ID.
     */
    public void retrieveBankAccount() {
        String accountId = "accountId";
        Result<BankAccountRes> result = accountService.retrieveBankAccount(accountId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }

        if (result.isHttpError()) {
            // do anything when not succeed
            System.out.println(result.getError());
        }
    }

    /**
     * Disconnect a specific bank account by ID.
     * @return Characters "OK" if Succeeded
     */
    public void disconnectBankAccount() {
        String accountId = "accountId";
        Result<BankAccountDisconnectRes> result = accountService.disconnectBankAccount(accountId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }


    /**
     * Retrieve a specific bank account by the merchant_client_id.
     * @return
     */
    public void retrieveBankAccountByMerchant() {
        String merchantClientId = "merchantClientId";
        Result<BankAccountRes> result = accountService.retrieveBankAccountByMerchant(merchantClientId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Disconnect a specific bank account by the merchant_client_id.
     * @return Characters "OK" if Succeeded
     */
    public void disconnectBankAccountByMerchant() {
        String merchantClientId = "merchantClientId";
        Result<BankAccountDisconnectRes> result = accountService.disconnectBankAccountByMerchant(merchantClientId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }


}
