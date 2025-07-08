package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author huyl
 * @since 2024/11/28
 */
@Data
public class ReceivingAccountDetailRes implements Serializable {

    private static final long serialVersionUID = -1L;


    /**
     * id
     * string
     * Unique ID created by the LianLian Global.
     */
    private String id;

    /**
     * nickname
     * string
     * Nickname of ReceivingAccount
     */
    private String nickname;

    /**
     * bank_info
     */
    private AccountBankInfo bankInfo;

    /**
     * funding_source
     */
    private FundingSource fundingSource;

    /**
     * additional_info
     * Structured field names and values used to define the business information.
     */
    private Map<String, String> additionalInfo;

    /**
     * file_folder_id
     * The ID of File Folder object.
     */
    private String fileFolderId;

    /**
     * status
     * Enum: "APPLYING" "VALID" "ABNORMAL"
     * Status.
     */
    private String status;

    /**
     * create_time
     * The object creation time. Measured in milliseconds since the Unix epoch.
     */
    private Date createTime;
}
