package com.lianlianpay.global.ew.openapi.exception;

/**
 * @Description:
 * @author: imart·deng
 * @date: 2020/6/30 14:36
 */
public class CipherException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CipherException() {
        super();
    }

    public CipherException(String message) {
        super(message);
    }

    public CipherException(String message, Throwable cause) {
        super(message, cause);
    }

    public CipherException(Throwable cause) {
        super(cause);
    }
}