package com.lianlianpay.global.ew.openapi.example.acceptance.finance;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.acceptance.finance.SettlementReportDetailRes;
import com.lianlianpay.global.ew.openapi.model.acceptance.finance.SettlementReportDownloadReq;
import com.lianlianpay.global.ew.openapi.model.acceptance.finance.SettlementReportPageReq;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.service.AcceptanceService;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author huyl
 * @since 2024/12/30
 */
public class SettlementReportExample extends AuthExample {

    private final AcceptanceService acceptanceService;

    public SettlementReportExample() {
        this.acceptanceService = new AcceptanceService(this.basicAuthClient());
    }


    /**
     * Retrieve all settlements.
     * @return
     */
    public void retrieveAllSettlements() {
        SettlementReportPageReq req = new SettlementReportPageReq();
        req.setPage(1);
        req.setPageSize(10);
        Result<PageResult<SettlementReportDetailRes>> result = this.acceptanceService.retrieveAllSettlements(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }

    }


    /**
     * Download settlement report file by id.
     * @return
     */
    public void downloadSettlementReport() {
        SettlementReportDownloadReq req = new SettlementReportDownloadReq();
        req.setId("report id");
        Result<ResponseBody> result = this.acceptanceService.downloadSettlementReport(req);
        if (result.isHttpOk()) {
            // do something when success
            ResponseBody responseBody = result.getData();
            MediaType mediaType = responseBody.contentType();
            System.out.println(mediaType.type()+"/"+mediaType.subtype());
            System.out.println(responseBody.contentLength());
            try {
                try (FileOutputStream fos = new FileOutputStream("{your-file-root-path}/settlement-report.txt")) {
                    fos.write(responseBody.bytes());
                    fos.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
