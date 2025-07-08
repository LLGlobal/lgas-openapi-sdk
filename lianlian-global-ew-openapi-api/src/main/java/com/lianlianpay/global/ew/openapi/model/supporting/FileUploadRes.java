package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class FileUploadRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier of the File object.
     */
    private String id;
}
