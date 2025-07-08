package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/2/7
 */
@Data
public class TransactionDocumentQuotaRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * merchant_client_id
     * string
     * Merchant ID as known by the client platform.
     */
    private String merchantClientId;

    /**
     * transaction_document_batch_id
     * string
     * Transaction document batch id.
     */
    private String transactionDocumentBatchId;

    /**
     * amount
     * string
     * Upper amount, main currency unit, rounded up to 2 decimal places.
     */
    private String amount;

    /**
     * currency
     * string
     * Currency of trade (in three-letter ISO 4217 format).
     */
    private String currency;
}
