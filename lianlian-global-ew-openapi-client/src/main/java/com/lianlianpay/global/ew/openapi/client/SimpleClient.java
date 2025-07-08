package com.lianlianpay.global.ew.openapi.client;

import com.lianlianpay.global.ew.openapi.client.model.ClientConfiguration;
import okhttp3.Interceptor;

/**
 * @author huyl
 * @since 2025/3/24
 */
public class SimpleClient extends BaseOpenApiClient{
    protected SimpleClient(ClientConfiguration config) {
        super(config);
    }

    @Override
    protected Interceptor authInterceptor(ClientConfiguration configuration) {
        return null;
    }


}
