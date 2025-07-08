package com.lianlianpay.global.ew.openapi.api.account.services;

import com.lianlianpay.global.ew.openapi.model.account.service.*;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * <h3>Remittance</h3>
 * This service is designed to be a secure and convenient way
 * for sending CNY to individuals in mainland China.
 * Overseas remitters can easily make cross-border remittances
 * to UnionPay cards of 70 national and local banks,
 * including industrial and Commercial Bank of China, Bank of China, China Construction Bank, Agricultural Bank of China, Bank of communications, Huaxia Bank and Bank of Dalian.
 * Cardholders in China can directly collect the money in RMB to further consume or withdraw to avoid the trouble of foreign exchange.
 * The payee does not need to handle the payment of remittance or pay the bank service fee;
 * she/he can use the money directly. In general, the remittance is deposited into the payee’s account in real time or within 12 hours.
 * According to China's State Administration of Foreign Exchange (SAFE), each person can receive a maximum of $50,000 per year and settle the exchange in yuan.
 * @author huyl
 * @since 2024/11/25
 */
public interface RemittanceApi {


    /**
     * <h3>Retrieve a fx quote</h3>
     * Query remittance transaction FX rate
     * @param req
     * @return
     */
    @POST("/gateway/v1/remittance/fxrate")
    Single<FxQuoteDetailRes> retrieveFxQuote(@Body FxQuoteQueryReq req);

    /**
     * <h3>Create a remittance</h3>
     * Before sending out a remittance transaction, partner must initiate a remittance creation request to LianLian Global to ensure the transaction is able to send.
     * @param req
     * @return
     */
    @POST("/gateway/v1/remittance")
    Single<RemittanceCreateRes> createRemittance(@Body RemittanceCreateReq req);

    /**
     * <h3>Submit a remittance</h3>
     * Partner initiates remittance submission request to send the transaction. The remittance creation request must be successful before remittance submission.
     * @param req
     * @return
     */
    @POST("/gateway/v1/remittance/submit")
    Single<RemittanceDetailRes> submitRemittance(@Body RemittanceSubmitReq req);

    /**
     * <h3>Retrieve a remittance</h3>
     * Retrieve a Remittance by Request ID.
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/remittance/{request_id}")
    Single<RemittanceDetailRes> retrieveRemittance(@Path("request_id") String requestId);
}
