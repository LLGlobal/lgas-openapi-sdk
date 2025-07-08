package com.lianlianpay.global.ew.openapi.api.acceptance.payment.online;

import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.*;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Requested payment that from a payer.
 * @author huyl
 * @since 2024/11/25
 */
public interface PaymentApi {

    /**
     * Create a payment
     * @param req
     * @return
     */
    @POST("/gateway/v1/acquire-request-payment")
    Single<PaymentDetailRes> createPayment(@Body PaymentCreateReq req);

    /**
     * Create a payment request
     * @param req
     * @return
     */
    @POST("/gateway/v1/acquire-request-payment/url")
    Single<PaymentRequestDetailRes> createPaymentRequest(@Body PaymentRequestCreateReq req);


    /**
     * Cancel a payment request
     * @param req
     * @return
     */
    @POST("/gateway/v1/acquire-request-payment/cancel")
    Single<PaymentRequestCancelRes> cancelPaymentRequest(@Body PaymentRequestCancelReq req);


    /**
     * Retrieve a payment
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/acquire-request-payment/{request_id}")
    Single<PaymentDetailRes> retrievePayment(@Path("request_id") String requestId);
}
