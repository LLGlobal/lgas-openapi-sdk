package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/4/29
 */
@Data
public class TransactionDocumentProduct implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * product_id
     * string
     * Product ID
     */
    private String productId;

    /**
     * product_name
     * string
     * Name of product/service Name of product if original_order_type = GOODS, name of service if original_order_type = SERVICES
     */
    private String productName;

    /**
     * quantity
     * string
     * Quantity of goods/service Quantity of product if original_order_type = GOODS, quantity of service if original_order_type = SERVICES
     */
    private String quantity;

    /**
     * service_detail
     * string
     * Details of service
     * Required if original_trade_type =SERVICES
     */
    private String serviceDetail;

    /**
     * service_time
     * string
     * Time of service
     * Required if original_trade_type =SERVICES
     */
    private String serviceTime;

    /**
     * unit
     * string
     * Unit of goods/services
     * Required if business_type=GOODS_TRADE.
     */
    private String unit;


}
