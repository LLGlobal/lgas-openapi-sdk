package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/10/22
 */
@Getter
@Setter
public class CorporateBasicInfo implements Serializable {



    /**
     * corporate_name
     * required
     * string
     * Legal business name, Enterprise name in Chinese
     */
    private String corporateName;

    /**
     * corporate_name_en
     * required
     * string
     * Legal business name
     */
    private String corporateNameEn;

    /**
     * phone
     * string
     * phone
     */
    private String phone;

    /**
     * email
     * required
     * string
     * email
     */
    private String email;

    /**
     * company_registration_address
     * required
     * object (AddressInfo)
     * Business registered address
     */
    private AddressInfo companyRegistrationAddress;

    /**
     * company_operation_address
     * required
     * object (AddressInfo)
     * Business Address
     */
    private AddressInfo companyOperationAddress;

    /**
     * company_type
     * required
     * string
     * Enum: "JOINT_STOCK" "SELF_EMPLOYED" "STATE_OWNED" "PARTNERSHIP" "LISTED_ENTERPRISES" "LIMITED_COMPANY" "LIMITED_LIABILITY_COMPANY" "PROPRIETORSHIP" "LIMITED_PARTNERSHIP" "LIMITED_LIABILITY_PARTNERSHIP" "COMPANY"
     * Nature of business / Type of business.
     */
    private String companyType;

    /**
     * company_monthly_revenue
     * string
     * Monthly earnings
     */
    private String companyMonthlyRevenue;

    /**
     * annual_income
     * string
     * Annual earnings
     */
    private String annualIncome;

    /**
     * register_date
     * string
     * Date of business registration (yyyy-MM-dd)
     */
    private String registerDate;

    /**
     * website
     * string
     * website
     */
    private String website;

    /**
     * business_scope
     */
    private String businessScope;

    /**
     * business_category_1
     * required
     * string
     * Business category one
     */
    private String businessCategory_1;

    /**
     * business_category_2
     * required
     * string
     * Business category two;
     */
    private String businessCategory_2;

    /**
     * main_export_commodity_name
     * Array of strings
     * Items Enum: "1001" "1002" "1003" "1004" "1005" "1006" "1007" "1008" "1009" "1010" "1011" "2001" "2002" "2003" "2004" "2005" "3001" "3002" "3003" "3004"
     * Main trading commodity name
     */
    private List<String> mainExportCommodityName;

    /**
     * main_export_distinct
     * Array of strings
     * Main trading countries
     */
    private List<String> mainExportDistinct;

    /**
     * export_volume_last_year
     * string
     * Export volume for last year
     */
    private String exportVolumeLastYear;

    /**
     * memo
     * string
     * memo
     */
    private String memo;

    /**
     * company_doc
     * required
     * Array of objects (KycCertInfo)
     * Business license (mainland must be transmitted), Hong Kong business registration certificate (Hong Kong must be transmitted).
     */
    private List<CorporateKycCertInfo> companyDoc;

    /**
     * attachments
     * Array of objects (AttachmentInfo)
     * The file ID is the ID returned by the uploaded file.
     */
    private List<AttachmentDesc> attachments;
}
