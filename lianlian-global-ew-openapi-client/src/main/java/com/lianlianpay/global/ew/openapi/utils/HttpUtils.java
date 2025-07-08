package com.lianlianpay.global.ew.openapi.utils;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import lombok.SneakyThrows;
import okhttp3.Request;
import okhttp3.internal.http.HttpMethod;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author huyl
 * @since 2025/3/2
 */
public class HttpUtils {

    @SneakyThrows
    public static void forceGet(Request request) {
        if (Objects.equals(request.method(), SpecialMethod.FORCE_GET_WITH_BODY)) {
            Field method = Request.class.getDeclaredField("method");
            method.setAccessible(true);
            method.set(request, "GET");
            method.setAccessible(false);
        }
    }

    @SneakyThrows
    public static void byPassBodyPermits(Request request) {
        if (!HttpMethod.permitsRequestBody(request.method()) && request.body() != null) {
            Field method = Request.class.getDeclaredField("method");
            method.setAccessible(true);
            method.set(request, SpecialMethod.FORCE_GET_WITH_BODY);
            method.setAccessible(false);
        }
    }
}
