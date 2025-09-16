package com.lianlianpay.global.ew.openapi.client;

import com.lianlianpay.global.ew.openapi.client.enums.AuthMode;
import com.lianlianpay.global.ew.openapi.client.model.ClientConfiguration;
import com.lianlianpay.global.ew.openapi.client.model.TokenWrapper;

import java.net.Proxy;
import java.time.Duration;
import java.util.Objects;

/**
 * @author huyl
 * @since 2024/12/10
 */
public class ClientBuilder {

    private static final Duration DEFAULT_CONNECT_TIMEOUT = Duration.ofSeconds(10);

    private static final Duration DEFAULT_READ_TIMEOUT = Duration.ofSeconds(30);

    private static final boolean DEFAULT_WITH_SIGN = true;

    private static final boolean DEFAULT_CHECK_SIGN = true;

    private static final boolean DEFAULT_CHECK_SIGN_STRICT = false;


    public static OAuthClient defaultOAuthClient(String endpoint, String privateKey, String lianlianPublicKey) {
        return defaultOAuthClient(endpoint, privateKey, lianlianPublicKey, null);
    }

    public static OAuthClient defaultOAuthClient(String endpoint, String privateKey, String lianlianPublicKey, String accessToken) {
        return newOAuthClientBuilder()
                .endpoint(endpoint)
                .privateKey(privateKey)
                .lianlianPublicKey(lianlianPublicKey)
                .accessToken(accessToken)
                .build();
    }

    public static BasicAuthClient defaultBasicAuthClient(String endpoint, String privateKey, String lianlianPublicKey, String token, String developerId) {
        return newBasicAuthClientBuilder()
                .endpoint(endpoint)
                .privateKey(privateKey)
                .lianlianPublicKey(lianlianPublicKey)
                .token(token)
                .developerId(developerId)
                .build();
    }


    public static SimpleClient defaulSimpleClient(String endpoint) {
        return newSimpleClientBuilder()
                .endpoint(endpoint)
                .build();
    }

    public static BasicAuthClientBuilder newBasicAuthClientBuilder() {
        return new BasicAuthClientBuilder();
    }

    public static OAuthClientBuilder newOAuthClientBuilder() {
        return new OAuthClientBuilder();
    }

    public static SimpleClientBuilder newSimpleClientBuilder() {
        return new SimpleClientBuilder();
    }


    public static class SimpleClientBuilder {
        private String endpoint;

        private Duration connectTimeout;

        private Duration readTimeout;

        private Proxy proxy;

        private SimpleClientBuilder() {

        }

        public SimpleClientBuilder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public SimpleClientBuilder connectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public SimpleClientBuilder readTimeout(Duration readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public SimpleClientBuilder proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public SimpleClient build() {
            ClientConfiguration configuration = ClientConfiguration.builder()
                    .endpoint(endpoint)
                    .authMode(AuthMode.NONE)
                    .checkSign(false)
                    .withSign(false)
                    .connectTimeout(Objects.nonNull(connectTimeout) ? connectTimeout : DEFAULT_CONNECT_TIMEOUT)
                    .readTimeout(Objects.nonNull(readTimeout) ? readTimeout : DEFAULT_READ_TIMEOUT)
                    .proxy(proxy)
                    .build();
            return new SimpleClient(configuration);
        }
    }


    public static class OAuthClientBuilder {

        private String endpoint;

        private String privateKey;

        private String lianlianPublicKey;

        private TokenWrapper accessToken;

        private Duration connectTimeout;

        private Duration readTimeout;

        private Boolean withSign;

        private Boolean checkSign;

        private Boolean checkSignStrict;

        private Proxy proxy;

        private OAuthClientBuilder(){

        }

        public OAuthClientBuilder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public OAuthClientBuilder privateKey(String privateKey) {
            this.privateKey = privateKey;
            return this;
        }

        public OAuthClientBuilder lianlianPublicKey(String lianlianPublicKey) {
            this.lianlianPublicKey = lianlianPublicKey;
            return this;
        }

        public OAuthClientBuilder accessToken(String accessToken) {
            this.accessToken = TokenWrapper.of(accessToken);
            return this;
        }

        public OAuthClientBuilder connectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public OAuthClientBuilder readTimeout(Duration readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public OAuthClientBuilder withSign(Boolean withSign) {
            this.withSign = withSign;
            return this;
        }

        public OAuthClientBuilder checkSign(Boolean checkSign) {
            this.checkSign = checkSign;
            return this;
        }

        public OAuthClientBuilder checkSignStrict(Boolean checkSignStrict) {
            this.checkSignStrict = checkSignStrict;
            return this;
        }

        public OAuthClientBuilder proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public OAuthClient build() {
            ClientConfiguration configuration = ClientConfiguration.builder().
                    endpoint(this.endpoint)
                    .authMode(AuthMode.OAUTH)
                    .privateKey(this.privateKey)
                    .lianlianPublicKey(this.lianlianPublicKey)
                    .accessToken(this.accessToken)
                    .connectTimeout(this.connectTimeout == null ? DEFAULT_CONNECT_TIMEOUT : this.connectTimeout)
                    .readTimeout(this.readTimeout == null ? DEFAULT_READ_TIMEOUT : this.readTimeout)
                    .withSign(this.withSign == null ? DEFAULT_WITH_SIGN : this.withSign)
                    .checkSign(this.checkSign == null ? DEFAULT_CHECK_SIGN : this.checkSign)
                    .checkSignStrict(this.checkSignStrict == null ? DEFAULT_CHECK_SIGN_STRICT : this.checkSignStrict)
                    .proxy(this.proxy)
                    .build();
            return new OAuthClient(configuration);
        }

    }

    public static class BasicAuthClientBuilder {

        private String endpoint;

        private String privateKey;

        private String lianlianPublicKey;

        private String token;

        private String developerId;

        private Duration connectTimeout;

        private Duration readTimeout;

        private Boolean withSign;

        private Boolean checkSign;

        private Boolean checkSignStrict;

        private Proxy proxy;

        private BasicAuthClientBuilder(){

        }

        public BasicAuthClientBuilder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public BasicAuthClientBuilder privateKey(String privateKey) {
            this.privateKey = privateKey;
            return this;
        }

        public BasicAuthClientBuilder lianlianPublicKey(String lianlianPublicKey) {
            this.lianlianPublicKey = lianlianPublicKey;
            return this;
        }

        public BasicAuthClientBuilder token(String token) {
            this.token = token;
            return this;
        }

        public BasicAuthClientBuilder developerId(String developerId) {
            this.developerId = developerId;
            return this;
        }

        public BasicAuthClientBuilder connectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public BasicAuthClientBuilder readTimeout(Duration readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public BasicAuthClientBuilder withSign(Boolean withSign) {
            this.withSign = withSign;
            return this;
        }

        public BasicAuthClientBuilder checkSign(Boolean checkSign) {
            this.checkSign = checkSign;
            return this;
        }

        public BasicAuthClientBuilder checkSignStrict(Boolean checkSignStrict) {
            this.checkSignStrict = checkSignStrict;
            return this;
        }

        public BasicAuthClientBuilder proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public BasicAuthClient build() {
            ClientConfiguration configuration = ClientConfiguration.builder().
                    endpoint(this.endpoint)
                    .authMode(AuthMode.BASIC)
                    .privateKey(this.privateKey)
                    .lianlianPublicKey(this.lianlianPublicKey)
                    .token(this.token)
                    .developerId(this.developerId)
                    .connectTimeout(this.connectTimeout == null ? DEFAULT_CONNECT_TIMEOUT : this.connectTimeout)
                    .readTimeout(this.readTimeout == null ? DEFAULT_READ_TIMEOUT : this.readTimeout)
                    .withSign(this.withSign == null ? DEFAULT_WITH_SIGN : this.withSign)
                    .checkSign(this.checkSign == null ? DEFAULT_CHECK_SIGN : this.checkSign)
                    .checkSignStrict(this.checkSignStrict == null ? DEFAULT_CHECK_SIGN_STRICT : this.checkSignStrict)
                    .proxy(this.proxy)
                    .build();
            return new BasicAuthClient(configuration);
        }

    }
}
