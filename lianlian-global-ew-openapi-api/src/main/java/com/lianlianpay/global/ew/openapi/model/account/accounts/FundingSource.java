package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyl
 * @since 2024/11/28
 */
@Data
public class FundingSource implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * Value: "SHOP"
     * The source type of the funding.
     */
    private String type;

    /**
     * shops
     * Array of objects (UserShop)
     * The shops that are associated with the funding source.
     */
    private List<UserShop> shops;
}
