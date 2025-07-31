package com.lianlianpay.global.ew.openapi.example.supporting;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.model.supporting.*;
import com.lianlianpay.global.ew.openapi.service.SupportingService;

import java.util.Arrays;
import java.util.Date;

/**
 * @author huyl
 * @since 2025/2/7
 */
public class TransactionDocumentExample extends AuthExample {

    private final SupportingService supportingService;

    public TransactionDocumentExample() {
        super();
        this.supportingService = new SupportingService(this.basicAuthClient());
    }

    /**
     * Example:
     * Create Transaction Document
     */
    public void createTransactionDocument() {
        TransactionDocumentCreateReq req = new TransactionDocumentCreateReq();
        req.setRequestId("20250207135000001");
        req.setBusinessType("GOODS_TRADE");
        req.setOriginalOrderType("GOODS");
        req.setTradeTime(new Date());
        req.setTradeCurrency("USD");
        req.setTradeAmount("100");
        req.setMerchantClientId("[Your Merchant Client Id]");
        req.setPurpose("PAYOUT");
        req.setOwnerId("[Your Owner ID]");
        req.setOwnerType("PAYER");
        req.setTemplate("REGULAR");

        TransactionDocumentCounterparty counterparty = new TransactionDocumentCounterparty();
        counterparty.setName("[Counterparty Name]");
        counterparty.setCountryCode("US");
        req.setCounterpartyDetails(counterparty);


        TransactionDocumentBusinessDetails business = new TransactionDocumentBusinessDetails();

        business.setWebsite("");
        TransactionDocumentProduct product = new TransactionDocumentProduct();
        product.setProductName("[Product Name]");
        product.setUnit("PCS");
        product.setQuantity("100");
        product.setServiceDetail("");
        product.setServiceTime("2025-04-29");
        business.setProductInfo(Arrays.asList(product));
        TransactionDocumentLogistics logistics = new TransactionDocumentLogistics();
        logistics.setLogisticsCompany("DHL");
        logistics.setLogisticsOrderNo("123456789");
        logistics.setShippingType("ROAD_TRANSPORT");
        logistics.setDeliveryMode("CFR");
        logistics.setDestination("US");
        logistics.setDelivered(true);
        logistics.setDeliveryDate(new Date());
        business.setLogisticsInfo(logistics);
        req.setBusinessDetails(business);

        req.setMemo("memo");
        Result<TransactionDocumentCreateRes> result = supportingService.createTransactionDocument(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * Example:
     * Update Transaction Document
     */
    public void updateTransactionDocument() {
        TransactionDocumentUpdateReq req = new TransactionDocumentUpdateReq();
        req.setRequestId("20250207135000001");
        req.setBusinessType("GOODS_TRADE");
        req.setTradeTime(new Date());
        req.setTradeCurrency("USD");
        req.setTradeAmount("100");
        req.setMerchantClientId("[Your Merchant Client Id]");
        req.setOwnerId("[Your Owner ID]");
        req.setOwnerType("PAYER");
        req.setTransactionDocumentId("[Your Transaction Document Id]");
        req.setTemplate("REGULAR");

        TransactionDocumentCounterparty counterparty = new TransactionDocumentCounterparty();
        counterparty.setName("[Counterparty Name]");
        counterparty.setCountryCode("US");
        req.setCounterpartyDetails(counterparty);


        TransactionDocumentBusinessDetails business = new TransactionDocumentBusinessDetails();
        business.setWebsite("");

        TransactionDocumentProduct product = new TransactionDocumentProduct();
        product.setProductName("[Product Name]");
        product.setUnit("PCS");
        product.setQuantity("100");
        product.setServiceDetail("");
        product.setServiceTime("2025-04-29");
        business.setProductInfo(Arrays.asList(product));
        TransactionDocumentLogistics logistics = new TransactionDocumentLogistics();
        logistics.setLogisticsCompany("DHL");
        logistics.setLogisticsOrderNo("123456789");
        logistics.setShippingType("ROAD_TRANSPORT");
        logistics.setDeliveryMode("CFR");
        logistics.setDestination("US");
        logistics.setDelivered(true);
        logistics.setDeliveryDate(new Date());
        business.setLogisticsInfo(logistics);
        req.setBusinessDetails(business);

        req.setMemo("memo");

        Result<TransactionDocumentUpdateRes> result = supportingService.updateTransactionDocument(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * Example:
     * Retrieve Transaction Document
     */
    public void retrieveTransactionDocument() {
        Result<TransactionDocumentDetailRes> result = supportingService.retrieveTransactionDocument("[Your Request Id]");
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * Example:
     * Retrieve All Transaction Documents
     */
    public void retrieveAllTransactionDocuments() {
        TransactionDocumentPageReq req = new TransactionDocumentPageReq();
        req.setPage(1);
        req.setPageSize(10);
        req.setStartTime(new Date());
        req.setEndTime(new Date());
        req.setOwnerId("[Your Owner Id]");
        req.setOwnerType("PAYER");
        req.setPurpose("PAYOUT");
        req.setStatus("SUCCESS");
        Result<PageResult<TransactionDocumentDetailRes>> result = supportingService.retrieveAllTransactionDocuments(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * Example:
     * Get Transaction Document Quota
     */
    public void getTransactionDocumentQuota() {
        TransactionDocumentQuotaQueryReq req = new TransactionDocumentQuotaQueryReq();
        req.setMerchantClientId("[Your Merchant Client Id]");
        req.setTransactionDocumentBatchIds(Arrays.asList("[Your Transaction Document Batch Id]"));
        req.setCurrency("USD");
        req.setOriginalOrderType("GOODS");
        Result<TransactionDocumentQuotaRes> result = supportingService.getTransactionDocumentQuota(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }
}
