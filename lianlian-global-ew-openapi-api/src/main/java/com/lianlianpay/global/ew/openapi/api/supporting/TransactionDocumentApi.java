package com.lianlianpay.global.ew.openapi.api.supporting;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.model.supporting.*;
import io.reactivex.Single;
import retrofit2.http.*;

/**
 * @author huyl
 * @since 2025/2/7
 */
public interface TransactionDocumentApi {

    /**
     * <h3>Create transaction document</h3>
     * Create a transaction document.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-document/transaction/document")
    Single<TransactionDocumentCreateRes> createTransactionDocument(@Body TransactionDocumentCreateReq req);


    /**
     * <h3>Update transaction document</h3>
     * Update a transaction document.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-document/transaction/document/update")
    Single<TransactionDocumentUpdateRes> updateTransactionDocument(@Body TransactionDocumentUpdateReq req);


    /**
     * <h3>Retrieve transaction document</h3>
     * Retrieve a transaction document.
     * @param requestId
     * @return
     */
    @GET("/gateway/v1/ew-document/transaction/document/{request_id}")
    Single<TransactionDocumentDetailRes> retrieveTransactionDocument(@Path("request_id") String requestId);

    /**
     * <h3>Retrieve all transaction documents</h3>
     * Retrieve all transaction documents.
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path = "/gateway/v1/ew-document/transaction/document/list", hasBody = true)
    Single<PageResult<TransactionDocumentDetailRes>> retrieveAllTransactionDocuments(@Body TransactionDocumentPageReq req);

    /**
     * <h3>Get quota</h3>
     * Get quota by ID.
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path = "/gateway/v1/ew-document/quota", hasBody = true)
    Single<TransactionDocumentQuotaRes> getTransactionDocumentQuota(@Body TransactionDocumentQuotaQueryReq req);
}
