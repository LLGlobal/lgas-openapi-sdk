package com.lianlianpay.global.ew.openapi.model.account.payment;

import com.lianlianpay.global.ew.openapi.model.common.AdditionalInfo;
import com.lianlianpay.global.ew.openapi.model.common.BankInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/12/3
 */
@Data
public class BeneficiaryAccountDetailRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * string
     * Unique identifier for the Beneficiary.
     */
    private String id;

    /**
     * Enum: "UNDER_REVIEW" "ACCEPTED" "REJECTED"
     * Status of this Beneficiary.
     */
    private String status;

    /**
     * Type is BankAcct required
     */
    private BankInfo bankInfo;

    /**
     * The ID of File Folder object.
     */
    private String fileFolderId;

    /**
     * This field occurs.
     */
    private String failureCode;

    /**
     * This field occur.
     */
    private String failureReason;

    /**
     * Array of objects (Item)
     */
    private List<AdditionalInfo> additionalInfo;
}
