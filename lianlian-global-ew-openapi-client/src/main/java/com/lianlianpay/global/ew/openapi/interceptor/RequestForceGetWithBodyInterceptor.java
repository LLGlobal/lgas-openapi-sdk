package com.lianlianpay.global.ew.openapi.interceptor;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import com.lianlianpay.global.ew.openapi.utils.HttpUtils;
import lombok.SneakyThrows;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author huyl
 * @since 2025/3/2
 */
public class RequestForceGetWithBodyInterceptor implements Interceptor {


    @SneakyThrows
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUtils.forceGet(request);
        return chain.proceed(request);
    }
}
