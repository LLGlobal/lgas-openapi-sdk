package com.lianlianpay.global.ew.openapi.example.acceptance.payment.online;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.*;
import com.lianlianpay.global.ew.openapi.service.AcceptanceService;

import java.util.Arrays;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/30
 */
public class PaymentExample extends AuthExample {

    private final AcceptanceService acceptanceService;

    public PaymentExample() {
        this.acceptanceService = new AcceptanceService(this.basicAuthClient());
    }

    /**
     * Create a payment
     * @return
     */
    public void createPayment() {

        PaymentCreateReq req = new PaymentCreateReq();
        req.setRequestId("2024121121250002");
        req.setAmount("100.00");
        req.setCurrency("EUR");
        req.setConsentId("[Consent Id from ConsentAPI]");
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerId("[customer unique id in your system]");
        req.setCustomer(customerInfo);
        req.setPaymentMethod("Pay with LianLian");
        Result<PaymentDetailRes> result = acceptanceService.createPayment(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Create a payment request
     * @return
     */
    public void createPaymentRequest() {
        PaymentRequestCreateReq req = new PaymentRequestCreateReq();
        req.setRequestId("2024121121250002");
        req.setAmount("100.00");
        req.setCurrency("EUR");
        req.setPaymentMethod("Pay with LianLian");
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerId("[customer unique id in your system]");
        req.setCustomer(customerInfo);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId("[order unique id in your system]");
        orderInfo.setOrderDescription("[order description]");
        orderInfo.setOrderAmount("100.00");
        orderInfo.setOrderCurrency("EUR");
        orderInfo.setProductId("[product id]");
        orderInfo.setProductName("[product name]");
        orderInfo.setProductCount("1");
        orderInfo.setPurchaseTime(new Date());
        req.setOrders(Arrays.asList(orderInfo));
        req.setReturnUrl("[return url]");
        Result<PaymentRequestDetailRes> result = acceptanceService.createPaymentRequest(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }


    /**
     * Cancel a payment request
     * @return
     */
    public void cancelPaymentRequest() {
        PaymentRequestCancelReq req = new PaymentRequestCancelReq();
        req.setRequestId("2024121121250002");
        Result<PaymentRequestCancelRes> result = acceptanceService.cancelPaymentRequest(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }


    /**
     * Retrieve a payment
     * @return
     */
    public void retrievePayment() {
        String requestId = "2024121121250002";
        Result<PaymentDetailRes> result = acceptanceService.retrievePayment(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
