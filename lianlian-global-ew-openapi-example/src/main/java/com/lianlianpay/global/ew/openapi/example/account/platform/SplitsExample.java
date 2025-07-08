package com.lianlianpay.global.ew.openapi.example.account.platform;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.platform.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.service.AccountService;

/**
 * @author huyl
 * @since 2024/12/23
 */
public class SplitsExample extends AuthExample {


    private final AccountService accountService;

    public SplitsExample() {
        this.accountService = new AccountService(super.basicAuthClient());
    }

    /**
     * <h3>Create a split</h3>
     * Use this endpoint to send settlement data to LLG for further release
     * after the corresponding funds been deposited and bank_reference matched.
     * @return
     */
    public void createSplit() {
        SplitCreateReq req = new SplitCreateReq();
        req.setRequestId("2024121923332423");
        req.setBusinessOrderId("[businessOrderId]");
        req.setAccountId("[accountId]");
        req.setAmount("100");
        req.setCurrency("EUR");
        req.setBankReference("postscript");
        Result<SplitDetailRes> result = this.accountService.createSplit(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Release a split</h3>
     * Use this endpoint to release a previous fund split and funds
     * will be deducted from holding account and added to seller's available balance.
     * @return
     */
    public void releaseSplit() {
        SplitReleaseReq req = new SplitReleaseReq();
        req.setRequestId("2024121923332423");
        req.setPrevRequestId("[prevRequestId]");
        req.setBusinessOrderId("[businessOrderId]");
        req.setAmount("100");
        req.setCurrency("EUR");
        Result<SplitRes> result = this.accountService.releaseSplit(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Refund a split</h3>
     * If the Fund split has not yet been release, it can be refunded.
     * Partial refunds can be made for the original order.
     * @return
     */
    public void refundSplit() {
        SplitRefundReq req = new SplitRefundReq();
        req.setRequestId("2024121923332423");
        req.setPrevRequestId("[prevRequestId]");
        req.setBusinessOrderId("[businessOrderId]");
        req.setAmount("100");
        req.setCurrency("EUR");
        Result<SplitRes> result = this.accountService.refundSplit(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve all splits</h3>
     * Retrieve list of FundSplits
     * @return
     */
    public void retrieveAllSplits() {
        SplitPageReq req = new SplitPageReq();
        req.setPage(1);
        req.setPageSize(10);
        Result<PageResult<SplitDetailRes>> result = this.accountService.retrieveAllSplits(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a split</h3>
     * Retrieve a FundsSplit by Request ID.
     * @return
     */
    public void retrieveSplit() {
        String requestId = "2024121923332423";
        Result<SplitDetailRes> result = this.accountService.retrieveSplit(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a split release</h3>
     * Retrieve a FundsSplit Release by Request ID.
     * @return
     */
    public void retrieveSplitRelease() {
        String requestId = "2024121923332423";
        Result<SplitRes> result = this.accountService.retrieveSplitRelease(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a split refund</h3>
     * Retrieve a FundsSplit Refund by Request ID.
     * @return
     */
    public void retrieveSplitRefund() {
        String requestId = "2024121923332423";
        Result<SplitRes> result = this.accountService.retrieveSplitRefund(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
