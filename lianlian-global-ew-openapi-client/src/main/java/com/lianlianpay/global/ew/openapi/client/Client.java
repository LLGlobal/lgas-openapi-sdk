package com.lianlianpay.global.ew.openapi.client;

import com.lianlianpay.global.ew.openapi.client.enums.AuthMode;
import com.lianlianpay.global.ew.openapi.client.model.ClientConfiguration;
import com.lianlianpay.global.ew.openapi.http.Result;
import io.reactivex.Single;

/**
 * @author huyl
 * @since 2024/12/9
 */
public interface Client {

    ClientConfiguration getConfiguration();

    /**
     * create the api instance
     * @param apiClazz
     * @return
     * @param <T>
     */
    <T> T create(Class<T> apiClazz);

    /**
     * execute the request and return the result
     * @param single
     * @return
     * @param <T>
     */
    <T> Result<T> execute(Single<T> single);
}
