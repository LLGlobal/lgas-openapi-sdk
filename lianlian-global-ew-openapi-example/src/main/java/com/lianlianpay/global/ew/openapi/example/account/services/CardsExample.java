package com.lianlianpay.global.ew.openapi.example.account.services;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.service.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.service.AccountService;

import java.util.Arrays;

/**
 * @author huyl
 * @since 2024/12/23
 */
public class CardsExample extends AuthExample {

    private final AccountService accountService;

    public CardsExample() {
        this.accountService = new AccountService(this.basicAuthClient());
    }

    /**
     * <h3>Open a service</h3>
     * Agree to open the VCC service agreement.
     * @return
     */
    public void openService() {
        ServiceOpenReq req = new ServiceOpenReq();
        req.setAgreementId("[agreement id]");
        req.setPaymentMethod(Arrays.asList("Advertising / Affiliate marketing", "Digital content & product"));
        req.setAgreedToTermsAndConditions(true);
        Result<ServiceOpenRes> result = accountService.openService(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Apply for a card</h3>
     * The card object is the actual resource associated with the card issued out by LLG.
     * @return
     */
    public void applyCard() {
        CardApplyReq req = new CardApplyReq();
        req.setCardName("test");
        req.setContactEmail("test@test.com");
        req.setCurrency("USD");
        req.setDailyLimit("10000");
        req.setMonthlyLimit("10000");
        req.setPerTransactionLimit("10000");
        req.setAccumulatedSpendLimit("10000");
        Result<CardDetailRes> result = accountService.applyCard(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Set card limits</h3>
     * @return
     */
    public void setCardLimit() {
        CardLimitSetReq req = new CardLimitSetReq();
        req.setCardId("card id");
        req.setDailyLimit("10000");
        req.setMonthlyLimit("10000");
        req.setPerTransactionLimit("10000");
        Result<CardDetailRes> result = accountService.setCardLimit(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Cancel a card</h3>
     * Cancel the card. The card will not be available after the operation.
     * @return
     */
    public void cancelCard() {
        CardCancelReq req = new CardCancelReq();
        req.setCardId("card id");
        Result<CardDetailRes> result = accountService.cancelCard(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve all cards</h3>
     * Get cards issued under an account.
     * @return
     */
    public void retrieveAllCards() {
        CardPageReq req = new CardPageReq();
        req.setPage(1);
        req.setPageSize(10);
        Result<PageResult<CardDetailRes>> result = accountService.retrieveAllCards(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a card</h3>
     * Get the details of a card.
     * @return
     */
    public void retrieveCard() {
        Result<CardDetailRes> result = accountService.retrieveCard("card id");
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a sensitive card</h3>
     * Retrieve a sensitive card details.PCI certified can apply for the interface.
     * @return
     */
    public void retrieveSensitiveCard() {
        Result<SensitiveCardDetailRes> result = accountService.retrieveSensitiveCard("card id");
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a sensitive card URL</h3>
     * View card sensitive data. By returning the URL .
     * Let the user authenticate and show card details directly.
     * @return
     */
    public void retrieveSensitiveCardUrl() {
        Result<SensitiveCardUrlRes> result = accountService.retrieveSensitiveCardUrl("card id");
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve card authorizations</h3>
     * Get a authorization transaction.
     * @return
     */
    public void retrieveCardAuthorizations() {
        CardAuthorizationPageReq req = new CardAuthorizationPageReq();
        req.setPage(1);
        req.setPageSize(10);
        Result<PageResult<CardAuthorizationDetailRes>> result = accountService.retrieveCardAuthorizations(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve card settlements</h3>
     * Get a settlement transaction.
     * @return
     */
    public void retrieveCardSettlements() {
        CardSettlementPageReq req = new CardSettlementPageReq();
        req.setPage(1);
        req.setPageSize(10);
        Result<PageResult<CardSettlementDetailRes>> result = accountService.retrieveCardSettlements(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
