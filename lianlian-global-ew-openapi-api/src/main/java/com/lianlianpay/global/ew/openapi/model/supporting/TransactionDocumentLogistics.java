package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2025/4/29
 */
@Data
public class TransactionDocumentLogistics implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * delivered
     * boolean
     * Enum: "TRUE" "FALSE"
     * Whether is delivered
     * Required if business_type=GOODS_TRADE.
     */
    private Boolean delivered;

    /**
     * buyer_flag
     * string
     * Enum: "NEW_BUYER" "EXISTS_BUYER"
     * New buyer or exists buyer
     * Required if business_type ="GOODS_TRADE"and delivered = FALSE.
     */
    private String buyerFlag;

    /**
     * destination
     * string
     * Enum: "US" "VN" "SG" "ID" "PH" "KH" "MY" "KR" "AU" "AE" "DE" "FR" "IT" "NL" "BE" "LU" "IE" "ES" "PT" "AT" "FI" "LT" "LV" "EE" "SK" "SI" "GR" "MT" "CY" "PL" "TH" "GB" "CN" "HK"
     * Destination country, two-letter ISO 3166-2 country code of counterparty.
     * Required if business_type=GOODS_TRADE and delivered = TRUE.
     */
    private String destination;

    /**
     * delivery_date
     * long
     * Delivery time for this trade. Measured in milliseconds since the Unix epoch. It's a long type number.
     * Required if business_type ="GOODS_TRADE"and delivered = TRUE.
     */
    private Date deliveryDate;

    /**
     * estimated_delivery_date
     * long
     * Estimated delivery time for this trade. Measured in milliseconds since the Unix epoch. It's a long type number.
     * Required if business_type ="GOODS_TRADE"and delivered = FALSE.
     */
    private Date estimatedDeliveryDate;

    /**
     * delivery_mode
     * string
     * Enum: "CFR" "CIF" "CPT" "CIP" "DAT" "DAP" "DDP" "EXW" "FAS" "FCA" "FOB"
     * The mode of delivery
     * CFR (Cost and Freight)
     * CIF (Cost Insurance and Freight)
     * CPT (Carriage Paid To)
     * CIP (Carriage and Insurance Paid to)
     * DAT (Delivered at Terminal)
     * DAP (Delivered at Place)
     * DDP (Delivered Duty Paid)
     * EXW (EX Works)
     * FAS (Free Alongside Ship)
     * FCA (Free Carrier)
     * FOB (Free On Board)
     * Required if business_type ="GOODS_TRADE".
     */
    private String deliveryMode;

    /**
     * shipping_type
     * string
     * Enum: "MARINE_TRANSPORT" "RAILWAY_TRANSPORT" "AIR_TRANSPORT" "ROAD_TRANSPORT" "PARCEL_TRANSPORT" "MULTIMODAL_TRANSPORT"
     * The type of shipping\ Required if business_type ="GOODS_TRADE"and delivered = TRUE.
     */
    private String shippingType;

    /**
     * logistics_company
     * string
     * Carrier for goods trade
     * Required if business_type = "ECOMMERCE" and original_trade_type =GOODS.
     * Required if business_type ="GOODS_TRADE"and delivered = TRUE.
     */
    private String logisticsCompany;

    /**
     * logistics_order_no
     * string
     * Tracking number for goods trade
     * Required if business_type ="GOODS_TRADE"and delivered = TRUE.
     */
    private String logisticsOrderNo;
}
