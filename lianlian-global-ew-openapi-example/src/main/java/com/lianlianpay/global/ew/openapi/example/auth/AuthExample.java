package com.lianlianpay.global.ew.openapi.example.auth;

import com.lianlianpay.global.ew.openapi.client.BasicAuthClient;
import com.lianlianpay.global.ew.openapi.client.ClientBuilder;
import com.lianlianpay.global.ew.openapi.client.SimpleClient;
import com.lianlianpay.global.ew.openapi.client.OAuthClient;
import com.lianlianpay.global.ew.openapi.example.config.AuthConfig;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.authentication.OAuthReq;
import com.lianlianpay.global.ew.openapi.model.authentication.OAuthRes;
import com.lianlianpay.global.ew.openapi.service.AuthenticationService;

/**
 * @author huyl
 * @since 2024/12/18
 */
public class AuthExample {


    private final AuthenticationService authenticationService;

    public AuthExample() {
        SimpleClient client = ClientBuilder.defaulSimpleClient(AuthConfig.ENDPOINT);
        this.authenticationService = new AuthenticationService(client);
    }

    /**
     * Basic Auth Client
     * @return
     */
    public BasicAuthClient basicAuthClient() {
        return ClientBuilder.defaultBasicAuthClient(
                AuthConfig.ENDPOINT, AuthConfig.PRIVATE_KEY,
                AuthConfig.LIANLIAN_PUBLIC_KEY, AuthConfig.TOKEN,
                AuthConfig.DEVELOPER_ID);
    }


    /**
     * OAuth2 Client
     * @param accessToken
     * @return
     */
    public OAuthClient oAuthClient(String accessToken) {
        return ClientBuilder.defaultOAuthClient(
                AuthConfig.ENDPOINT, AuthConfig.PRIVATE_KEY,
                AuthConfig.LIANLIAN_PUBLIC_KEY,
                // using TokenWrapper to wrap access token
                accessToken
        );
    }

    /**
     * Set new access token
     * if the old access token is expired, you can set new access token like this
     * @param newAccessToken
     * @return
     */
    public OAuthClient newAccessToken(String newAccessToken) {
        OAuthClient client = this.oAuthClient("old access token");
        client.setAccessToken(newAccessToken);
        return client;
    }

    /**
     * Get access token
     */
    public void getAccessToken() {
        OAuthReq req = new OAuthReq();
        req.setGrantType("authorization_code");
        req.setClientId("[Your App Client Id]");
        req.setClientSecret("[Your App Client Secret]");
        req.setCode("[Authorization Code]");
        req.setRedirectUri("[Your App Redirect URI]");
        Result<OAuthRes> result = authenticationService.getAccessToken(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Refresh access token
     */
    public void refreshToken() {
        OAuthReq req = new OAuthReq();
        req.setGrantType("refresh_token");
        req.setClientId("[Your App Client Id]");
        req.setClientSecret("[Your App Client Secret]");
        req.setRefreshToken("[Refresh Token]");
        Result<OAuthRes> result = authenticationService.getAccessToken(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
