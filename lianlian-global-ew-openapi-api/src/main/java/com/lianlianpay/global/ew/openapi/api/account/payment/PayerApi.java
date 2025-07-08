package com.lianlianpay.global.ew.openapi.api.account.payment;

import com.lianlianpay.global.ew.openapi.model.account.payment.PayerCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.PayerDetailRes;
import com.lianlianpay.global.ew.openapi.model.account.payment.PayerDisconnectRes;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import io.reactivex.Single;
import retrofit2.http.*;

/**
 * A Payer needs to be created if the payer's information of a transaction is required to be collected and verified for compliance purposes. A Payer can be individual or corporate.A Payer needs to be created if the payer's information of a transaction is required to be collected and verified for compliance purposes. A Payer can be individual or corporate.
 * @author huyl
 * @since 2024/11/25
 */
public interface PayerApi {


    /**
     * Create a payer <br/>
     * After a new Payer is created, it will be audited by LianLian Global before it can be used in payout transactions. A notification of the audit result will be sent by Webhook after subscribing the payer related event Payer.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-contacts/payer")
    Single<PayerDetailRes> createPayer(@Body PayerCreateReq req);

    /**
     * Retrieve a payer
     * @param payerId
     * @return
     */
    @GET("/gateway/v1/ew-contacts/payer/{id}")
    Single<PayerDetailRes> retrievePayer(@Path("id") String payerId);

    /**
     * Retrieve a payer by merchant client id
     * @param merchantClientId
     * @return
     */
    @GET("/gateway/v1/ew-contacts/payer/merchant-client-id/{merchant_client_id}")
    Single<PayerDetailRes> retrievePayerByMerchant(@Path("merchant_client_id") String merchantClientId);

    /**
     * Disconnect a payer
     * @param payerId
     * @return
     */
    @DELETE("/gateway/v1/ew-contacts/payer/{id}")
    Single<PayerDisconnectRes> disconnectPayer(@Path("id") String payerId);

    /**
     * Disconnect a payer by merchant client id
     * @param merchantClientId
     * @return
     */
    @DELETE("/gateway/v1/ew-contacts/payer/merchant-client-id/{merchant_client_id}")
    Single<PayerDisconnectRes> disconnectPayerByMerchant(@Path("merchant_client_id") String merchantClientId);

    /**
     * Retrieve all payers
     * @param page
     * @param pageSize
     * @param keyword
     * @return
     */
    @GET("/gateway/v1/ew-contacts/payer/list")
    Single<PageResult<PayerDetailRes>> retrieveAllPayers(@Query("page") Integer page, @Query("page_size") Integer pageSize, @Query("keyword") String keyword);
}
