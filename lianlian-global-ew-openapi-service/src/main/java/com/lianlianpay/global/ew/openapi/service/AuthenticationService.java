package com.lianlianpay.global.ew.openapi.service;

import com.lianlianpay.global.ew.openapi.api.authentication.OAuthApi;
import com.lianlianpay.global.ew.openapi.client.Client;
import com.lianlianpay.global.ew.openapi.client.SimpleClient;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.authentication.OAuthReq;
import com.lianlianpay.global.ew.openapi.model.authentication.OAuthRes;

/**
 * @author huyl
 * @since 2024/12/26
 */
public class AuthenticationService {

    private final Client client;

    private final OAuthApi oAuthApi;

    public AuthenticationService(SimpleClient client) {
        this.client = client;
        this.oAuthApi = client.create(OAuthApi.class);
    }

    /**
     * <h3>OAuth2.0 Token</h3>
     * You can use the OAuth 2.0 client credentials grant specified in RFC 6749, to access web-hosted resources by using the identity of an application.
     * This type of grant is commonly used for server-to-server interactions that must run in the background, without immediate interaction with a user.
     * These types of applications are often referred to as daemons or service accounts.
     * @param req
     * @return
     */
    public Result<OAuthRes> getAccessToken(OAuthReq req) {
        return this.client.execute(this.oAuthApi.getAccessToken(req));
    }
}
