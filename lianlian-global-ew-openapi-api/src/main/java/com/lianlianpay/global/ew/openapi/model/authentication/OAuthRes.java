package com.lianlianpay.global.ew.openapi.model.authentication;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/26
 */
@Data
public class OAuthRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The requested access token. The app can use this token to authenticate to the secured resource, such as a web API.
     */
    private String accessToken;

    /**
     * An OAuth 2.0 refresh token. The app can use this token to acquire other access tokens after the current access token expires.
     */
    private String refreshToken;

    /**
     * The amount of time that an access token is valid (in seconds).
     */
    private Integer expiresIn;
}
