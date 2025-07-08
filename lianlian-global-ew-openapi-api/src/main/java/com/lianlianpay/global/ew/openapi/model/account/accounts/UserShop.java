package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/11/28
 */
@Data
public class UserShop implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * unique ID created by the LianLian Global.
     */
    private String shopId;

    /**
     * Value: "ECOMM_Platform"
     */
    private String fundSourceType;

    /**
     * Memo of shop.
     */
    private String memo;

    /**
     * Name of user for shop.
     */
    private String userName;

    /**
     * Url of shop.
     */
    private String shopUrl;

    /**
     * Name of marketplace.
     */
    private String marketplaceEntityName;

    /**
     * Unique identifier of the User.
     */
    private String userId;

    /**
     * account_id of Balance.
     */
    private String balanceAccountId;

    /**
     * ID of seller on marketplace.
     */
    private String sellerId;

    /**
     * The object creation time. Measured in milliseconds since the Unix epoch.
     */
    private Date createTime;

    /**
     * This field occurs when an error occurs.
     */
    private String failureReason;

    private String businessCategory;

    /**
     * Enum: "INIT" "SUBMITTED" "APPROVED" "DECLINED" <br/>
     * Status of shop in LianLian Global.
     */
    private String status;

    /**
     * Enum: "URL" "TOKEN" <br/>
     * Shop binding method type.
     */
    private String bindingMethod;

    /**
     * Address for shop.
     */
    private String address;
}
