package com.lianlianpay.global.ew.openapi.api.account.accounts;

import com.lianlianpay.global.ew.openapi.model.account.accounts.BalanceDetailRes;
import io.reactivex.Single;
import retrofit2.http.GET;

import java.util.List;

/**
 * The Balance API can be used to get available balances in each currency. <br/>
 * Different currency of available balances at present under your LianLian Global account.
 * @author huyl
 * @since 2024/11/25
 */
public interface BalancesApi {


    /**
     * Retrieve all balances
     * @return
     */
    @GET("/gateway/v1/ew-balances")
    Single<List<BalanceDetailRes>> retrieveAllBalances();

}
