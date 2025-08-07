package com.lianlianpay.global.ew.openapi.service;

import com.lianlianpay.global.ew.openapi.api.acceptance.finance.SettlementReportApi;
import com.lianlianpay.global.ew.openapi.api.acceptance.payment.online.ConsentApi;
import com.lianlianpay.global.ew.openapi.api.acceptance.payment.online.PaymentApi;
import com.lianlianpay.global.ew.openapi.api.acceptance.payment.online.RefundApi;
import com.lianlianpay.global.ew.openapi.client.Client;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.acceptance.finance.SettlementReportDetailRes;
import com.lianlianpay.global.ew.openapi.model.acceptance.finance.SettlementReportDownloadReq;
import com.lianlianpay.global.ew.openapi.model.acceptance.finance.SettlementReportPageReq;
import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import okhttp3.ResponseBody;

/**
 * @author huyl
 * @since 2024/12/17
 */
public class AcceptanceService {


    /**
     * client
     */
    private final Client client;

    /**
     * Settlement Report API
     */
    private final SettlementReportApi settlementReportApi;

    /**
     * Consent API
     */
    private final ConsentApi consentApi;

    /**
     * Payment API
     */
    private final PaymentApi paymentApi;
    
    /**
     * Refund API
     */
    private final RefundApi refundApi;
    
    public AcceptanceService(Client client) {
        this.client = client;
        this.settlementReportApi = this.client.create(SettlementReportApi.class);
        this.consentApi = this.client.create(ConsentApi.class);
        this.paymentApi = this.client.create(PaymentApi.class);
        this.refundApi = this.client.create(RefundApi.class);
    }



    /**
     * Retrieve all settlements.
     * @param req
     * @return
     */
    public Result<PageResult<SettlementReportDetailRes>> retrieveAllSettlements(SettlementReportPageReq req) {
        return client.execute(settlementReportApi.retrieveAllSettlements(req));
    }


    /**
     * Download settlement report file by id.
     * @param req
     * @return
     */
    public Result<ResponseBody> downloadSettlementReport(SettlementReportDownloadReq req) {
        return client.execute(settlementReportApi.downloadSettlementReport(req));
    }


    /**
     * Create a consent <br/>
     * Create a Consent URL for a Payer.
     * @param req
     * @return
     */
    public Result<ConsentDetailRes> createConsent(ConsentCreateReq req) {
        return client.execute(consentApi.createConsent(req));
    }

    /**
     * Cancel a consent <br/>
     * @param req
     * @return
     */
    public Result<ConsentDetailRes> cancelConsent(ConsentCancelReq req) {
        return client.execute(consentApi.cancelConsent(req));
    }

    /**
     * Retrieve the detail of a consent by Request ID.<br/>
     * @param requestId
     * @return
     */
    public Result<ConsentDetailRes> retrieveConsent(String requestId) {
        return client.execute(consentApi.retrieveConsent(requestId));
    }

    /**
     * Create a payment
     * @param req
     * @return
     */
    public Result<PaymentDetailRes> createPayment(PaymentCreateReq req) {
        return client.execute(paymentApi.createPayment(req));
    }

    /**
     * Create a payment request
     * @param req
     * @return
     */
    public Result<PaymentRequestDetailRes> createPaymentRequest(PaymentRequestCreateReq req) {
        return client.execute(paymentApi.createPaymentRequest(req));
    }


    /**
     * Cancel a payment request
     * @param req
     * @return
     */
    public Result<PaymentRequestCancelRes> cancelPaymentRequest(PaymentRequestCancelReq req) {
        return client.execute(paymentApi.cancelPaymentRequest(req));
    }


    /**
     * Retrieve a payment
     * @param requestId
     * @return
     */
    public Result<PaymentDetailRes> retrievePayment(String requestId) {
        return client.execute(paymentApi.retrievePayment(requestId));
    }

    /**
     * Create a refund
     * When initiating a new refund within the API, it is essential to provide a valid receipt_order_id. This identifier serves as the basis for the refund and ensures that it corresponds to a previously received payment.
     *
     * The process of creating a new refund will result in reimbursing a previously generated charge. The funds will be returned to the original payer who initiated the payment transaction.
     * @param req
     * @return
     */
    public Result<RefundDetailRes> createRefund(RefundCreateReq req) {
        return client.execute(refundApi.createRefund(req));
    }


    /**
     * Retrieve a refund
     * Retrieve the detail of a refund transaction by Request ID.
     * @param requestId
     * @return
     */
    public Result<RefundDetailRes> retrieveRefund(String requestId) {
        return client.execute(refundApi.retrieveRefund(requestId));
    }

    /**
     * Refresh access token
     * @param accessToken
     * @return
     */
    public AcceptanceService accessToken(String accessToken) {
        this.client.getConfiguration().setAccessToken(accessToken);
        return this;
    }
}
