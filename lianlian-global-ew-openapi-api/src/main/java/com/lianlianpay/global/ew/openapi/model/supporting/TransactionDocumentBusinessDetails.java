package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Business details
 * @author huyl
 * @since 2025/4/29
 */
@Data
public class TransactionDocumentBusinessDetails implements Serializable {

    /**
     * website
     * string
     * Product website
     * Required if business_type=GOODS_TRADE.
     */
    private String website;

    /**
     * Product information
     */
    private List<TransactionDocumentProduct> productInfo;

    /**
     * Logistics information
     */
    private TransactionDocumentLogistics  logisticsInfo;

    /**
     * attachments
     * Array of objects (Attachment)
     * Attachments
     */
    private List<TransactionDocumentAttachment> attachments;

}
