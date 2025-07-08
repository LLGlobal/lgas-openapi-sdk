package com.lianlianpay.global.ew.openapi.example.account.payment;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.payment.RefundCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.RefundDetailRes;
import com.lianlianpay.global.ew.openapi.service.AccountService;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author huyl
 * @since 2024/12/18
 */
public class RefundsExample extends AuthExample {


    private final AccountService accountService;

    public RefundsExample() {
        this.accountService = new AccountService(super.basicAuthClient());
    }

    /**
     * <h3>Create a refund</h3>
     * When initiating a new refund within the API, it is essential to provide a valid receipt_order_id. This identifier serves as the basis for the refund and ensures that it corresponds to a previously received payment.
     * The process of creating a new refund will result in reimbursing a previously generated charge. The funds will be returned to the original payer who initiated the payment transaction.
     * @return
     */
    public void createRefund() {
        RefundCreateReq req = new RefundCreateReq();
        req.setRequestId("[refund request id]");
        req.setBusinessOrderId("[business order id]");
        // ID from RequestPayment API
        req.setRequestPaymentId("[request payment id]");
        req.setSendCurrency("USD");
        req.setSendAmount("10.00");
        req.setReference("[postscript information visible to the payee]");
        Result<RefundDetailRes> result = accountService.createRefund(req);
        //when http code is 200
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }


    /**
     * <h3>Retrieve a refund</h3>
     * Retrieve a the detail of a refund transaction by Request ID.
     * @return
     */
    public void retrieveRefund() {
        String requestId = "[refund request id]";
        Result<RefundDetailRes> result = accountService.retrieveRefund(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
