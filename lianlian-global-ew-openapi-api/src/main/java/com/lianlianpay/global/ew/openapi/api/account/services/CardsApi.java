package com.lianlianpay.global.ew.openapi.api.account.services;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import com.lianlianpay.global.ew.openapi.model.account.service.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import io.reactivex.Single;
import retrofit2.http.*;

/**
 * <h3>Cards</h3>
 * You can create virtual cards associated with your organisation,
 * these cards can be single or multi-usage and be restricted
 * by merchant code, currency and transaction amount.
 * @author huyl
 * @since 2024/11/25
 */
public interface CardsApi {


    /**
     * <h3>Open a service</h3>
     * Agree to open the VCC service agreement.
     * @param req
     * @return
     */
    @POST("/gateway/v1/service/agreement")
    Single<ServiceOpenRes> openService(@Body ServiceOpenReq req);

    /**
     * <h3>Apply for a card</h3>
     * The card object is the actual resource associated with the card issued out by LLG.
     * @param req
     * @return
     */
    @POST("/gateway/v1/cards")
    Single<CardDetailRes> applyCard(@Body CardApplyReq req);

    /**
     * <h3>Set card limits</h3>
     * @param req
     * @return
     */
    @POST("/gateway/v1/cards/limits")
    Single<CardDetailRes> setCardLimit(@Body CardLimitSetReq req);

    /**
     * <h3>Cancel a card</h3>
     * Cancel the card. The card will not be available after the operation.
     * @param req
     * @return
     */
    @POST("/gateway/v1/cards/cancel")
    Single<CardDetailRes> cancelCard(@Body CardCancelReq req);

    /**
     * <h3>Retrieve all cards</h3>
     * Get cards issued under an account.
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path = "/gateway/v1/cards/list", hasBody = true)
    Single<PageResult<CardDetailRes>> retrieveAllCards(@Body CardPageReq req);

    /**
     * <h3>Retrieve a card</h3>
     * Get the details of a card.
     * @param cardId
     * @return
     */
    @GET("/gateway/v1/cards/detail/{card_id}")
    Single<CardDetailRes> retrieveCard(@Path("card_id") String cardId);

    /**
     * <h3>Retrieve a sensitive card</h3>
     * Retrieve a sensitive card details.PCI certified can apply for the interface.
     * @param cardId
     * @return
     */
    @GET("/gateway/v1/cards/sensitive/details/{card_id}")
    Single<SensitiveCardDetailRes> retrieveSensitiveCard(@Path("card_id") String cardId);

    /**
     * <h3>Retrieve a sensitive card URL</h3>
     * View card sensitive data. By returning the URL .
     * Let the user authenticate and show card details directly.
     * @param cardId
     * @return
     */
    @GET("/gateway/v1/cards/sensitive/details/url/{card_id}")
    Single<SensitiveCardUrlRes> retrieveSensitiveCardUrl(@Path("card_id") String cardId);

    /**
     * <h3>Retrieve card authorizations</h3>
     * Get a authorization transaction.
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path = "/gateway/v1/cards/authorizations", hasBody = true)
    Single<PageResult<CardAuthorizationDetailRes>> retrieveCardAuthorizations(@Body CardAuthorizationPageReq req);

    /**
     * <h3>Retrieve card settlements</h3>
     * Get a settlement transaction.
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path = "/gateway/v1/cards/settlement", hasBody = true)
    Single<PageResult<CardSettlementDetailRes>> retrieveCardSettlements(@Body CardSettlementPageReq req);
}
