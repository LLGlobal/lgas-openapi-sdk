package com.lianlianpay.global.ew.openapi.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.lianlianpay.global.ew.openapi.client.enums.AuthMode;
import com.lianlianpay.global.ew.openapi.client.model.ClientConfiguration;
import com.lianlianpay.global.ew.openapi.deserializer.LocalDateSecondsDeserializer;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.interceptor.RequestForceGetWithBodyInterceptor;
import com.lianlianpay.global.ew.openapi.interceptor.RequestSignatureInterceptor;
import com.lianlianpay.global.ew.openapi.interceptor.ResponseSignatureInterceptor;
import com.lianlianpay.global.ew.openapi.interceptor.logger.OpenapiLogger;
import com.lianlianpay.global.ew.openapi.listener.RequestForceGetWithBodyListener;
import com.lianlianpay.global.ew.openapi.model.error.OpenApiError;
import com.lianlianpay.global.ew.openapi.serializer.LocalDateSecondsSerializer;
import io.reactivex.Single;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author huyl
 * @since 2024/12/9
 */
public abstract class BaseOpenApiClient implements Client{


    private final ObjectMapper mapper;

    private final OkHttpClient client;

    protected ClientConfiguration config;



    protected BaseOpenApiClient(ClientConfiguration config) {
        this.config = config;
        mapper = defaultObjectMapper();
        client = defaultClient();
    }

    @Override
    public ClientConfiguration getConfiguration() {
        return this.config;
    }

    /**
     * create the api instance
     *
     * @param apiClazz
     * @return
     */
    @Override
    public <T> T create(Class<T> apiClazz) {
        Retrofit retrofit = defaultRetrofit();
        return retrofit.create(apiClazz);
    }




    /**
     * execute the request and return the result
     *
     * @param apiCall
     * @return
     */
    @Override
    public <T> Result<T> execute(Single<T> apiCall) {
        try {
            return Result.ok(apiCall.blockingGet());
        } catch (HttpException e) {
            try {
                if (e.response() == null || e.response().errorBody() == null) {
                    throw e;
                }
                String errorBody = e.response().errorBody().string();

                OpenApiError error = mapper.readValue(errorBody, OpenApiError.class);
                return Result.error(e.code(), error);
            } catch (IOException ex) {
                // couldn't parse OpenAPI error
                throw e;
            }
        }
    }

    protected abstract Interceptor authInterceptor(ClientConfiguration configuration);


    protected HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new OpenapiLogger());
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    private static ObjectMapper defaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new LocalDateSecondsDeserializer());
        module.addSerializer(LocalDate.class, new LocalDateSecondsSerializer());
        mapper.registerModule(module);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return mapper;
    }

    private OkHttpClient defaultClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS))
                .connectTimeout(config.getConnectTimeout())
                .readTimeout(config.getReadTimeout())
                .proxy(config.getProxy());
        builder.addInterceptor(new RequestForceGetWithBodyInterceptor());
        builder.eventListener(new RequestForceGetWithBodyListener());


        // auth interceptor
        Interceptor authInterceptor = authInterceptor(config);
        if (Objects.nonNull(authInterceptor)) {
            builder.addInterceptor(authInterceptor);
        }
        if (config.isWithSign()) {
            builder.addInterceptor(new RequestSignatureInterceptor(config.getPrivateKey()));
        }
        if (config.isCheckSign()) {
            builder.addInterceptor(new ResponseSignatureInterceptor(config.getLianlianPublicKey(), config.isCheckSignStrict()));
        }
        // logging  interceptor
        HttpLoggingInterceptor loggingInterceptor = loggingInterceptor();
        if (Objects.nonNull(loggingInterceptor)) {
            builder.addInterceptor(loggingInterceptor);
        }
        return builder.build();
    }


    private Retrofit defaultRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(config.getEndpoint())
                .client(this.client)
                .addConverterFactory(JacksonConverterFactory.create(this.mapper))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
