package com.lianlianpay.global.ew.openapi.example.account.payment;

import com.lianlianpay.global.ew.openapi.client.BasicAuthClient;
import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.payment.Payout2AppCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.PayoutCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.PayoutDetailRes;
import com.lianlianpay.global.ew.openapi.service.AccountService;

/**
 * Payouts API Example
 * Served By Lianlian Account Service
 * @author huyl
 * @since 2024/12/16
 */
public class PayoutsExample extends AuthExample {


    private final AccountService accountService;



    public PayoutsExample() {
        // init client by basic auth
        BasicAuthClient defaultBasicAuthClient = super.basicAuthClient();
        // init account service
        this.accountService = new AccountService(defaultBasicAuthClient);
    }


    /**
     * Example For Creating a Payout
     */
    public void createPayout() {

        PayoutCreateReq req = new PayoutCreateReq();
        req.setRequestId("2024121121250002");
        req.setBusinessOrderId("2024121211250002");
        req.setPayeeId("910057471267012620288");
        req.setPayCurrency("USD");
        req.setSendCurrency("CNY");
//        req.setPayAmount("100");
        req.setSendAmount("102");
        req.setPurpose("MERCHANDISE_TRADE");
        Result<PayoutDetailRes> result = this.accountService.createPayout(req);

        //when http code is 200
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }

        if (result.isBadRequest()) {
            // do anything when bad request
            System.out.println(result.getError());
        }

        //when http code is 500
        if (result.isServerError()) {
            // do anything when internal server error
            System.out.println(result.getError());
        }

        //when http code is not 200
        if (result.isHttpError()) {
            // do anything when http error
            System.out.println(result.getError());
        }

    }


    /**
     * Example For Retrieving a Payout
     */
    public void retrievePayout() {
        Result<PayoutDetailRes> result = accountService.retrievePayout("2024121121250002");

        //when http code is 200
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }

        if (result.isServerError()) {
            // do anything when internal server error
            System.out.println(result.getError());
        }
    }

    /**
     * Example For Creating a Payout to App
     */
    public void createPayout2App() {
        Payout2AppCreateReq req = new Payout2AppCreateReq();
        req.setRequestId("2024121121250002");
        req.setBusinessOrderId("2024121211250002");
        req.setPurpose("MERCHANDISE_TRADE");
        req.setPayCurrency("USD");
        Result<PayoutDetailRes> result = accountService.createPayout2App(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
        if (result.isBadRequest()) {
            // do anything when bad request
            System.out.println(result.getError());
        }
    }
}
