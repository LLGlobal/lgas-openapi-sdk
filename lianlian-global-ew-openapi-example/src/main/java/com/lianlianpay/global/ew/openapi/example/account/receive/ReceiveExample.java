package com.lianlianpay.global.ew.openapi.example.account.receive;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.receive.DepositConfirmationCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.receive.DepositConfirmationCreateRes;
import com.lianlianpay.global.ew.openapi.model.account.receive.DepositTransactionDocument;
import com.lianlianpay.global.ew.openapi.service.AccountService;

import java.util.Arrays;

/**
 * @author huyl
 * @since 2025/8/5
 */
public class ReceiveExample extends AuthExample {

    private final AccountService accountService;

    public ReceiveExample() {
        super();
        this.accountService = new AccountService(this.basicAuthClient());
    }

    /**
     * Example for Creating a deposit confirmation
     */
    public void createDepositConfirmation() {
        DepositConfirmationCreateReq req = new DepositConfirmationCreateReq();
        // receive transaction id can get from transaction list
        req.setId("[receive transaction id]");
        req.setBusinessType("GOODS_TRADE");
        //unique request id
        req.setRequestId("20250207135000001");
        req.setActionType("PROCESS");
        DepositTransactionDocument transactionDocument = new DepositTransactionDocument();
        transactionDocument.setTransactionDocumentId("[transaction document id]");
        transactionDocument.setRelationAmount("100");
        transactionDocument.setRelationCurrency("USD");
        req.setTransactionDocumentList(Arrays.asList(transactionDocument));
        Result<DepositConfirmationCreateRes> result = this.accountService.createDepositConfirmation(req);
        if (result.isHttpOk()){
            //do something when http status is 200
            System.out.println(result.getData());
        }
    }
}
