package com.lianlianpay.global.ew.openapi.api.authentication;

import com.lianlianpay.global.ew.openapi.model.authentication.OAuthReq;
import com.lianlianpay.global.ew.openapi.model.authentication.OAuthRes;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @author huyl
 * @since 2024/12/26
 */
public interface OAuthApi {


    /**
     * <h3>OAuth2.0 Token</h3>
     * You can use the OAuth 2.0 client credentials grant specified in RFC 6749, to access web-hosted resources by using the identity of an application.
     * This type of grant is commonly used for server-to-server interactions that must run in the background, without immediate interaction with a user.
     * These types of applications are often referred to as daemons or service accounts.
     * @param req
     * @return
     */
    @GET("/gateway/v1/ew-oauth2/token")
    Single<OAuthRes> getAccessToken(@QueryMap OAuthReq req);
}
