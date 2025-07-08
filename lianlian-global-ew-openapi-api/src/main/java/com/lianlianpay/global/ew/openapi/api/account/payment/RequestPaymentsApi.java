package com.lianlianpay.global.ew.openapi.api.account.payment;

import com.lianlianpay.global.ew.openapi.model.account.payment.*;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * <h3>Request Payments</h3>
 * Requested payment that from a payer.
 * @author huyl
 * @since 2024/11/25
 */
public interface RequestPaymentsApi {

    /**
     * Retrieve a request payment
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/ew-request-payments/{request_id}")
    Single<RequestPaymentDetailRes> retrievePayment(@Path("request_id") String requestId);

    /**
     * Create a request payment
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-request-payments")
    Single<RequestPaymentDetailRes> createPayment(@Body RequestPaymentCreateReq req);

    /**
     * Create a request payment url
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-request-payments/url")
    Single<RequestPaymentUrlRes> createPaymentUrl(@Body RequestPaymentUrlCreateReq req);

    /**
     * Cancel a request payment
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-request-payments/cancel")
    Single<RequestPaymentCancelRes> cancelPayment(@Body RequestPaymentCancelReq req);
}
