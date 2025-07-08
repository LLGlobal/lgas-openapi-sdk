package com.lianlianpay.global.ew.openapi.example.account.exchanges;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.exchanges.ConversionCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.exchanges.ConversionDetailRes;
import com.lianlianpay.global.ew.openapi.model.account.exchanges.LockedFxQuoteCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.exchanges.LockedFxQuoteRes;
import com.lianlianpay.global.ew.openapi.service.AccountService;

/**
 * @author huyl
 * @since 2024/12/23
 */
public class ExchangeExample extends AuthExample {

    private final AccountService accountService;

    public ExchangeExample() {
        this.accountService = new AccountService(super.basicAuthClient());
    }

    /**
     * <h3>Create a Conversion</h3>
     * Create a new Conversion to be executed. To associate a conversion with a Payout, use the Payout API.
     * Note: On a conversion, both buy_currency and sell_currency will be populated, but define only one of either buy_amount or sell_amount.
     * @return
     */
    public void createConversion() {
        ConversionCreateReq req = new ConversionCreateReq();
        req.setRequestId("2024121923332423");
        req.setBusinessOrderId("[businessOrderId]");
        req.setSellCurrency("EUR");
        req.setSellAmount("100");
        req.setBuyCurrency("USD");
        req.setRateId("[rateId]");
        Result<ConversionDetailRes> result = this.accountService.createConversion(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a Conversion</h3>
     * Retrieve a detail of a Conversion transaction.
     * @return
     */
    public void retrieveConversion() {
        String requestId = "2024121923332423";
        Result<ConversionDetailRes> result = this.accountService.retrieveConversion(requestId);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Create a Locked FX Quote</h3>
     * Create a Locked FX Quote to be used in a Conversion transaction.
     * @return
     */
    public void createLockedFxQuote() {
        LockedFxQuoteCreateReq req = new LockedFxQuoteCreateReq();
        req.setSellCurrency("EUR");
        req.setBuyCurrency("USD");
        req.setValidity("T_0");
        Result<LockedFxQuoteRes> result = this.accountService.createLockedFxQuote(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
