package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/8/5
 */
@Data
public class RelationTransactionDocument implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * Trade document ID
     */
    private String transactionDocumentId;

    /**
     * Related Amount of the trade material
     */
    private String relationAmount;

    /**
     * Currency of trade (in three-letter ISO 4217 format).
     */
    private String relationCurrency;
}
