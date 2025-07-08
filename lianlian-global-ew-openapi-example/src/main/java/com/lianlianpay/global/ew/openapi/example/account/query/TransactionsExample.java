package com.lianlianpay.global.ew.openapi.example.account.query;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.query.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.service.AccountService;

/**
 * @author huyl
 * @since 2024/12/23
 */
public class TransactionsExample extends AuthExample {


    private final AccountService accountService;

    public TransactionsExample() {
        this.accountService = new AccountService(super.basicAuthClient());
    }

    /**
     * <h3>Retrieve all transactions</h3>
     * @return
     */
    public void retrieveAllTransactions() {
        TransactionPageReq req = new TransactionPageReq();
        req.setPage(1);
        req.setPageSize(10);
        Result<PageResult<TransactionDetailRes>> result = this.accountService.retrieveAllTransactions(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a receiving</h3>
     * Retrieve the information of the Receiving with the matching Transaction ID. Receiving Accounts are accounts that function as local bank accounts. They can be used to collect funds from around the world. You get account details that enable you to collect funds from various platforms such as Amazon, Etsy, etc.
     * You can apply Receiving Accounts on LianLian Global's website, and by using Receiving API you could query your Receiving accounts and Receiving transactions detail information.
     * <br/><img src="https://docs.lianlianglobal.com/llg_img/0stplt/ooe1JpNsV1Q.png" alt="receiving-accounts">
     * @return
     */
    public void retrieveReceiving() {
        String id = "id";
        Result<ReceivingDetailRes> result = this.accountService.retrieveReceiving(id);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a receipt</h3>
     * @return
     */
    public void retrieveReceipt() {
        String id = "id";
        Result<ReceiptDetailRes> result = this.accountService.retrieveReceipt(id);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a recharge</h3>
     * Retrieve the information of the Recharge transaction with the matching ID.
     * @return
     */
    public void retrieveRecharge() {
        String id = "id";
        Result<RechargeDetailRes> result = this.accountService.retrieveRecharge(id);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a card payout</h3>
     * Retrieve the information of the Card Payout with the matching Transaction ID.
     * @return
     */
    public void retrieveCardPayout() {
        String id = "id";
        Result<CardPayoutDetailRes> result = this.accountService.retrieveCardPayout(id);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
