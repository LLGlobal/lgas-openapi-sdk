package com.lianlianpay.global.ew.openapi.exception;

/**
 * @author huyl
 * @since 2024/12/10
 */
public class SignatureException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public SignatureException(String message) {
        super(message);
    }

    public SignatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public SignatureException(Throwable cause) {
        super(cause);
    }



}
