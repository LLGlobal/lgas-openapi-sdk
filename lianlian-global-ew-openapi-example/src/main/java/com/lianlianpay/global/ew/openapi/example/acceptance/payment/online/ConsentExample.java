package com.lianlianpay.global.ew.openapi.example.acceptance.payment.online;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.ConsentCancelReq;
import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.ConsentCreateReq;
import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.ConsentDetailRes;
import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.CustomerInfo;
import com.lianlianpay.global.ew.openapi.service.AcceptanceService;

/**
 * @author huyl
 * @since 2024/12/30
 */
public class ConsentExample extends AuthExample {

    private final AcceptanceService acceptanceService;

    public ConsentExample() {
        this.acceptanceService = new AcceptanceService(this.basicAuthClient());
    }

    /**
     * Create a consent <br/>
     * Create a Consent URL for a Payer.
     * @return
     */
    public void createConsent() {
        ConsentCreateReq req = new ConsentCreateReq();
        req.setRequestId("2024121121250002");
        req.setConsentType("PAYMENT_AGREEMENT");
        req.setReturnUrl("[your return url]");
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerId("[customer unique id in your system]");
        customerInfo.setCustomerName("[customer name]");
        customerInfo.setCustomerCountry("[customer country]");
        customerInfo.setCustomerType("INDIVIDUAL");
        req.setCustomer(customerInfo);
        Result<ConsentDetailRes> result = acceptanceService.createConsent(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Cancel a consent <br/>
     * @return
     */
    public void cancelConsent() {
        ConsentCancelReq req = new ConsentCancelReq();
        req.setRequestId("2024121121250002");
        Result<ConsentDetailRes> result = acceptanceService.cancelConsent(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve the detail of a consent by Request ID.<br/>
     * @return
     */
    public void retrieveConsent() {
        String requestId = "2024121121250002";
        Result<ConsentDetailRes> result = acceptanceService.retrieveConsent(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
