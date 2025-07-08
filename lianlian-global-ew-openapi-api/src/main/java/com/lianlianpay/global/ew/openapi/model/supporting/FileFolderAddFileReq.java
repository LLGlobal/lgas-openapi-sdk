package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/12/6
 */
@Data
public class FileFolderAddFileReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * id
     * required
     * string
     * File Folder unique identifier.
     */
    private String id;

    /**
     * file_ids
     * required
     * Array of strings
     * array of File ids
     */
    private List<String> fileIds;
}
