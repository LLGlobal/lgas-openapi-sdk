package com.lianlianpay.global.ew.openapi.api.supporting;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.model.supporting.*;
import io.reactivex.Single;
import retrofit2.http.*;

/**
 * Bank account verification API
 * @author huyl
 * @since 2025/4/1
 */
public interface BankAccountVerificationApi {


    /**
     * Verify a bank account
     * @param req
     * @return
     */
    @POST("/gateway/v1/verification/bank")
    Single<BankAccountVerifyRes> verifyBankAccount(@Body BankAccountVerifyReq req);


    /**
     * Validate verification.
     * @param req
     * @return
     */
    @POST("/gateway/v1/verification/validate")
    Single<BankAccountVerifyDetailRes> validateBankAccountVerification(@Body BankAccountVerificationValidateReq req);


    /**
     * Retrieve a bank account verification
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/verification/{request_id}")
    Single<BankAccountVerifyDetailRes> retrieveBankAccountVerification(@Path("request_id") String requestId);


    /**
     * Retrieve all bank account verifications
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path = "/gateway/v1/verification/list", hasBody = true)
    Single<PageResult<BankAccountVerifyDetailRes>> retrieveAllBankAccountVerification(@Body BankAccountVerificationPageReq req);
}
