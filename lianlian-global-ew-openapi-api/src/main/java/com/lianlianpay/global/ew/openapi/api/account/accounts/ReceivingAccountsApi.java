package com.lianlianpay.global.ew.openapi.api.account.accounts;

import com.lianlianpay.global.ew.openapi.model.account.accounts.ReceivingAccountDetailRes;
import com.lianlianpay.global.ew.openapi.model.account.accounts.ReceivingAccountOpenReq;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

/**
 * @author huyl
 * @since 2024/11/25
 */
public interface ReceivingAccountsApi {

    /**
     * Open receiving account <br/>
     * There are accounts under application. Applications may not be initiated.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-receiving/accounts")
    Single<ReceivingAccountDetailRes> openReceivingAccount(@Body ReceivingAccountOpenReq req);

    /**
     * Retrieve all receiving accounts
     * @return
     */
    @GET("/gateway/v1/ew-receiving/accounts")
    Single<List<ReceivingAccountDetailRes>> retrieveAllReceivingAccounts();

    /**
     * Retrieve a receiving account <br/>
     * Retrieve the information of the Receiving Account with the matching ID.
     * @param accountId
     * @return
     */
    @GET("/gateway/v1/ew-receiving/accounts/{id}")
    Single<ReceivingAccountDetailRes> retrieveReceivingAccount(@Path("id") String accountId);
}
