package com.lianlianpay.global.ew.openapi.api.acceptance.finance;

import com.lianlianpay.global.ew.openapi.model.acceptance.finance.SettlementReportDetailRes;
import com.lianlianpay.global.ew.openapi.model.acceptance.finance.SettlementReportDownloadReq;
import com.lianlianpay.global.ew.openapi.model.acceptance.finance.SettlementReportPageReq;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author huyl
 * @since 2024/11/25
 */
public interface SettlementReportApi {

    /**
     * Retrieve all settlements.
     * @param req
     * @return
     */
    @POST("/gateway/v1/acquire-settlement-report")
    Single<PageResult<SettlementReportDetailRes>> retrieveAllSettlements(@Body SettlementReportPageReq req);


    /**
     * Download settlement report file by id.
     * @param req
     * @return
     */
    @POST("/gateway/v1/api/v1/reports/download/token")
    Single<ResponseBody> downloadSettlementReport(@Body SettlementReportDownloadReq req);
}
