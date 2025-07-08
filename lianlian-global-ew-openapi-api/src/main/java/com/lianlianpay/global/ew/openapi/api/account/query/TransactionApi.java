package com.lianlianpay.global.ew.openapi.api.account.query;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import com.lianlianpay.global.ew.openapi.model.account.query.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;

/**
 * <h3>Transactions</h3>
 * Transactions include Payout, Receipt, Receiving, Conversion, Add Funds, Withdrawal, and Card Payout.
 * @author huyl
 * @since 2024/11/25
 */
public interface TransactionApi {


    /**
     * <h3>Retrieve all transactions</h3>
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path = "/gateway/v1/ew-transactions", hasBody = true)
    Single<PageResult<TransactionDetailRes>> retrieveAllTransactions(@Body TransactionPageReq req);

    /**
     * <h3>Retrieve a receiving</h3>
     * Retrieve the information of the Receiving with the matching Transaction ID. Receiving Accounts are accounts that function as local bank accounts. They can be used to collect funds from around the world. You get account details that enable you to collect funds from various platforms such as Amazon, Etsy, etc.
     * You can apply Receiving Accounts on LianLian Global's website, and by using Receiving API you could query your Receiving accounts and Receiving transactions detail information.
     * <br/><img src="https://docs.lianlianglobal.com/llg_img/0stplt/ooe1JpNsV1Q.png" alt="receiving-accounts">
     * @param id
     * @return
     */
    @GET("/gateway/v1/ew-receivings/{id}")
    Single<ReceivingDetailRes> retrieveReceiving(@Path("id") String id);

    /**
     * <h3>Retrieve a receipt</h3>
     * @param id
     * @return
     */
    @GET("/gateway/v1/ew-receipts/{id}")
    Single<ReceiptDetailRes> retrieveReceipt(@Path("id") String id);

    /**
     * <h3>Retrieve a recharge</h3>
     * Retrieve the information of the Recharge transaction with the matching ID.
     * @param id
     * @return
     */
    @GET("/gateway/v1/ew-recharges/{id}")
    Single<RechargeDetailRes> retrieveRecharge(@Path("id") String id);

    /**
     * <h3>Retrieve a card payout</h3>
     * Retrieve the information of the Card Payout with the matching Transaction ID.
     * @param id
     * @return
     */
    @GET("/gateway/v1/card-payouts/{id}")
    Single<CardPayoutDetailRes> retrieveCardPayout(@Path("id") String id);
}
