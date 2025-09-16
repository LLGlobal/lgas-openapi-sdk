package com.lianlianpay.global.ew.openapi.client.model;

import com.lianlianpay.global.ew.openapi.client.enums.AuthMode;
import lombok.Builder;
import lombok.Data;

import java.net.Proxy;
import java.time.Duration;

/**
 * @author huyl
 * @since 2024/12/10
 */
@Builder
@Data
public class ClientConfiguration {

    private final String endpoint;

    private final String privateKey;

    private final String lianlianPublicKey;

    private final AuthMode authMode;

    private final String token;

    private final String developerId;

    private final TokenWrapper accessToken;

    private final Duration connectTimeout;

    private final Duration readTimeout;

    private final boolean withSign;

    private final boolean checkSign;

    private final boolean checkSignStrict;

    private final Proxy proxy;

    public void setAccessToken(String newAccessToken) {
        if (AuthMode.OAUTH != this.authMode) {
            throw new IllegalArgumentException("AccessToken only supported by OAuth mode");
        }
       this.accessToken.set(newAccessToken);
    }

    public void clearAccessToken() {
        if (AuthMode.OAUTH != this.authMode) {
            throw new IllegalArgumentException("Method: clearAccessToken only supported by OAuth mode");
        }
        this.accessToken.clear();
    }
}
