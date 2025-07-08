package com.lianlianpay.global.ew.openapi.api.account.payment;

import com.lianlianpay.global.ew.openapi.model.account.payment.Payout2AppCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.PayoutCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.PayoutDetailRes;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author huyl
 * @since 2024/11/25
 */
public interface PayoutsApi {


    /**
     * <h3>Retrieve a payout</h3>
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/ew-payouts/{request_id}")
    Single<PayoutDetailRes> retrievePayout(@Path("request_id") String requestId);


    /**
     * <H3>Create a payout</H3> <br/>
     * Create a payout to an account.<br/>
     * The successful creation only represents the successful receipt of the distribution order by LianLian Global, does not means the transaction succeed. You can use Retrieve a Payout by Request ID API to obtain transaction results.<br/>
     * If you want to receive notification of transaction results, you can subscribe to payout related event Payout.<br/>
     * [Note] Payment can include exchange when send_currency and pay_currency are different, and conversion is not included when send_currency matches pay_currency.<br/>
     * The payer is responsible for the payment fee.<br/>
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-payouts")
    Single<PayoutDetailRes> createPayout(@Body PayoutCreateReq req);


    /**
     * <H3>Create a payout to app</H3> <br/>
     * Create a payout to APP(this APP will be onboarding Ewallet). <br/>
     * The successful creation only represents the successful receipt of the distribution order by LianLian Global, does not means the transaction succeed. You can use Retrieve a Payout by Request ID API to obtain transaction results.<br/>
     * If you want to receive notification of transaction results, you can subscribe to payout related event Payout.<br/>
     * [Note] Payment can include exchange when send_currency and pay_currency are different, and conversion is not included when send_currency matches pay_currency.<br/>
     * The payer is responsible for the payment fee.<br/>
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-payouts-to-app")
    Single<PayoutDetailRes> createPayout2App(@Body Payout2AppCreateReq req);
}
