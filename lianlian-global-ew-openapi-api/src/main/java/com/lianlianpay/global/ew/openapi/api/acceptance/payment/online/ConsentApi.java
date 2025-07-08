package com.lianlianpay.global.ew.openapi.api.acceptance.payment.online;

import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.ConsentCancelReq;
import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.ConsentCreateReq;
import com.lianlianpay.global.ew.openapi.model.acceptance.payment.online.ConsentDetailRes;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author huyl
 * @since 2024/11/25
 */
public interface ConsentApi {


    /**
     * Create a consent <br/>
     * Create a Consent URL for a Payer.
     * @param req
     * @return
     */
    @POST("/gateway/v1/acquire/consent/url")
    Single<ConsentDetailRes> createConsent(@Body ConsentCreateReq req);

    /**
     * Cancel a consent <br/>
     * @param req
     * @return
     */
    @POST("/gateway/v1/acquire/consent/cancel")
    Single<ConsentDetailRes> cancelConsent(@Body ConsentCancelReq req);

    /**
     * Retrieve the detail of a consent by Request ID.<br/>
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/acquire/consent/{request_id}")
    Single<ConsentDetailRes> retrieveConsent(@Path("request_id") String requestId);
}
