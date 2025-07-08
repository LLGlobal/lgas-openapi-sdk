package com.lianlianpay.global.ew.openapi.api.account.payment;

import com.lianlianpay.global.ew.openapi.model.account.payment.FeeEstimateReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.FeeEstimateRes;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * <h3>Estimate</h3>
 * Before calling the payout/withdrawal interface, you can call the Estimate interface
 * to query the fees that will be charged for this payout/withdrawal and the current exchange rate information..
 * @author huyl
 * @since 2025/4/29
 */
public interface EstimateApi {


    /**
     * Estimate a fee
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-estimate")
    Single<FeeEstimateRes> estimateFee(@Body FeeEstimateReq req);
}
