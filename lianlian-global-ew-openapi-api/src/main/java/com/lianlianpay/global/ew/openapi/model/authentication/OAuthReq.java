package com.lianlianpay.global.ew.openapi.model.authentication;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/26
 */
@Data
public class OAuthReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * grant_type
     * required
     * string
     * Enum: "authorization_code" "refresh_token"
     * Type of grant.
     */
    private String grantType;

    /**
     * client_id
     * required
     * string
     * APP client ID.
     */
    private String clientId;

    /**
     * client_secret
     * required
     * string
     * Client APP secret key.
     */
    private String clientSecret;

    /**
     * code
     * string
     * Mandatory if grant_type = authorization_code.
     * The authorization_code that Successful response of after user authed.
     */
    private String code;

    /**
     * redirect_uri
     * string
     * Mandatory if grant_type = authorization_code.
     * The redirect URI where you want the response to be sent for your app to handle. It must exactly match one of the redirect URIs that you registered in the portal, except that it must be URL-encoded, and it can have additional path segments.
     */
    private String redirectUri;

    /**
     * refresh_token
     * string
     * Mandatory if grant_type = refresh_token.
     * An OAuth 2.0 refresh token. The app can use this token to acquire other access tokens after the current access token expires. In order to prevent client APP miss the response result, LL Platform will maintain the idempotent successful request for 15 minutes.
     */
    private String refreshToken;
}
