package com.lianlianpay.global.ew.openapi.model.account.service;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/12/5
 */
@Data
public class CardCancelReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * Card ID.
     */
    private String cardId;
}
