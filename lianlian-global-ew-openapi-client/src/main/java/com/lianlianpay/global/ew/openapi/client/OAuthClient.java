package com.lianlianpay.global.ew.openapi.client;

import com.lianlianpay.global.ew.openapi.client.model.ClientConfiguration;
import com.lianlianpay.global.ew.openapi.interceptor.auth.OAuth2Interceptor;
import okhttp3.Interceptor;

/**
 * @author huyl
 * @since 2024/12/10
 */
public class OAuthClient extends BaseOpenApiClient {
    protected OAuthClient(ClientConfiguration config) {
        super(config);
    }

    @Override
    protected Interceptor authInterceptor(ClientConfiguration configuration) {
        return new OAuth2Interceptor(configuration.getAccessToken());
    }

    public void setAccessToken(String accessToken) {
        this.config.setAccessToken(accessToken);
    }
}
