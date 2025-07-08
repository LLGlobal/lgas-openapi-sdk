package com.lianlianpay.global.ew.openapi.example.account.payment;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.payment.*;
import com.lianlianpay.global.ew.openapi.model.common.BankInfo;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.service.AccountService;

/**
 * @author huyl
 * @since 2024/12/18
 */
public class WithdrawExample extends AuthExample {

    private final AccountService accountService;

    public WithdrawExample() {
        accountService = new AccountService(basicAuthClient());
    }


    /**
     * <h3>Create a beneficiary account</h3>
     * Create a new beneficiary to be stored on the LLG platform.
     * @return
     */
    public void createBeneficiaryAccount() {
        BeneficiaryAccountCreateReq req = new BeneficiaryAccountCreateReq();
        BankInfo bankInfo = new BankInfo();
        bankInfo.setAccountCurrency("EUR");
        bankInfo.setBankCountryCode("FR");
        bankInfo.setBankName("BNP Paribas");
        bankInfo.setHolderName("Test");
        bankInfo.setHolderType("INDIVIDUAL");
        req.setBankInfo(bankInfo);
        req.setFileFolderId("[fileFolderId]");
        Result<BeneficiaryAccountDetailRes> result = accountService.createBeneficiaryAccount(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }

    }

    /**
     * <h3>Retrieve all beneficiary accounts</h3>
     * @return
     */
    public void retrieveAllBeneficiaryAccounts() {
        BeneficiaryAccountPageReq req = new BeneficiaryAccountPageReq();
        req.setPage(1);
        req.setPageSize(10);
        Result<PageResult<BeneficiaryAccountDetailRes>> result = accountService.retrieveAllBeneficiaryAccounts(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }


    /**
     * <h3>Create a withdraw</h3>
     * <p>Create a withdraw to a Beneficiary.
     * The successful creation only represents the successful receipt of the distribution order by LianLian Global, does not means the transaction succeed. You can use Retrieve a Withdraw by Request ID API to obtain transaction results.
     * If you want to receive notification of transaction results, you can subscribe to event withdraw.
     * [Note] withdraw can include exchange when send_currency and withdraw_currency are different, and conversion is not included when send_currency matches withdraw_currency.
     * The payer is responsible for the payment fee.</p>
     **/
    public void createWithdraw() {
        WithdrawCreateReq req = new WithdrawCreateReq();
        req.setRequestId("2024121923332423");
        req.setBeneficiaryId("[beneficiaryAccountId]");
        req.setWithdrawCurrency("EUR");
        req.setWithdrawAmount("100");
        req.setReference("[postscript information]");
        Result<WithdrawDetailRes> result = accountService.createWithdraw(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a withdraw</h3>
     * @return
     */
    public void retrieveWithdraw() {
        String requestId = "2024121923332423";
        Result<WithdrawDetailRes> result = accountService.retrieveWithdraw(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
