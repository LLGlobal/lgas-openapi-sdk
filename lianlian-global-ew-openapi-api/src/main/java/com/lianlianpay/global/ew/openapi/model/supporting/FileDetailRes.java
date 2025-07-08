package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class FileDetailRes implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier of the File object.
     */
    private String id;

    /**
     * The upload file name.
     */
    private String fileName;

    /**
     * The original file that named by user when uploading.
     */
    private String title;

    /**
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date createTime;

    /**
     * The notes of the File, max length is 128 characters.
     */
    private String notes;
}
