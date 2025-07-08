package com.lianlianpay.global.ew.openapi.model.supporting;

import com.lianlianpay.global.ew.openapi.model.common.AdditionalInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/12/6
 */
@Data
public class FileFolderCreateReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * purpose
     * string
     * The purpose of the upload file.
     * payout, payee, kyc
     */
    private String purpose;

    /**
     * file_ids
     * Array of strings
     * array of File ids
     */
    private List<String> fileIds;

    /**
     * additional_info
     * Array of objects (Item)
     * For file information to be transmitted as agreed between LianLian Global and client.
     */
    private List<AdditionalInfo> additionalInfo;

    /**
     * file_folder_name
     * required
     * string
     * name of the file
     */
    private String fileFolderName;
}
