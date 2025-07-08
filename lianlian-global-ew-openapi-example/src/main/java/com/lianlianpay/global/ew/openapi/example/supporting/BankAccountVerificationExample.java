package com.lianlianpay.global.ew.openapi.example.supporting;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.model.supporting.*;
import com.lianlianpay.global.ew.openapi.service.SupportingService;

/**
 * BankAccountVerificationExample
 * @author huyl
 * @since 2025/4/1
 */
public class BankAccountVerificationExample extends AuthExample {

    private final SupportingService supportingService;

    public BankAccountVerificationExample() {
        super();
        this.supportingService = new SupportingService(this.basicAuthClient());
    }

    /**
     * Example of verifyBankAccount
     */
    public void verifyBankAccount() {
        BankAccountVerifyReq req = new BankAccountVerifyReq();
        req.setRequestId("202504011700100001");
        req.setBankAccountName("test name");
        req.setBankAccountNumber("62123515432446246");
        req.setCnapsCode("102100000011");
        Result<BankAccountVerifyRes> result = supportingService.verifyBankAccount(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * Example of validateBankAccountVerification
     */
    public void validateBankAccountVerification() {
        BankAccountVerificationValidateReq req = new BankAccountVerificationValidateReq();
        req.setRequestId("202504011700100001");
        req.setAmount("100");
        Result<BankAccountVerifyDetailRes> result = supportingService.validateBankAccountVerification(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * Example of retrieveBankAccountVerification
     */
    public void retrieveBankAccountVerification() {
        Result<BankAccountVerifyDetailRes> result = supportingService.retrieveBankAccountVerification("202504011700100001");
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * Example of retrieveAllBankAccountVerification
     */
    public void retrieveAllBankAccountVerification() {
        BankAccountVerificationPageReq req = new BankAccountVerificationPageReq();
        req.setPage(1);
        req.setPageSize(10);
        req.setKeyword("test");
        Result<PageResult<BankAccountVerifyDetailRes>> result = supportingService.retrieveAllBankAccountVerification(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }
}
