package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2025/2/7
 */
@Data
public class TransactionDocumentQuotaQueryReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * merchant_client_id
     * required
     * string
     * Merchant ID as known by the client platform.
     */
    private String merchantClientId;

    /**
     * transaction_document_batch_id
     * string
     * Transaction document batch id.
     */
    private List<String> transactionDocumentBatchIds;

    /**
     * currency
     * required
     * string
     * Currency of this request.
     */
    private String currency;

    /**
     * original_order_type
     * required
     * string
     * Order type.
     *
     * GOODS / SERVICES
     */
    private String originalOrderType;

}
