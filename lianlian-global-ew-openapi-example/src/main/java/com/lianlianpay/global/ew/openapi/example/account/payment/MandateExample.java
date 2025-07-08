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
public class MandateExample extends AuthExample {


    private final AccountService accountService;

    public MandateExample() {
        accountService = new AccountService(super.basicAuthClient());
    }


    /**
     * Create a Mandate URL for a Payer.
     * @return
     */
    public void createMandate() {
        MandateCreateReq req = new MandateCreateReq();
        req.setRequestId("2024121121250002");
        req.setConsentType("PAYMENT_AGREEMENT");
        req.setReturnUrl("[your return url]");
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setMerchantClientId("[customer unique id in your system]");
        customerInfo.setMerchantClientName("[customer name]");
        req.setCustomer(customerInfo);
        Result<MandateCreateRes> result = accountService.createMandate(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Cancel a mandate
     * @return
     */
    public void cancelMandate() {
        MandateCancelReq req = new MandateCancelReq();
        req.setRequestId("[mandate request id]");
        Result<MandateDetailRes> result = accountService.cancelMandate(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve a mandate
     * @return
     */
    public void retrieveMandate() {
        String requestId = "[mandate request id]";
        Result<MandateDetailRes> result = accountService.retrieveMandate(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve all mandates
     * @return
     */
    public void retrieveAllMandates() {
        MandatePageReq req = new MandatePageReq();
        req.setPage(1);
        req.setPageSize(10);
        req.setStatus("ACTIVE");
        Result<PageResult<MandateDetailRes>> result = accountService.retrieveAllMandates(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
