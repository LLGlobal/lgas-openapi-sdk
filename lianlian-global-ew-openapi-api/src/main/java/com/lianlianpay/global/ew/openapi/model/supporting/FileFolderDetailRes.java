package com.lianlianpay.global.ew.openapi.model.supporting;

import com.lianlianpay.global.ew.openapi.model.common.AdditionalInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author huyl
 * @since 2024/12/6
 */
@Data
public class FileFolderDetailRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * string
     * File Folder unique identifier.
     */
    private String id;

    /**
     * purpose
     * string
     * The purpose of the upload file.
     */
    private String purpose;

    /**
     * files
     * Array of objects (File)
     * List of File info, Maximum 255 files
     */
    private List<FileDetailRes> files;

    /**
     * additional_info
     * Array of objects (Item)
     * For File Folder information to be transmitted as agreed between LianLian Global and client.
     */
    private List<AdditionalInfo> additionalInfo;

    /**
     * create_time
     * integer
     * The object creation time. Measured in milliseconds since the Unix epoch.
     */
    private Date createTime;

    /**
     * file_folder_name
     * string
     * Name of File Folder.
     */
    private String fileFolderName;
}
