package com.lianlianpay.global.ew.openapi.model.account.payment;

import com.lianlianpay.global.ew.openapi.model.common.FeeInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author huyl
 * @since 2025/4/29
 */
@Data
public class FeeEstimateRes implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * transaction_type
     * string
     * Business scenario:PAYOUT、WITHDRAW.
     */
    private String transactionType;

    /**
     * pay_currency
     * string
     * The actual currency of payment by the payer (in three-letter ISO 4217 format).
     */
    private String payCurrency;

    /**
     * pay_amount
     * string
     * Pay amount, rounded up to 2 decimal places.
     */
    private String payAmount;

    /**
     * send_currency
     * string
     * Currency of payment to Contact (in three-letter ISO 4217 format).
     */
    private String sendCurrency;

    /**
     * send_amount
     * string
     * Send amount, rounded up to 2 decimal places.
     */
    private String sendAmount;

    /**
     * rate_id
     * string
     * When exchange is required, the exchange rate ID can be obtained through [Create a LockFX Quote]. If left blank, the system will automatically complete the exchange.
     */
    private String rateId;

    /**
     * account_id
     * string
     * Payee LianLian account id,if the payment goes to the LianLian internal account, this field is mandatory.
     */
    private String accountId;

    /**
     * beneficiary
     * object (EstimateBeneficiary)
     * Beneficiary
     */
    private EstimateBeneficiary beneficiary;

    /**
     * conversion
     * object (EstimateConversion)
     */
    private EstimateConversion conversion;

    /**
     * fee
     * object
     */
    private FeeInfo fee;

    /**
     * additional_info
     * object (Map)
     * Structured field names and values used to define the business information.
     */
    private Map<String, String> additionalInfo;

}
