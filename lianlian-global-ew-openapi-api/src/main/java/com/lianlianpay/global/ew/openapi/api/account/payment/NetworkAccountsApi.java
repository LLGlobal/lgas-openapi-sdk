package com.lianlianpay.global.ew.openapi.api.account.payment;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import com.lianlianpay.global.ew.openapi.model.account.payment.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import io.reactivex.Single;
import retrofit2.http.*;

/**
 * A Network Account needs to be created when the Beneficiary you want to pay is also a user of LianLian Global. A Network Account can be individual or corporate.
 * @author huyl
 * @since 2024/11/25
 */
public interface NetworkAccountsApi {


    /**
     * Connect a network account
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-agreements/signing")
    Single<NetworkAccountConnectRes> connectNetworkAccount(@Body NetworkAccountConnectReq req);

    /**
     * Retrieve all network accounts
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path ="/gateway/v1/ew-contacts/network/list", hasBody = true)
    Single<PageResult<NetworkAccountDetailRes>> retrieveAllNetworkAccounts(@Body NetworkAccountPageReq req);

    /**
     * Retrieve a network account
     * @param accountId
     * @return
     */
    @GET("/gateway/v1/ew-contacts/network/{id}")
    Single<NetworkAccountDetailRes> retrieveNetworkAccount(@Path("id") String accountId);

    /**
     * Disconnect a network account
     * @param accountId
     * @return
     */
    @DELETE("/gateway/v1/ew-contacts/network/{id}")
    Single<NetworkAccountDisconnectRes> disconnectNetworkAccount(@Path("id") String accountId);

    /**
     * Create a network account
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-contacts/network")
    Single<NetworkAccountDetailRes> createNetworkAccount(@Body NetworkAccountCreateReq req);

    /**
     * Retrieve a network account by merchant client id
     * @param merchantClientId
     * @return
     */
    @GET("/gateway/v1/ew-contacts/network/merchant-client-id/{merchant_client_id}")
    Single<NetworkAccountDetailRes> retrieveNetworkAccountByMerchant(@Path("merchant_client_id") String merchantClientId);

    /**
     * Disconnect a network account by merchant client id
     * @param merchantClientId
     * @return
     */
    @DELETE("/gateway/v1/ew-contacts/network/merchant-client-id/{merchant_client_id}")
    Single<NetworkAccountDisconnectRes> disconnectNetworkAccountByMerchant(@Path("merchant_client_id") String merchantClientId);
}
