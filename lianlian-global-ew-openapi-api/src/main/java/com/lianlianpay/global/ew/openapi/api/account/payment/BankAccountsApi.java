package com.lianlianpay.global.ew.openapi.api.account.payment;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import com.lianlianpay.global.ew.openapi.model.account.payment.BankAccountConnectReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.BankAccountDisconnectRes;
import com.lianlianpay.global.ew.openapi.model.account.payment.BankAccountPageReq;
import com.lianlianpay.global.ew.openapi.model.account.payment.BankAccountRes;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import io.reactivex.Single;
import retrofit2.http.*;

/**
 * A Bank Account needs to be created when the Beneficiary you want to pay is a bank account. A Bank Account can be individual or corporate.
 * @author huyl
 * @since 2024/11/25
 */
public interface BankAccountsApi {


    /**
     * Retrieve all Bank Accounts.
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path ="/gateway/v1/ew-contacts/bank/list", hasBody = true)
    Single<PageResult<BankAccountRes>> retrieveAllBankAccounts(@Body BankAccountPageReq req);

    /**
     * Retrieve a specific bank account by ID.
     * @param accountId
     * @return
     */
    @GET("/gateway/v1/ew-contacts/bank/{id}")
    Single<BankAccountRes> retrieveBankAccount(@Path("id") String accountId);

    /**
     * Disconnect a specific bank account by ID.
     * @param accountId
     * @return Characters "OK" if Succeeded
     */
    @DELETE("/gateway/v1/ew-contacts/bank/{id}")
    Single<BankAccountDisconnectRes> disconnectBankAccount(@Path("id") String accountId);

    /**
     * A Bank Account can be used in payout transactions to an external bank account. A notification of the audit result will be sent by Webhook after creation and audit by LianLian Global, so make sure you subscribe the payee related event Payee. In the bank_info, some optional fields sometimes can be required depends on clearing_code and bank_country_code.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-contacts/bank")
    Single<BankAccountRes> connectBankAccount(@Body BankAccountConnectReq req);

    /**
     * Retrieve a specific bank account by the merchant_client_id.
     * @param merchantClientId
     * @return
     */
    @GET("/gateway/v1/ew-contacts/bank/merchant-client-id/{merchant_client_id}")
    Single<BankAccountRes> retrieveBankAccountByMerchant(@Path("merchant_client_id") String merchantClientId);

    /**
     * Disconnect a specific bank account by the merchant_client_id.
     * @param merchantClientId
     * @return Characters "OK" if Succeeded
     */
    @DELETE("/gateway/v1/ew-contacts/bank/merchant-client-id/{merchant_client_id}")
    Single<BankAccountDisconnectRes> disconnectBankAccountByMerchant(@Path("merchant_client_id") String merchantClientId);

}
