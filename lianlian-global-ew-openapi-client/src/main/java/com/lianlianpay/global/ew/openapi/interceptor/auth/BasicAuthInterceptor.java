package com.lianlianpay.global.ew.openapi.interceptor.auth;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Base64;

/**
 * @author huyl
 * @since 2024/12/10
 */
public class BasicAuthInterceptor implements Interceptor {


    private final String developerId;

    private final String token;

    public BasicAuthInterceptor(String developerId, String token) {
        this.developerId = developerId;
        this.token = token;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("Authorization", "Basic " + generateBasicAuthToken(this.developerId, this.token))
                .build();
        return chain.proceed(request);
    }

    /**
     * 生成 Basic Auth Token
     *
     * @param developerId 开发者ID
     * @param token       令牌
     * @return Basic Auth Token
     */
    public static String generateBasicAuthToken(String developerId, String token) {
        return Base64.getEncoder().encodeToString((String.format("%s:%s", developerId, token)).getBytes());
    }
}
