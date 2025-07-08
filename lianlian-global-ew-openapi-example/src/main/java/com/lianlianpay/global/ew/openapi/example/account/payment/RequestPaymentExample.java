package com.lianlianpay.global.ew.openapi.example.account.payment;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.payment.*;
import com.lianlianpay.global.ew.openapi.service.AccountService;

import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/18
 */
public class RequestPaymentExample extends AuthExample {

    private final AccountService accountService;

    public RequestPaymentExample()
    {
        accountService = new AccountService(basicAuthClient());
    }

    /**
     * Retrieve a request payment
     * @return
     */
    public void retrievePayment() {
        String requestId = "2024121121250002";
        Result<RequestPaymentDetailRes> result = accountService.retrievePayment(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Create a request payment
     * @return
     */
    public void createPayment() {
        RequestPaymentCreateReq req = new RequestPaymentCreateReq();
        req.setRequestId("2024121121250002");
        req.setAmount("100.00");
        req.setCurrency("EUR");
        req.setPurpose("MERCHANDISE_TRADE");
        req.setPayerId("[Unique identifier for the Network Account]");
        // expired after 1 hour
        req.setExpireTime(new Date(System.currentTimeMillis() + (60 * 60 * 1000)));
        Result<RequestPaymentDetailRes> result = accountService.createPayment(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Create a request payment url
     * @return
     */
    public void createPaymentUrl() {
        RequestPaymentUrlCreateReq req = new RequestPaymentUrlCreateReq();
        req.setRequestId("2024121121250002");
        req.setAmount("100.00");
        req.setCurrency("EUR");
        req.setPurpose("MERCHANDISE_TRADE");
        req.setExpireTime(new Date(System.currentTimeMillis() + (60 * 60 * 1000)));
        Result<RequestPaymentUrlRes> result = accountService.createPaymentUrl(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Cancel a request payment
     * @return
     */
    public void cancelPayment() {
        RequestPaymentCancelReq req = new RequestPaymentCancelReq();
        req.setRequestId("2024121121250002");
        Result<RequestPaymentCancelRes> result = accountService.cancelPayment(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
