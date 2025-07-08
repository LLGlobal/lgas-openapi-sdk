package com.lianlianpay.global.ew.openapi.api.account.accounts;

import com.lianlianpay.global.ew.openapi.model.account.accounts.*;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author huyl
 * @since 2024/11/25
 */
public interface CoreAccountsApi {


    /**
     * Create an account
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-accounts/account")
    Single<AccountDetailRes> createAccount(@Body AccountCreateReq req);

    /**
     * Retrieve an account
     * @return
     */
    @GET("/gateway/v1/ew-accounts/account")
    Single<AccountDetailRes> retrieveAccount();

    /**
     * Relate an associate account
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-accounts/relate/account")
    Single<AccountDetailRes> relateAssociateAccount(@Body AssociateAccountRelateReq req);

    /**
     * Submit Corporate Account KYC
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-accounts/corporate")
    Single<AccountDetailRes> submitCorporateAccountKyc(@Body CorporateAccountKycReq req);

    /**
     * Submit Individual Account KYC
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-accounts/individual")
    Single<AccountDetailRes> submitIndividualAccountKyc(@Body IndividualKycReq req);

    /**
     * Authorize an account
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-accounts/authorize")
    Single<AccountAuthorizeRes> authorizeAccount(@Body AccountAuthorizeReq req);

    /**
     * Retrieve interim info
     * @return
     */
    @GET("/gateway/v1/ew-accounts/interim")
    Single<AccountDetailRes> retrieveInterimInfo();


    /**
     * Submit Corporate Interim KYC
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-accounts/corporate/interim")
    Single<AccountDetailRes> submitCorporateInterimKyc(@Body CorporateInterimKycReq req);

    /**
     * Submit Individual Interim KYC
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-accounts/individual/interim")
    Single<AccountDetailRes> submitIndividualInterimKyc(@Body IndividualInterimKycReq req);
}
