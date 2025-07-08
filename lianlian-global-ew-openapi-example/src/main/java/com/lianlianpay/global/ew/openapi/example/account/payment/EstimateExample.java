package com.lianlianpay.global.ew.openapi.example.account.payment;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.payment.EstimateBeneficiary;
import com.lianlianpay.global.ew.openapi.model.account.payment.FeeEstimateReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.FeeEstimateRes;
import com.lianlianpay.global.ew.openapi.service.AccountService;

/**
 * @author huyl
 * @since 2025/4/29
 */
public class EstimateExample extends AuthExample {

    private final AccountService accountService;

    public EstimateExample() {
        super();
        this.accountService = new AccountService(this.basicAuthClient());
    }

    /**
     * Example of estimating fees for a payout
     */
    public void estimateFee() {
        FeeEstimateReq req = new FeeEstimateReq();
        req.setTransactionType("PAYOUT");
        req.setPayCurrency("EUR");
        req.setPayAmount("100");
        req.setSendCurrency("USD");
        req.setRateId("[RATE_ID]");
        req.setAccountId("[ACCOUNT_ID]");
        EstimateBeneficiary beneficiary = new EstimateBeneficiary();
        beneficiary.setCountry("US");
        beneficiary.setClearingSystem("SWIFT");
        req.setBeneficiary(beneficiary);
        Result<FeeEstimateRes> result = accountService.estimateFee(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
