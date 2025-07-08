package com.lianlianpay.global.ew.openapi.model.acceptance.payment.online;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;

/**
 * order info
 *
 * @author huyl
 * @since 2024/10/18
 */
@Getter
@Setter
@ToString
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Order id. The parameter contains a maximum of 64 characters.
     */
    private String orderId;

    /**
     * The amount to collect, main currency unit, rounded up to 2 decimal places.
     */
    private String orderAmount;

    /**
     * The currency to collect (in three-letter ISO 4217 format).
     */
    private String orderCurrency;

    /**
     * Order description.
     */
    private String orderDescription;

    /**
     * The object creation time. Measured in milliseconds since the Unix epoch.
     */
    private Date purchaseTime;

    /**
     * Product ID.
     */
    private String productId;

    /**
     * Product name.
     */
    private String productName;

    /**
     * Product count.
     */
    private String productCount;

    /**
     * Goods category.
     */
    private String goodsCategory;
}
