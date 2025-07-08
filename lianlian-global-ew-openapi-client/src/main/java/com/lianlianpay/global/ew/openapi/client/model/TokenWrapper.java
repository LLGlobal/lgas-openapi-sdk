package com.lianlianpay.global.ew.openapi.client.model;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/10
 */
public class TokenWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accessToken;

    private TokenWrapper(String accessToken){
        this.accessToken = accessToken;
    }

    public synchronized void set(String accessToken){
        this.accessToken = accessToken;
    }

    public String get(){
        return accessToken;
    }

    public static TokenWrapper of(String accessToken){
        return new TokenWrapper(accessToken);
    }
}
