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
public class BeneficiaryAccountCreateReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * bank_info
     * object (Bank)
     * Type is BankAcct required
     */
    private BankInfo bankInfo;

    /**
     * file_folder_id
     * string
     * The ID of File Folder object.
     */
    private String fileFolderId;

    /**
     * additional_info
     * Array of objects (Item)
     */
    private List<AdditionalInfo> additionalInfo;
}
