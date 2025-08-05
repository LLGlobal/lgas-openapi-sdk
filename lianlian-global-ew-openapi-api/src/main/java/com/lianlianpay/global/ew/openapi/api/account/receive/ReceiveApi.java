package com.lianlianpay.global.ew.openapi.api.account.receive;

import com.lianlianpay.global.ew.openapi.model.account.receive.DepositConfirmationCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.receive.DepositConfirmationCreateRes;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author huyl
 * @since 2025/8/5
 */
public interface ReceiveApi {


    /**
     * <h3>Create Deposit Confirmation.</h3>
     * If the action_type =PROCESS, the funds are added to the receiving account. If action_type =REFUND, a refund is initiated.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-receivings/deposit")
    Single<DepositConfirmationCreateRes> createDepositConfirmation(@Body DepositConfirmationCreateReq req);
}
