package com.lianlianpay.global.ew.openapi.api.account.payment;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import com.lianlianpay.global.ew.openapi.model.account.payment.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import io.reactivex.Single;
import retrofit2.http.*;

/**
 * @author huyl
 * @since 2024/11/25
 */
public interface WithdrawApi {

    /**
     * <h3>Create a beneficiary account</h3>
     * Create a new beneficiary to be stored on the LLG platform.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-beneficiary/account")
    Single<BeneficiaryAccountDetailRes> createBeneficiaryAccount(@Body BeneficiaryAccountCreateReq req);

    /**
     * <h3>Retrieve all beneficiary accounts</h3>
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path ="/gateway/v1/ew-beneficiary/account/list", hasBody = true)
    Single<PageResult<BeneficiaryAccountDetailRes>> retrieveAllBeneficiaryAccounts(@Body BeneficiaryAccountPageReq req);


    /**
     * <h3>Create a withdraw</h3>
     * <p>Create a withdraw to a Beneficiary.
     * The successful creation only represents the successful receipt of the distribution order by LianLian Global, does not means the transaction succeed. You can use Retrieve a Withdraw by Request ID API to obtain transaction results.
     * If you want to receive notification of transaction results, you can subscribe to event withdraw.
     * [Note] withdraw can include exchange when send_currency and withdraw_currency are different, and conversion is not included when send_currency matches withdraw_currency.
     * The payer is responsible for the payment fee.</p>
     **/
    @POST("/gateway/v1/ew-withdraw")
    Single<WithdrawDetailRes> createWithdraw(@Body WithdrawCreateReq req);

    /**
     * <h3>Retrieve a withdraw</h3>
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/ew-withdraw/{request_id}")
    Single<WithdrawDetailRes> retrieveWithdraw(@Path("request_id") String requestId);
}
