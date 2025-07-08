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
public class TransactionDocumentBusiness implements Serializable {

    /**
     * Product information
     */
    private List<TransactionDocumentProduct> productInfo;

    /**
     * Logistics information
     */
    private TransactionDocumentLogistics  logisticsInfo;

}
