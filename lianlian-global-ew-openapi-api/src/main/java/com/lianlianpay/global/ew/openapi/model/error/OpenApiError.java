package com.lianlianpay.global.ew.openapi.model.error;

import lombok.Data;

import java.io.Serializable;

/**
 * Open API Error
 * @author huyl
 * @since 2024/12/6
 */
@Data
public class OpenApiError implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Trace ID
     */
    private String traceId;

    /**
     * Error Code
     */
    private String code;

    /**
     * Error Message
     */
    private String message;
}
