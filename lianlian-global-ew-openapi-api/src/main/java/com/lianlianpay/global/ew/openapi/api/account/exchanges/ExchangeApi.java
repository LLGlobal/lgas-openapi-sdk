package com.lianlianpay.global.ew.openapi.api.account.exchanges;

import com.lianlianpay.global.ew.openapi.model.account.exchanges.ConversionCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.exchanges.ConversionDetailRes;
import com.lianlianpay.global.ew.openapi.model.account.exchanges.LockedFxQuoteCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.exchanges.LockedFxQuoteRes;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * <h3>Exchanges</h3>
 * The Conversion resources provide the capability to create transactions that convert from one currency into another.
 * A LockFX Quote can be used when creating a Conversion transaction within validity period.
 * @author huyl
 * @since 2024/11/25
 */
public interface ExchangeApi {


    /**
     * <h3>Create a Conversion</h3>
     * Create a new Conversion to be executed. To associate a conversion with a Payout, use the Payout API.
     * Note: On a conversion, both buy_currency and sell_currency will be populated, but define only one of either buy_amount or sell_amount.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-conversions")
    Single<ConversionDetailRes> createConversion(@Body ConversionCreateReq req);

    /**
     * <h3>Retrieve a Conversion</h3>
     * Retrieve a detail of a Conversion transaction.
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/ew-conversions/{request_id}")
    Single<ConversionDetailRes> retrieveConversion(@Path("request_id") String requestId);

    /**
     * <h3>Create a Locked FX Quote</h3>
     * Create a Locked FX Quote to be used in a Conversion transaction.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-conversions/lockfx")
    Single<LockedFxQuoteRes> createLockedFxQuote(@Body LockedFxQuoteCreateReq req);
}
