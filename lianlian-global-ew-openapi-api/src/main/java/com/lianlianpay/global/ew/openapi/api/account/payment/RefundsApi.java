package com.lianlianpay.global.ew.openapi.api.account.payment;

import com.lianlianpay.global.ew.openapi.model.account.payment.RefundCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.RefundDetailRes;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * <h3>Refunds</h3>
 * The Refunds API allows the flexibility to opt for partial refunds, enabling the refunding of a specific portion of a charge. This capability can be utilized multiple times as needed for partial reimbursements.
 * @author huyl
 * @since 2024/11/25
 */
public interface RefundsApi {


    /**
     * <h3>Create a refund</h3>
     * When initiating a new refund within the API, it is essential to provide a valid receipt_order_id. This identifier serves as the basis for the refund and ensures that it corresponds to a previously received payment.
     * The process of creating a new refund will result in reimbursing a previously generated charge. The funds will be returned to the original payer who initiated the payment transaction.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-receipt/refund")
    Single<RefundDetailRes> createRefund(@Body RefundCreateReq req);


    /**
     * <h3>Retrieve a refund</h3>
     * Retrieve a the detail of a refund transaction by Request ID.
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/ew-receipt/refund/{request_id}")
    Single<RefundDetailRes> retrieveRefund(@Path("request_id") String requestId);
}
