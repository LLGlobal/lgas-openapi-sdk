package com.lianlianpay.global.ew.openapi.example.acceptance.payment.online;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.RefundCreateReq;
import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.RefundDetailRes;
import com.lianlianpay.global.ew.openapi.service.AcceptanceService;

/**
 * @author huyl
 * @since 2024/12/30
 */
public class RefundExample extends AuthExample {

    private final AcceptanceService acceptanceService;

    public RefundExample() {
        this.acceptanceService = new AcceptanceService(basicAuthClient());
    }

    /**
     * Create a refund
     * When initiating a new refund within the API, it is essential to provide a valid receipt_order_id.
     * This identifier serves as the basis for the refund and ensures that it corresponds to a previously received payment.
     * The process of creating a new refund will result in reimbursing a previously generated charge.
     * The funds will be returned to the original payer who initiated the payment transaction.
     * @return
     */
    public void createRefund() {
        RefundCreateReq req = new RefundCreateReq();
        req.setRequestId("refund_" + System.currentTimeMillis());
        req.setBusinessOrderId("business_order_" + System.currentTimeMillis());
        req.setAmount("0.01");
        req.setCurrency("EUR");
        req.setReference("[postscript]");
        req.setPaymentRequestId("[original payment request id]");

        Result<RefundDetailRes> result = acceptanceService.createRefund(req);

        //when http code is 200
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve a refund
     * Retrieve the detail of a refund transaction by Request ID.
     * @return
     */
    public void retrieveRefund() {
        String requestId = "[refund request id]";
        Result<RefundDetailRes> result = acceptanceService.retrieveRefund(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
