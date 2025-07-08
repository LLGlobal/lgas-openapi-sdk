package com.lianlianpay.global.ew.openapi.example.account.payment;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.payment.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.service.AccountService;

/**
 * @author huyl
 * @since 2024/12/18
 */
public class NetworkAccountExample extends AuthExample {


    private final AccountService accountService;

    public NetworkAccountExample() {
        this.accountService = new AccountService(this.basicAuthClient());
    }



    /**
     * Connect a network account
     * @return
     */
    public void connectNetworkAccount() {
        NetworkAccountConnectReq req = new NetworkAccountConnectReq();
        req.setMerchantClientId("[Merchant ID as known by the client platform]");
        req.setMerchantClientName("[Merchant Name as known by the client platform]");
        req.setCountryCode("US");
        req.setAgreementType("ECOMMERCE-SEND-PAYMENT");
        req.setRedirectUrl("[URL Lianlian will redirect to at the end of a successful signing process]");
        Result<NetworkAccountConnectRes> result = accountService.connectNetworkAccount(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve all network accounts
     * @return
     */
    public void retrieveAllNetworkAccounts() {
        NetworkAccountPageReq req = new NetworkAccountPageReq();
        req.setPage(1);
        req.setPageSize(10);
        Result<PageResult<NetworkAccountDetailRes>> result = accountService.retrieveAllNetworkAccounts(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve a network account
     * @return
     */
    public void retrieveNetworkAccount() {
        String accountId = "accountId";
        Result<NetworkAccountDetailRes> result = accountService.retrieveNetworkAccount(accountId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Disconnect a network account
     * @return
     */
    public void disconnectNetworkAccount() {
        String accountId = "accountId";
        Result<NetworkAccountDisconnectRes> result = accountService.disconnectNetworkAccount(accountId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Create a network account
     * @return
     */
    public void createNetworkAccount() {
        NetworkAccountCreateReq req = new NetworkAccountCreateReq();
        req.setEntityType("INDIVIDUAL");
//        req.setEntityType("CORPORATE");
        req.setMerchantClientId("[Merchant ID as known by the client platform]");

        NetworkBaseInfo networkBaseInfo = new NetworkBaseInfo();
        networkBaseInfo.setCountryCode("US");
//        networkBaseInfo.setCorporateName("[Merchant Name as known by the client platform]");
        networkBaseInfo.setEmail("[Merchant Email Address]");
        networkBaseInfo.setFirstName("[Merchant First Name]");
        networkBaseInfo.setMiddleName("[Merchant Middle Name]");
        networkBaseInfo.setLastName("[Merchant Last Name]");
        networkBaseInfo.setNickname("[Merchant Nickname]");

        req.setBaseInfo(networkBaseInfo);
        Result<NetworkAccountDetailRes> result = accountService.createNetworkAccount(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve a network account by merchant client id
     * @return
     */
    public void retrieveNetworkAccountByMerchant() {
        String merchantClientId = "merchantClientId";
        Result<NetworkAccountDetailRes> result = accountService.retrieveNetworkAccountByMerchant(merchantClientId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Disconnect a network account by merchant client id
     * @return
     */
    public void disconnectNetworkAccountByMerchant() {
        String merchantClientId = "merchantClientId";
        Result<NetworkAccountDisconnectRes> result = accountService.disconnectNetworkAccountByMerchant(merchantClientId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }

    }
}
