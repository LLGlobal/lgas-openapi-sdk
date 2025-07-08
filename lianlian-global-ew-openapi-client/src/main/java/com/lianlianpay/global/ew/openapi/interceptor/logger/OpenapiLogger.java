package com.lianlianpay.global.ew.openapi.interceptor.logger;

import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huyl
 * @since 2024/12/16
 */
public class OpenapiLogger implements HttpLoggingInterceptor.Logger{

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenapiLogger.class);

    @Override
    public void log(String message) {
        LOGGER.info(message);
    }
}
