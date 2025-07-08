package com.lianlianpay.global.ew.openapi.http;

import com.lianlianpay.global.ew.openapi.model.error.OpenApiError;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author huyl
 * @since 2024/12/9
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * http status code
     */
    private int httpStatus;

    /**
     * http response body when request success
     */
    private T data;

    /**
     * openapi error when request failed
     */
    private OpenApiError error;


    private Result(int httpStatus, T data, OpenApiError error) {
        this.httpStatus = httpStatus;
        this.data = data;
        this.error = error;
    }

    /**
     * http status equals 200
     */
    public boolean isHttpOk() {
        return isHttpStatus(200);
    }

    /**
     * http status not equals 200
     * @return
     */
    public boolean isHttpError() {
        return !isHttpOk();
    }

    /**
     * http status equals 400
     */
    public boolean isBadRequest() {
        return isHttpStatus(400);
    }

    /**
     * http status equals 401
     * @return
     */
    public boolean isUnauthorized() {
        return isHttpStatus(401);
    }

    /**
     * http status equals 403
     * @return
     */
    public boolean isForbidden() {
        return isHttpStatus(403);
    }

    /**
     * http status equals 404
     * @return
     */
    public boolean isNotFound() {
        return isHttpStatus(404);
    }

    /**
     * http status equals 500
     * @return
     */
    public boolean isServerError() {
        return httpStatus >= 500;
    }


    /**
     * http status equals status
     * @param status
     * @return
     */
    private boolean isHttpStatus(int status) {
        return httpStatus == status;
    }

    /**
     * compose http ok
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok(T data) {
        return of(200, data, null);
    }

    /**
     * compose http error
     * @param httpStatus
     * @param error
     * @return
     * @param <T>
     */
    public static <T> Result<T> error(int httpStatus, OpenApiError error) {
        return of(httpStatus, null, error);
    }

    /**
     * compose http status and data
     * @param httpStatus
     * @param data
     * @param error
     * @return
     * @param <T>
     */
    public static <T> Result<T> of(int httpStatus, T data, OpenApiError error) {
        return new Result<>(httpStatus, data, error);
    }
}
