package com.lianlianpay.global.ew.openapi.client.model;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/10
 */
public class TokenWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private final ThreadLocal<String> accessTokenHolder = new ThreadLocal<>();

    private TokenWrapper(String accessToken){
        this.accessTokenHolder.set(accessToken);;
    }

    public void set(String accessToken){
        this.accessTokenHolder.set(accessToken);
    }

    public String get(){
        return this.accessTokenHolder.get();
    }

    public void clear(){
        this.accessTokenHolder.remove();
    }

    public static TokenWrapper of(String accessToken){
        return new TokenWrapper(accessToken);
    }
}
