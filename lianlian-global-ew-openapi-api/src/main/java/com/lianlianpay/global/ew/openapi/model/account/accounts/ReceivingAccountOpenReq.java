package com.lianlianpay.global.ew.openapi.model.account.accounts;

import com.lianlianpay.global.ew.openapi.model.common.AdditionalInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author huyl
 * @since 2024/11/28
 */
@Data
public class ReceivingAccountOpenReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * Two-letter ISO 3166-2 country code. <br/>
     * Country (ISO 3166)	Currency (ISO 4217) <br/>
     * UK	GBP <br/>
     * US	USD <br/>
     * FI	EUR <br/>
     * PL	PLN <br/>
     * CA	CAD <br/>
     * AU	AUD <br/>
     * SG	SGD <br/>
     * MX	MXN <br/>
     * JP	JPY <br/>
     * ID	IDR <br/>
     * HK	HKD <br/>
     */
    private String countryCode;

    /**
     * Currency of the global account (in three-letter ISO 4217 format).
     */
    private String currency;

    /***
     * Items Enum: "Advertising" "Cross Border Education" "Customs Clearance Service" "Developer Service" "E-commerce merchant" "E-commerce platform" "Financial Service" "Freelancer" "Gaming Publisher" "Industrial & Manufacturing" "Logistic" "Merchandise Trade" "Online Travel Agency Service" "Tax Agency" "Warehouse" <br/>
     * Receive category.
     */
    private List<String> receiveCategory;

    /**
     * Nickname of the global account. Default: current account's business name.
     */
    private String nickName;

    /**
     * The ID of File Folder object. <br/>
     * Example: Study abroad education platform, the education platform applies for the collection of VBA for the students on its platform, provides the KYC information of the relevant students and other materials such as enrollment notices.
     */
    private String fileFolderId;

    /**
     * additional_info
     */
    private Map<String, String> additionalInfo;
}
