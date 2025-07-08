package com.lianlianpay.global.ew.openapi.client;

import com.lianlianpay.global.ew.openapi.client.model.ClientConfiguration;
import com.lianlianpay.global.ew.openapi.interceptor.auth.BasicAuthInterceptor;
import okhttp3.Interceptor;

/**
 * @author huyl
 * @since 2024/12/10
 */
public class BasicAuthClient extends BaseOpenApiClient {
    protected BasicAuthClient(ClientConfiguration config) {
        super(config);
    }

    @Override
    protected Interceptor authInterceptor(ClientConfiguration configuration) {
        return new BasicAuthInterceptor(configuration.getDeveloperId(), configuration.getToken());
    }
}
