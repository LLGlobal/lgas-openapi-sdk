package com.lianlianpay.global.ew.openapi.example.account.payment;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.payment.PayerCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.PayerDetailRes;
import com.lianlianpay.global.ew.openapi.model.account.payment.PayerDisconnectRes;
import com.lianlianpay.global.ew.openapi.model.account.payment.PayerPageReq;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.service.AccountService;

/**
 * @author huyl
 * @since 2024/12/18
 */
public class PayerExample extends AuthExample {

    private final AccountService accountService;

    public PayerExample() {
        this.accountService = new AccountService(basicAuthClient());
    }

    /**
     * Create a payer <br/>
     * After a new Payer is created, it will be audited by LianLian Global before it can be used in payout transactions. A notification of the audit result will be sent by Webhook after subscribing the payer related event Payer.
     * @return
     */
    public void createPayer() {
        PayerCreateReq req = new PayerCreateReq();
        req.setMerchantClientId("[customer unique id in your system]");
        req.setPayerType("INDIVIDUAL");
        req.setPayerName("[customer name]");
        req.setCertNo("[customer id number]");
        req.setCertType("ID_CARD");
        req.setCountryCode("US");
        req.setPhoneNumber("[customer phone number]");
        req.setPhoneDistrict("US");
        //upload file and create folder first, then pass the folder id
        req.setFileFolderId("[folder id of the customer's doc]");
        Result<PayerDetailRes> result = accountService.createPayer(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }

    }

    /**
     * Retrieve a payer
     * @return
     */
    public void retrievePayer() {
        String payerId = "payerId";
        Result<PayerDetailRes> result = accountService.retrievePayer(payerId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve a payer by merchant client id
     * @return
     */
    public void retrievePayerByMerchant() {
        String merchantClientId = "[customer unique id in your system]";
        Result<PayerDetailRes> result = accountService.retrievePayerByMerchant(merchantClientId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Disconnect a payer
     * @return
     */
    public void disconnectPayer() {
        String payerId = "payerId";
        Result<PayerDisconnectRes> result = accountService.disconnectPayer(payerId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Disconnect a payer by merchant client id
     * @return
     */
    public void disconnectPayerByMerchant() {
        String merchantClientId = "[unique payer id in your system]";
        Result<PayerDisconnectRes> result = accountService.disconnectPayerByMerchant(merchantClientId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve all payers
     * @return
     */
    public void retrieveAllPayers() {
        PayerPageReq req = new PayerPageReq();
        req.setPage(1);
        req.setPageSize(10);
        req.setKeyword("[Payer name]");
        Result<PageResult<PayerDetailRes>> result = accountService.retrieveAllPayers(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

}
