package com.lianlianpay.global.ew.openapi.api.account.platform;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import com.lianlianpay.global.ew.openapi.model.account.platform.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import io.reactivex.Single;
import retrofit2.http.*;

/**
 * <h3>Splits</h3>
 * Funds in the holding account are inaccessible to all parties until the funds are released to other merchant accounts.
 * A Platform can choose to perform a release anytime. On release, funds are transferred to a account for the merchant.
 * @author huyl
 * @since 2024/11/25
 */
public interface SplitsApi {


    /**
     * <h3>Create a split</h3>
     * Use this endpoint to send settlement data to LLG for further release
     * after the corresponding funds been deposited and bank_reference matched.
     * @param req
     * @return
     */
    @POST("/gateway/v1/funds-split")
    Single<SplitDetailRes> createSplit(@Body SplitCreateReq req);

    /**
     * <h3>Release a split</h3>
     * Use this endpoint to release a previous fund split and funds
     * will be deducted from holding account and added to seller's available balance.
     * @param req
     * @return
     */
    @POST("/gateway/v1/funds-split/release")
    Single<SplitRes> releaseSplit(@Body SplitReleaseReq req);

    /**
     * <h3>Refund a split</h3>
     * If the Fund split has not yet been release, it can be refunded.
     * Partial refunds can be made for the original order.
     * @param req
     * @return
     */
    @POST("/gateway/v1/funds-split/refund")
    Single<SplitRes> refundSplit(@Body SplitRefundReq req);

    /**
     * <h3>Retrieve all splits</h3>
     * Retrieve list of FundSplits
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path = "/gateway/v1/funds/splits", hasBody = true)
    Single<PageResult<SplitDetailRes>> retrieveAllSplits(@Body SplitPageReq req);

    /**
     * <h3>Retrieve a split</h3>
     * Retrieve a FundsSplit by Request ID.
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/funds-split/{request_id}")
    Single<SplitDetailRes> retrieveSplit(@Path("request_id") String requestId);

    /**
     * <h3>Retrieve a split release</h3>
     * Retrieve a FundsSplit Release by Request ID.
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/funds-split/release/{request_id}")
    Single<SplitRes> retrieveSplitRelease(@Path("request_id") String requestId);

    /**
     * <h3>Retrieve a split refund</h3>
     * Retrieve a FundsSplit Refund by Request ID.
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/funds-split/refund/{request_id}")
    Single<SplitRes> retrieveSplitRefund(@Path("request_id") String requestId);
}
