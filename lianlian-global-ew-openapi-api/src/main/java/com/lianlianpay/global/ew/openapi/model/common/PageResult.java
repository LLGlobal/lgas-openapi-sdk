package com.lianlianpay.global.ew.openapi.model.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/11/26
 */
@Data
public class PageResult <T> implements Serializable {

    /**
     * Array of objects<br/>
     * Object content to be queried.
     */
    private List<T> pageList;

    /**
     * Total number of objects
     */
    private Integer totalCount;
}
