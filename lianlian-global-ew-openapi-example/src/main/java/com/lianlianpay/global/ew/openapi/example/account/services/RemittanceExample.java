package com.lianlianpay.global.ew.openapi.example.account.services;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.service.*;
import com.lianlianpay.global.ew.openapi.service.AccountService;

/**
 * @author huyl
 * @since 2024/12/24
 */
public class RemittanceExample extends AuthExample {

    private final AccountService accountService;

    public RemittanceExample()
    {
        accountService = new AccountService(super.basicAuthClient());
    }


    /**
     * <h3>Retrieve a fx quote</h3>
     * Query remittance transaction FX rate
     * @return
     */
    public void retrieveFxQuote() {
        FxQuoteQueryReq req = new FxQuoteQueryReq();
        req.setPayCurrency("EUR");
        Result<FxQuoteDetailRes> result = accountService.retrieveFxQuote(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Create a remittance</h3>
     * Before sending out a remittance transaction, partner must initiate a remittance creation request to LianLian Global to ensure the transaction is able to send.
     * @return
     */
    public void createRemittance() {
        RemittanceCreateReq req = new RemittanceCreateReq();
        req.setRequestId("2024121923332423");
        req.setBusinessOrderId("2024121923332423");
        req.setPayCurrency("EUR");
        req.setPayAmount("100");
        req.setReference("[postscript information]");
        req.setPurpose("TOURISM_FX_SETTLE");
        req.setPayeeAccount("123456789");
        req.setPayeeName("John Doe");
        req.setSendCurrency("USD");
        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setPayerNationality("US");
        payerInfo.setPayerName("[payer name]");
        payerInfo.setPayerBirthday("19800101");
        payerInfo.setPayerPermanentCountry("US");
        payerInfo.setPayerPermanentCity("New York");
        payerInfo.setPayerPermanentAddress("[payer address]");
        payerInfo.setPayerIdNo("213124123123123");
        payerInfo.setPayerIdType("PASSPORT");
        req.setPayerInfo(payerInfo);
        Result<RemittanceCreateRes> result = accountService.createRemittance(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Submit a remittance</h3>
     * Partner initiates remittance submission request to send the transaction. The remittance creation request must be successful before remittance submission.
     * @return
     */
    public void submitRemittance() {
        RemittanceSubmitReq req = new RemittanceSubmitReq();
        req.setRequestId("2024121923332423");
        Result<RemittanceDetailRes> result = accountService.submitRemittance(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a remittance</h3>
     * Retrieve a Remittance by Request ID.
     * @return
     */
    public void retrieveRemittance() {
        String requestId = "2024121923332423";
        Result<RemittanceDetailRes> result = accountService.retrieveRemittance(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
