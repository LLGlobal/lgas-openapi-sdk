package com.lianlianpay.global.ew.openapi.interceptor.auth;

import com.lianlianpay.global.ew.openapi.client.model.TokenWrapper;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author huyl
 * @since 2024/12/10
 */
public class OAuth2Interceptor implements Interceptor {

    private final TokenWrapper tokenWrapper;

    public OAuth2Interceptor(TokenWrapper tokenWrapper) {
        this.tokenWrapper = tokenWrapper;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        if (this.tokenWrapper == null || this.tokenWrapper.get() == null || this.tokenWrapper.get().isEmpty()) {
            throw new IllegalArgumentException("the accessToken is blank");
        }
        Request request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + this.tokenWrapper.get())
                .build();
        try {
            return chain.proceed(request);
        } finally {
            // clear AccessToken when response
            this.tokenWrapper.clear();
        }
    }
}
