package com.lianlianpay.global.ew.openapi.model.account.accounts;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huyl
 * @since 2024/11/27
 */
@Data
public class AttachmentDesc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * string
     * Enum: "HOUSEHOLD_REGISTER" "PROOF_OF_LEGAL_REP" "POWER_OF_ATTORNEY" "EQUITY_STRUCTURE_CHART" "PROOF_OF_SHARE_HOLDER" "EQUITY_TRANSFER_AGREEMENT" "SS_4" "TAX_RETURN" "ECOMMERCE_OPERATION_CERTIFICATE"
     * attachment type
     */
    private String attachmentType;

    /**
     * string
     * Enum: "Your real-name authentication has failed. Please verify your identification information and resubmit. If you have recently changed your name or relocated your household registration, please provide a color copy of the Household Register Resident Population Registration Card as a supplement." "The verification of the four key elements of the enterprise is inconsistent; the customer needs to provide additional proof of investment and employment for the legal representative." "Please provide the authorization letter from the headquarters" "Please provide a shareholding structure diagram or ownership chart stamped with the company seal (please provide the directors' signature for Hong Kong or overseas company). The document should show the individual shareholders with 25% or above of the shares" "Please provide a Beneficial Owner Appointment Declaration" "Please provide the bought and sold note of the shares, with the company seal or legal representative’s signature." "Please provide proof of EIN" "Please provide tax return documents" "Please provide the proof of verified e-commerce operation, such as a 'screenshot of the store backend showing the store owner' (must include the platform name and the store owner’s name)."
     * the description of attachment type mapping
     */
    private String attachmentDescription;
}
