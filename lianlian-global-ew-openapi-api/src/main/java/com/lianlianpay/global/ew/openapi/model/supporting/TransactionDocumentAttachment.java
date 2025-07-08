package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/4/29
 */
@Data
public class TransactionDocumentAttachment implements Serializable {


    private static final long serialVersionUID = -1L;

    /**
     * file_flag
     * string
     * Enum: "COMMERCIAL_DOCUMENTS" "LOGISTICS_DOCUMENTS" "LOGISTICS_COMMUNICATION_DOCUMENTS" "CONTRACT_DOCUMENTS" "ORDER_DOCUMENTS" "CUSTOMS_DECLARATION" "OTHER_ATTACH"
     * The flag of attachment
     * Required if business_type = "GOODS_TRADE"
     */
    private String attachmentType;

    /**
     * file_id
     * string
     * The unique identifier of the file object.
     */
    private String fileId;
}
