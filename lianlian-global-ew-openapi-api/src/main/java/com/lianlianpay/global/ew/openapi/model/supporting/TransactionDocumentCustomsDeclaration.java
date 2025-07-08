package com.lianlianpay.global.ew.openapi.model.supporting;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2025/4/29
 */
@Data
public class TransactionDocumentCustomsDeclaration implements Serializable {

    /**
     * entry_no
     * string
     * Entry No.
     *
     * decl_currency
     * string
     * Currency of declaration (in three-letter ISO 4217 format).
     *
     * decl_amount
     * string
     * The amount of declaration, main currency unit, rounded up to 2 decimal places.
     *
     * import_port_code
     * string
     * Port of import
     *
     * decl_date
     * string
     * The date of declaration
     *
     * trade_name
     * string
     * Executive/Entrusting company
     *
     * trade_co
     * string
     * Executive/Entrusting company code
     *
     * bill_no
     * string
     * B/L No.
     *
     * agent_name
     * string
     * Declaration company
     *
     * contract_no
     * string
     * Contract No.
     *
     * seller_name
     * string
     * consignor
     *
     * trade_area_code
     * string
     * Trade Country (Region)
     *
     * trade_country
     * string
     * Name of Destination Country (Region)
     *
     * entry_port_code
     * string
     * Port of entry
     *
     * transportation_mode
     * string
     * Mode of Transportation
     *
     * trade_mode
     * string
     * Mode of Trade
     *
     * license_num
     * string
     * Unified Social Credit Code
     *
     * collection_type
     * string
     * Enum: "SYSTEM" "MANUAL"
     * The type of collection
     */

    /**
     * entry_no
     * string
     * Entry No.
     */
    private String entryNo;

    /**
     * decl_currency
     * string
     * Currency of declaration (in three-letter ISO 4217 format).
     */
    private String declCurrency;

    /**
     * decl_amount
     * string
     * The amount of declaration, main currency unit, rounded up to 2 decimal places.
     */
    private String declAmount;

    /**
     * import_port_code
     * string
     * Port of import
     */
    private String importPortCode;

    /**
     * decl_date
     * string
     * The date of declaration
     */
    private String declDate;

    /**
     * trade_name
     * string
     * Executive/Entrusting company
     */
    private String tradeName;

    /**
     * trade_co
     * string
     * Executive/Entrusting company code
     */
    private String tradeCo;

    /**
     * bill_no
     * string
     * B/L No.
     */
    private String billNo;

    /**
     * agent_name
     * string
     * Declaration company
     */
    private String agentName;

    /**
     * contract_no
     * string
     * Contract No.
     */
    private String contractNo;

    /**
     * seller_name
     * string
     * consignor
     */
    private String sellerName;

    /**
     * trade_area_code
     * string
     * Trade Country (Region)
     */
    private String tradeAreaCode;

    /**
     * trade_country
     * string
     * Name of Destination Country (Region)
     */
    private String tradeCountry;

    /**
     * entry_port_code
     * string
     * Port of entry
     */
    private String entryPortCode;

    /**
     * transportation_mode
     * string
     * Mode of Transportation
     */
    private String transportationMode;

    /**
     * trade_mode
     * string
     * Mode of Trade
     */
    private String tradeMode;

    /**
     * license_num
     * string
     * Unified Social Credit Code
     */
    private String licenseNum;

    /**
     * collection_type
     * string
     * Enum: "SYSTEM" "MANUAL"
     * The type of collection
     */
    private String collectionType;

}
