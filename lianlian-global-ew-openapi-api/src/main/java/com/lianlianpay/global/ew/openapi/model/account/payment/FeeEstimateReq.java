package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author huyl
 * @since 2025/4/29
 */
@Data
public class FeeEstimateReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * transaction_type
     * Business scenario:PAYOUT、WITHDRAW.
     */
    private String transactionType;

    /**
     * pay_currency
     * The actual currency of payment by the payer (in three-letter ISO 4217 format).
     */
    private String payCurrency;

    /**
     * pay_amount
     * Send amount and pay amount must specify one Amount paid to payee, main currency unit, rounded up to 2 decimal places.
     */
    private String payAmount;

    /**
     * send_currency
     * Currency of payment to Contact (in three-letter ISO 4217 format).
     */
    private String sendCurrency;

    /**
     * send_amount
     * Send amount and pay amount must specify one Amount paid to payee, main currency unit, rounded up to 2 decimal places.
     */
    private String sendAmount;

    /**
     * rate_id
     * When exchange is required, the exchange rate ID can be obtained through [Create a LockFX Quote]. If left blank, the system will automatically complete the exchange.
     */
    private String rateId;

    /**
     * account_id
     * Payee LianLian account id,if the payment goes to the LianLian internal account, this field is mandatory.
     */
    private String accountId;

    /**
     * beneficiary
     * Beneficiary
     */
    private EstimateBeneficiary beneficiary;

    /**
     * additional_info
     * Structured field names and values used to define the business information.
     * If the key name is region, the value must be US, SG, HK, GB.
     */
    private Map<String, String> additionalInfo;
}
