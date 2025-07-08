package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class ServiceOpenRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * status
     * string
     * Enum: "NOT_APPLY" "APPLYING" "SUCCESS" "FAIL"
     */
    private String status;

    /**
     * payment_method
     * Array of strings
     * Items Enum: "Advertising / Affiliate marketing" "Digital content & product" "E-commerce" "Education" "Logistics services" "Professional services" "Travel" "Other business services"
     * Payment method.
     */
    private List<String> paymentMethod;

    /**
     * create_time
     * long
     * The object creation time. Measured in milliseconds since the Unix epoch. It's a long type number.
     */
    private Date createTime;
}
