package com.lianlianpay.global.ew.openapi.api.account.payment;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import com.lianlianpay.global.ew.openapi.model.account.payment.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import io.reactivex.Single;
import retrofit2.http.*;

/**
 * <h3>Mandate</h3>
 * Contractual agreement.
 * @author huyl
 * @since 2024/11/25
 */
public interface MandateApi {


    /**
     * <h3>Create a mandate</h3>
     * Create a Mandate URL for a Payer.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-consent/url")
    Single<MandateCreateRes> createMandate(@Body MandateCreateReq req);

    /**
     * <h3>Cancel a mandate</h3>
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-consent/cancel")
    Single<MandateDetailRes> cancelMandate(@Body MandateCancelReq req);

    /**
     * <h3>Retrieve a mandate</h3>
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/ew-consent/{request_id}")
    Single<MandateDetailRes> retrieveMandate(@Path("request_id") String requestId);

    /**
     * <h3>Retrieve all mandates</h3>
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path ="/gateway/v1/ew-consent", hasBody = true)
    Single<PageResult<MandateDetailRes>> retrieveAllMandates(@Body MandatePageReq req);
}
