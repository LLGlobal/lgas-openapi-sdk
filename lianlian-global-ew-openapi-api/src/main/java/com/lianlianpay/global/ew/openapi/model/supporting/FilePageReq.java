package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class FilePageReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 	File ID.
     */
    private String id;

    /**
     * A file name in the server, require exact match.
     */
    private String name;

    /**
     * User naming the file when uploading, require exact match
     */
    private String title;

    /**
     * The query page number.
     */
    private Integer page;

    /**
     * A maximum of 100 data items can be displayed on a page.
     */
    private Integer pageSize;

    /**
     * File object creation period start time.
     */
    private Date startTime;

    /**
     * File object creation period end time.
     */
    private Date endTime;
}
