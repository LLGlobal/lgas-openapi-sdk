package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/6
 */
@Data
public class FileFolderPageReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * file_folder_name
     * string
     * A file folder name in the server, require exact match.
     */
    private String fileFolderName;

    /**
     * page
     * integer
     * The query page number.
     */
    private Integer page;

    /**
     * page_size
     * integer
     * A maximum of 100 data items can be displayed on a page.
     */
    private Integer pageSize;

    /**
     * start_time
     * integer
     * File object creation period start time.
     */
    private Date startTime;

    /**
     * end_time
     * integer
     * File object creation period end time.
     */
    private Date endTime;
}
