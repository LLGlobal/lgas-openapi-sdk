package com.lianlianpay.global.ew.openapi.service;

import com.lianlianpay.global.ew.openapi.api.account.accounts.BalancesApi;
import com.lianlianpay.global.ew.openapi.api.account.accounts.CoreAccountsApi;
import com.lianlianpay.global.ew.openapi.api.account.accounts.ReceivingAccountsApi;
import com.lianlianpay.global.ew.openapi.api.account.exchanges.ExchangeApi;
import com.lianlianpay.global.ew.openapi.api.account.payment.*;
import com.lianlianpay.global.ew.openapi.api.account.platform.SplitsApi;
import com.lianlianpay.global.ew.openapi.api.account.query.TransactionApi;
import com.lianlianpay.global.ew.openapi.api.account.services.CardsApi;
import com.lianlianpay.global.ew.openapi.api.account.services.RemittanceApi;
import com.lianlianpay.global.ew.openapi.client.Client;
import com.lianlianpay.global.ew.openapi.client.enums.AuthMode;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.accounts.*;
import com.lianlianpay.global.ew.openapi.model.account.exchanges.ConversionCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.exchanges.ConversionDetailRes;
import com.lianlianpay.global.ew.openapi.model.account.exchanges.LockedFxQuoteCreateReq;
import com.lianlianpay.global.ew.openapi.model.account.exchanges.LockedFxQuoteRes;
import com.lianlianpay.global.ew.openapi.model.account.payment.*;
import com.lianlianpay.global.ew.openapi.model.account.platform.*;
import com.lianlianpay.global.ew.openapi.model.account.query.*;
import com.lianlianpay.global.ew.openapi.model.account.service.*;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import io.reactivex.Single;
import retrofit2.http.DELETE;
import retrofit2.http.Path;


import java.util.List;

/**
 * @author huyl
 * @since 2024/12/12
 */
public class AccountService {
    
    
    private final Client client;
    
    /**
     * Balances API
     */
    private final BalancesApi balancesApi;
    
    /**
     * Core Accounts API
     */
    private final CoreAccountsApi coreAccountsApi;
    
    /**
     * Receiving Accounts API
     */
    private final ReceivingAccountsApi receivingAccountsApi;

    /**
     * Exchange API
     */
    private final ExchangeApi exchangeApi;
    
    /**
     * Bank Accounts API
     */
    private final BankAccountsApi bankAccountsApi;
    
    /**
     * Mandate API
     */
    private final MandateApi mandateApi;
    
    /**
     * Network Accounts API
     */
    private final NetworkAccountsApi networkAccountsApi;
    
    /**
     * Payer API
     */
    private final PayerApi payerApi;
    
    /**
     * Payouts API
     */
    private final PayoutsApi payoutsApi;

    /**
     * Refunds API
     */
    private final RefundsApi refundsApi;
    
    /**
     * Request Payments API
     */
    private final RequestPaymentsApi requestPaymentsApi;
    
    /**
     * Withdraw API
     */
    private final WithdrawApi withdrawApi;

    /**
     * Estimate API
     */
    private final EstimateApi estimateApi;
    
    /**
     * Splits API
     */
    private final SplitsApi splitsApi;

    /**
     * Transaction API
     */
    private final TransactionApi transactionApi;
    
    /**
     * Cards API
     */
    private final CardsApi cardsApi;
    
    /**
     * Remittance API
     */
    private final RemittanceApi remittanceApi;
    
    public AccountService(Client client) {
        this.client = client;
        balancesApi = this.client.create(BalancesApi.class);
        coreAccountsApi = this.client.create(CoreAccountsApi.class);
        receivingAccountsApi = this.client.create(ReceivingAccountsApi.class);
        exchangeApi = this.client.create(ExchangeApi.class);
        bankAccountsApi = this.client.create(BankAccountsApi.class);
        mandateApi = this.client.create(MandateApi.class);
        networkAccountsApi = this.client.create(NetworkAccountsApi.class);
        payerApi = this.client.create(PayerApi.class);
        payoutsApi = this.client.create(PayoutsApi.class);
        refundsApi = this.client.create(RefundsApi.class);
        requestPaymentsApi = this.client.create(RequestPaymentsApi.class);
        withdrawApi = this.client.create(WithdrawApi.class);
        estimateApi = this.client.create(EstimateApi.class);
        splitsApi = this.client.create(SplitsApi.class);
        transactionApi = this.client.create(TransactionApi.class);
        cardsApi = this.client.create(CardsApi.class);
        remittanceApi = this.client.create(RemittanceApi.class);
    }


    /**
     * Retrieve all balances
     * @return
     */
    public Result<List<BalanceDetailRes>> retrieveAllBalances() {
        return client.execute(balancesApi.retrieveAllBalances());
    }


    /**
     * Create an account
     * @param req
     * @return
     */
    public Result<AccountDetailRes> createAccount(AccountCreateReq req) {
        return client.execute(coreAccountsApi.createAccount(req));
    }

    /**
     * Retrieve an account
     * @return
     */
    public Result<AccountDetailRes> retrieveAccount() {
        return client.execute(coreAccountsApi.retrieveAccount());
    }

    /**
     * Relate an associate account
     * @param req
     * @return
     */
    public Result<AccountDetailRes> relateAssociateAccount(AssociateAccountRelateReq req){
        return client.execute(coreAccountsApi.relateAssociateAccount(req));
    }

    /**
     * Submit Corporate Account KYC
     * @param req
     * @return
     */
    public Result<AccountDetailRes> submitCorporateAccountKyc(CorporateAccountKycReq req){
        return client.execute(coreAccountsApi.submitCorporateAccountKyc(req));
    }

    /**
     * Submit Individual Account KYC
     * @param req
     * @return
     */
    public Result<AccountDetailRes> submitIndividualAccountKyc(IndividualKycReq req){
        return client.execute(coreAccountsApi.submitIndividualAccountKyc(req));
    }

    /**
     * Authorize an account
     * @param req
     * @return
     */
    public Result<AccountAuthorizeRes> authorizeAccount(AccountAuthorizeReq req){
        return client.execute(coreAccountsApi.authorizeAccount(req));
    }

    /**
     * Retrieve interim info
     * @return
     */
    public Result<AccountDetailRes> retrieveInterimInfo() {
        return client.execute(coreAccountsApi.retrieveInterimInfo());
    }


    /**
     * Submit Corporate Interim KYC
     * @param req
     * @return
     */
    public Result<AccountDetailRes> submitCorporateInterimKyc(CorporateInterimKycReq req) {
        return client.execute(coreAccountsApi.submitCorporateInterimKyc(req));
    }

    /**
     * Submit Individual Interim KYC
     * @param req
     * @return
     */
    public Result<AccountDetailRes> submitIndividualInterimKyc(IndividualInterimKycReq req){
        return client.execute(coreAccountsApi.submitIndividualInterimKyc(req));
    }


    /**
     * Open receiving account <br/>
     * There are accounts under application. Applications may not be initiated.
     * @param req
     * @return
     */
    public Result<ReceivingAccountDetailRes> openReceivingAccount(ReceivingAccountOpenReq req) {
        return client.execute(receivingAccountsApi.openReceivingAccount(req));
    }

    /**
     * Retrieve all receiving accounts
     * @return
     */
    public Result<List<ReceivingAccountDetailRes>> retrieveAllReceivingAccounts() {
        return client.execute(receivingAccountsApi.retrieveAllReceivingAccounts());
    }

    /**
     * Retrieve a receiving account <br/>
     * Retrieve the information of the Receiving Account with the matching ID.
     * @param accountId
     * @return
     */
    public Result<ReceivingAccountDetailRes> retrieveReceivingAccount(String accountId) {
        return client.execute(receivingAccountsApi.retrieveReceivingAccount(accountId));
    }

    /**
     * <h3>Create a Conversion</h3>
     * Create a new Conversion to be executed. To associate a conversion with a Payout, use the Payout API.
     * Note: On a conversion, both buy_currency and sell_currency will be populated, but define only one of either buy_amount or sell_amount.
     * @param req
     * @return
     */
    public Result<ConversionDetailRes> createConversion(ConversionCreateReq req){
        return client.execute(exchangeApi.createConversion(req));
    }

    /**
     * <h3>Retrieve a Conversion</h3>
     * Retrieve a detail of a Conversion transaction.
     * @param requestId
     * @return
     */
    public Result<ConversionDetailRes> retrieveConversion(String requestId) {
        return client.execute(exchangeApi.retrieveConversion(requestId));
    }

    /**
     * <h3>Create a Locked FX Quote</h3>
     * Create a Locked FX Quote to be used in a Conversion transaction.
     * @param req
     * @return
     */
    public Result<LockedFxQuoteRes> createLockedFxQuote(LockedFxQuoteCreateReq req) {
        return client.execute(exchangeApi.createLockedFxQuote(req));
    }

    /**
     * Retrieve all Bank Accounts.
     * @param req
     * @return
     */
    public Result<PageResult<BankAccountRes>> retrieveAllBankAccounts(BankAccountPageReq req) {
        return client.execute(bankAccountsApi.retrieveAllBankAccounts(req));
    }

    /**
     * Retrieve a specific bank account by ID.
     * @param accountId
     * @return
     */
    public Result<BankAccountRes> retrieveBankAccount(String accountId) {
        return client.execute(bankAccountsApi.retrieveBankAccount(accountId));
    }

    /**
     * Disconnect a specific bank account by ID.
     * @param accountId
     * @return Characters "OK" if Succeeded
     */
    public Result<BankAccountDisconnectRes> disconnectBankAccount(String accountId) {
        return client.execute(bankAccountsApi.disconnectBankAccount(accountId));
    }

    /**
     * A Bank Account can be used in payout transactions to an external bank account. A notification of the audit result will be sent by Webhook after creation and audit by LianLian Global, so make sure you subscribe the payee related event Payee. In the bank_info, some optional fields sometimes can be required depends on clearing_code and bank_country_code.
     * @param req
     * @return
     */
    public Result<BankAccountRes> connectBankAccount(BankAccountConnectReq req) {
        return client.execute(bankAccountsApi.connectBankAccount(req));
    }

    /**
     * Retrieve a specific bank account by the merchant_client_id.
     * @param merchantClientId
     * @return
     */
    public Result<BankAccountRes> retrieveBankAccountByMerchant(String merchantClientId) {
        return client.execute(bankAccountsApi.retrieveBankAccountByMerchant(merchantClientId));
    }

    /**
     * Disconnect a specific bank account by the merchant_client_id.
     * @param merchantClientId
     * @return Characters "OK" if Succeeded
     */
    public Result<BankAccountDisconnectRes> disconnectBankAccountByMerchant(String merchantClientId) {
        return client.execute(bankAccountsApi.disconnectBankAccountByMerchant(merchantClientId));
    }

    /**
     * <h3>Create a mandate</h3>
     * Create a Mandate URL for a Payer.
     * @param req
     * @return
     */
    public Result<MandateCreateRes> createMandate(MandateCreateReq req) {
        return client.execute(mandateApi.createMandate(req));
    }

    /**
     * <h3>Cancel a mandate</h3>
     * @param req
     * @return
     */
    public Result<MandateDetailRes> cancelMandate(MandateCancelReq req) {
        return client.execute(mandateApi.cancelMandate(req));
    }

    /**
     * <h3>Retrieve a mandate</h3>
     * @param requestId
     * @return
     */
    public Result<MandateDetailRes> retrieveMandate(String requestId) {
        return client.execute(mandateApi.retrieveMandate(requestId));
    }

    /**
     * <h3>Retrieve all mandates</h3>
     * @param req
     * @return
     */
    public Result<PageResult<MandateDetailRes>> retrieveAllMandates(MandatePageReq req) {
        return client.execute(mandateApi.retrieveAllMandates(req));
    }

    /**
     * Connect a network account
     * @param req
     * @return
     */
    public Result<NetworkAccountConnectRes> connectNetworkAccount(NetworkAccountConnectReq req) {
        return client.execute(networkAccountsApi.connectNetworkAccount(req));
    }

    /**
     * Retrieve all network accounts
     * @param req
     * @return
     */
    public Result<PageResult<NetworkAccountDetailRes>> retrieveAllNetworkAccounts(NetworkAccountPageReq req) {
        return client.execute(networkAccountsApi.retrieveAllNetworkAccounts(req));
    }

    /**
     * Retrieve a network account
     * @param accountId
     * @return
     */
    public Result<NetworkAccountDetailRes> retrieveNetworkAccount(String accountId) {
        return client.execute(networkAccountsApi.retrieveNetworkAccount(accountId));
    }

    /**
     * Disconnect a network account
     * @param accountId
     * @return
     */
    public Result<NetworkAccountDisconnectRes> disconnectNetworkAccount(String accountId) {
        return client.execute(networkAccountsApi.disconnectNetworkAccount(accountId));
    }

    /**
     * Create a network account
     * @param req
     * @return
     */
    public Result<NetworkAccountDetailRes> createNetworkAccount(NetworkAccountCreateReq req) {
        return client.execute(networkAccountsApi.createNetworkAccount(req));
    }

    /**
     * Retrieve a network account by merchant client id
     * @param merchantClientId
     * @return
     */
    public Result<NetworkAccountDetailRes> retrieveNetworkAccountByMerchant(String merchantClientId) {
        return client.execute(networkAccountsApi.retrieveNetworkAccountByMerchant(merchantClientId));
    }

    /**
     * Disconnect a network account by merchant client id
     * @param merchantClientId
     * @return
     */
    public Result<NetworkAccountDisconnectRes> disconnectNetworkAccountByMerchant(String merchantClientId) {
        return client.execute(networkAccountsApi.disconnectNetworkAccountByMerchant(merchantClientId));
    }

    /**
     * Create a payer <br/>
     * After a new Payer is created, it will be audited by LianLian Global before it can be used in payout transactions. A notification of the audit result will be sent by Webhook after subscribing the payer related event Payer.
     * @param req
     * @return
     */
    public Result<PayerDetailRes> createPayer(PayerCreateReq req) {
        return client.execute(payerApi.createPayer(req));
    }

    /**
     * Retrieve a payer
     * @param payerId
     * @return
     */
    public Result<PayerDetailRes> retrievePayer(String payerId) {
        return client.execute(payerApi.retrievePayer(payerId));
    }

    /**
     * Retrieve a payer by merchant client id
     * @param merchantClientId
     * @return
     */
    public Result<PayerDetailRes> retrievePayerByMerchant(String merchantClientId) {
        return client.execute(payerApi.retrievePayerByMerchant(merchantClientId));
    }

    /**
     * Disconnect a payer
     * @param payerId
     * @return
     */
    public Result<PayerDisconnectRes> disconnectPayer(String payerId) {
        return client.execute(payerApi.disconnectPayer(payerId));
    }

    /**
     * Disconnect a payer by merchant client id
     * @param merchantClientId
     * @return
     */
    public Result<PayerDisconnectRes> disconnectPayerByMerchant(String merchantClientId) {
        return client.execute(payerApi.disconnectPayerByMerchant(merchantClientId));
    }

    /**
     * Retrieve all payers
     * @param req
     * @return
     */
    public Result<PageResult<PayerDetailRes>> retrieveAllPayers(PayerPageReq req) {
        return client.execute(payerApi.retrieveAllPayers(req.getPage(), req.getPageSize(), req.getKeyword()));
    }

    /**
     * <h3>Retrieve a payout</h3>
     * @param requestId
     * @return
     */
    public Result<PayoutDetailRes> retrievePayout(String requestId) {
        return client.execute(payoutsApi.retrievePayout(requestId));
    }


    /**
     * <H3>Create a payout</H3> <br/>
     * Create a payout to an account.<br/>
     * The successful creation only represents the successful receipt of the distribution order by LianLian Global, does not means the transaction succeed. You can use Retrieve a Payout by Request ID API to obtain transaction results.<br/>
     * If you want to receive notification of transaction results, you can subscribe to payout related event Payout.<br/>
     * [Note] Payment can include exchange when send_currency and pay_currency are different, and conversion is not included when send_currency matches pay_currency.<br/>
     * The payer is responsible for the payment fee.<br/>
     * @param req
     * @return
     */
    public Result<PayoutDetailRes> createPayout(PayoutCreateReq req) {
        return client.execute(payoutsApi.createPayout(req));
    }


    /**
     * <H3>Create a payout to app</H3> <br/>
     * Create a payout to APP(this APP will be onboarding Ewallet). <br/>
     * The successful creation only represents the successful receipt of the distribution order by LianLian Global, does not means the transaction succeed. You can use Retrieve a Payout by Request ID API to obtain transaction results.<br/>
     * If you want to receive notification of transaction results, you can subscribe to payout related event Payout.<br/>
     * [Note] Payment can include exchange when send_currency and pay_currency are different, and conversion is not included when send_currency matches pay_currency.<br/>
     * The payer is responsible for the payment fee.<br/>
     * @param req
     * @return
     */
    public Result<PayoutDetailRes> createPayout2App(Payout2AppCreateReq req) {
        return client.execute(payoutsApi.createPayout2App(req));
    }

    /**
     * <h3>Create a refund</h3>
     * When initiating a new refund within the API, it is essential to provide a valid receipt_order_id. This identifier serves as the basis for the refund and ensures that it corresponds to a previously received payment.
     * The process of creating a new refund will result in reimbursing a previously generated charge. The funds will be returned to the original payer who initiated the payment transaction.
     * @param req
     * @return
     */
    public Result<RefundDetailRes> createRefund(RefundCreateReq req) {
        return client.execute(refundsApi.createRefund(req));
    }


    /**
     * <h3>Retrieve a refund</h3>
     * Retrieve a the detail of a refund transaction by Request ID.
     * @param requestId
     * @return
     */
    public Result<RefundDetailRes> retrieveRefund(String requestId) {
        return client.execute(refundsApi.retrieveRefund(requestId));
    }

    /**
     * Retrieve a request payment
     * @param requestId
     * @return
     */
    public Result<RequestPaymentDetailRes> retrievePayment(String requestId) {
        return client.execute(requestPaymentsApi.retrievePayment(requestId));
    }

    /**
     * Create a request payment
     * @param req
     * @return
     */
    public Result<RequestPaymentDetailRes> createPayment(RequestPaymentCreateReq req) {
        return client.execute(requestPaymentsApi.createPayment(req));
    }

    /**
     * Create a request payment url
     * @param req
     * @return
     */
    public Result<RequestPaymentUrlRes> createPaymentUrl(RequestPaymentUrlCreateReq req) {
        return client.execute(requestPaymentsApi.createPaymentUrl(req));
    }

    /**
     * Cancel a request payment
     * @param req
     * @return
     */
    public Result<RequestPaymentCancelRes> cancelPayment(RequestPaymentCancelReq req) {
        return client.execute(requestPaymentsApi.cancelPayment(req));
    }

    /**
     * <h3>Create a beneficiary account</h3>
     * Create a new beneficiary to be stored on the LLG platform.
     * @param req
     * @return
     */
    public Result<BeneficiaryAccountDetailRes> createBeneficiaryAccount(BeneficiaryAccountCreateReq req) {
        return client.execute(withdrawApi.createBeneficiaryAccount(req));
    }

    /**
     * <h3>Retrieve all beneficiary accounts</h3>
     * @param req
     * @return
     */
    public Result<PageResult<BeneficiaryAccountDetailRes>> retrieveAllBeneficiaryAccounts(BeneficiaryAccountPageReq req) {
        return client.execute(withdrawApi.retrieveAllBeneficiaryAccounts(req));
    }


    /**
     * <h3>Create a withdraw</h3>
     * <p>Create a withdraw to a Beneficiary.
     * The successful creation only represents the successful receipt of the distribution order by LianLian Global, does not means the transaction succeed. You can use Retrieve a Withdraw by Request ID API to obtain transaction results.
     * If you want to receive notification of transaction results, you can subscribe to event withdraw.
     * [Note] withdraw can include exchange when send_currency and withdraw_currency are different, and conversion is not included when send_currency matches withdraw_currency.
     * The payer is responsible for the payment fee.</p>
     **/
    public Result<WithdrawDetailRes> createWithdraw(WithdrawCreateReq req) {
        return client.execute(withdrawApi.createWithdraw(req));
    }

    /**
     * <h3>Retrieve a withdraw</h3>
     * @param requestId
     * @return
     */
    public Result<WithdrawDetailRes> retrieveWithdraw(String requestId) {
        return client.execute(withdrawApi.retrieveWithdraw(requestId));
    }

    /**
     * <h3>Estimate a fee</h3>
     * Use this endpoint to get the fee estimate for a payment.
     * @param req
     * @return
     */
    public Result<FeeEstimateRes> estimateFee(FeeEstimateReq req) {
        return client.execute(estimateApi.estimateFee(req));
    }

    /**
     * <h3>Create a split</h3>
     * Use this endpoint to send settlement data to LLG for further release
     * after the corresponding funds been deposited and bank_reference matched.
     * @param req
     * @return
     */
    public Result<SplitDetailRes> createSplit(SplitCreateReq req) {
        return client.execute(splitsApi.createSplit(req));
    }

    /**
     * <h3>Release a split</h3>
     * Use this endpoint to release a previous fund split and funds
     * will be deducted from holding account and added to seller's available balance.
     * @param req
     * @return
     */
    public Result<SplitRes> releaseSplit(SplitReleaseReq req) {
        return client.execute(splitsApi.releaseSplit(req));
    }

    /**
     * <h3>Refund a split</h3>
     * If the Fund split has not yet been release, it can be refunded.
     * Partial refunds can be made for the original order.
     * @param req
     * @return
     */
    public Result<SplitRes> refundSplit(SplitRefundReq req) {
        return client.execute(splitsApi.refundSplit(req));
    }

    /**
     * <h3>Retrieve all splits</h3>
     * Retrieve list of FundSplits
     * @param req
     * @return
     */
    public Result<PageResult<SplitDetailRes>> retrieveAllSplits(SplitPageReq req) {
        return client.execute(splitsApi.retrieveAllSplits(req));
    }

    /**
     * <h3>Retrieve a split</h3>
     * Retrieve a FundsSplit by Request ID.
     * @param requestId
     * @return
     */
    public Result<SplitDetailRes> retrieveSplit(String requestId) {
        return client.execute(splitsApi.retrieveSplit(requestId));
    }

    /**
     * <h3>Retrieve a split release</h3>
     * Retrieve a FundsSplit Release by Request ID.
     * @param requestId
     * @return
     */
    public Result<SplitRes> retrieveSplitRelease(String requestId) {
        return client.execute(splitsApi.retrieveSplitRelease(requestId));
    }

    /**
     * <h3>Retrieve a split refund</h3>
     * Retrieve a FundsSplit Refund by Request ID.
     * @param requestId
     * @return
     */
    public Result<SplitRes> retrieveSplitRefund(String requestId) {
        return client.execute(splitsApi.retrieveSplitRefund(requestId));
    }

    /**
     * <h3>Retrieve all transactions</h3>
     * @param req
     * @return
     */
    public Result<PageResult<TransactionDetailRes>> retrieveAllTransactions(TransactionPageReq req) {
        return client.execute(transactionApi.retrieveAllTransactions(req));
    }

    /**
     * <h3>Retrieve a receiving</h3>
     * Retrieve the information of the Receiving with the matching Transaction ID. Receiving Accounts are accounts that function as local bank accounts. They can be used to collect funds from around the world. You get account details that enable you to collect funds from various platforms such as Amazon, Etsy, etc.
     * You can apply Receiving Accounts on LianLian Global's website, and by using Receiving API you could query your Receiving accounts and Receiving transactions detail information.
     * <br/><img src="https://docs.lianlianglobal.com/llg_img/0stplt/ooe1JpNsV1Q.png" alt="receiving-accounts">
     * @param id
     * @return
     */
    public Result<ReceivingDetailRes> retrieveReceiving(String id) {
        return client.execute(transactionApi.retrieveReceiving(id));
    }

    /**
     * <h3>Retrieve a receipt</h3>
     * @param id
     * @return
     */
    public Result<ReceiptDetailRes> retrieveReceipt(String id) {
        return client.execute(transactionApi.retrieveReceipt(id));
    }

    /**
     * <h3>Retrieve a recharge</h3>
     * Retrieve the information of the Recharge transaction with the matching ID.
     * @param id
     * @return
     */
    public Result<RechargeDetailRes> retrieveRecharge(String id) {
        return client.execute(transactionApi.retrieveRecharge(id));
    }

    /**
     * <h3>Retrieve a card payout</h3>
     * Retrieve the information of the Card Payout with the matching Transaction ID.
     * @param id
     * @return
     */
    public Result<CardPayoutDetailRes> retrieveCardPayout(String id) {
        return client.execute(transactionApi.retrieveCardPayout(id));
    }


    /**
     * <h3>Open a service</h3>
     * Agree to open the VCC service agreement.
     * @param req
     * @return
     */
    public Result<ServiceOpenRes> openService(ServiceOpenReq req) {
        return client.execute(cardsApi.openService(req));
    }

    /**
     * <h3>Apply for a card</h3>
     * The card object is the actual resource associated with the card issued out by LLG.
     * @param req
     * @return
     */
    public Result<CardDetailRes> applyCard(CardApplyReq req) {
        return client.execute(cardsApi.applyCard(req));
    }

    /**
     * <h3>Set card limits</h3>
     * @param req
     * @return
     */
    public Result<CardDetailRes> setCardLimit(CardLimitSetReq req) {
        return client.execute(cardsApi.setCardLimit(req));
    }

    /**
     * <h3>Cancel a card</h3>
     * Cancel the card. The card will not be available after the operation.
     * @param req
     * @return
     */
    public Result<CardDetailRes> cancelCard(CardCancelReq req) {
        return client.execute(cardsApi.cancelCard(req));
    }

    /**
     * <h3>Retrieve all cards</h3>
     * Get cards issued under an account.
     * @param req
     * @return
     */
    public Result<PageResult<CardDetailRes>> retrieveAllCards(CardPageReq req) {
        return client.execute(cardsApi.retrieveAllCards(req));
    }

    /**
     * <h3>Retrieve a card</h3>
     * Get the details of a card.
     * @param cardId
     * @return
     */
    public Result<CardDetailRes> retrieveCard(String cardId) {
        return client.execute(cardsApi.retrieveCard(cardId));
    }

    /**
     * <h3>Retrieve a sensitive card</h3>
     * Retrieve a sensitive card details.PCI certified can apply for the interface.
     * @param cardId
     * @return
     */
    public Result<SensitiveCardDetailRes> retrieveSensitiveCard(String cardId) {
        return client.execute(cardsApi.retrieveSensitiveCard(cardId));
    }

    /**
     * <h3>Retrieve a sensitive card URL</h3>
     * View card sensitive data. By returning the URL .
     * Let the user authenticate and show card details directly.
     * @param cardId
     * @return
     */
    public Result<SensitiveCardUrlRes> retrieveSensitiveCardUrl(String cardId) {
        return client.execute(cardsApi.retrieveSensitiveCardUrl(cardId));
    }

    /**
     * <h3>Retrieve card authorizations</h3>
     * Get a authorization transaction.
     * @param req
     * @return
     */
    public Result<PageResult<CardAuthorizationDetailRes>> retrieveCardAuthorizations(CardAuthorizationPageReq req) {
        return client.execute(cardsApi.retrieveCardAuthorizations(req));
    }

    /**
     * <h3>Retrieve card settlements</h3>
     * Get a settlement transaction.
     * @param req
     * @return
     */
    public Result<PageResult<CardSettlementDetailRes>> retrieveCardSettlements(CardSettlementPageReq req) {
        return client.execute(cardsApi.retrieveCardSettlements(req));
    }

    /**
     * <h3>Retrieve a fx quote</h3>
     * Query remittance transaction FX rate
     * @param req
     * @return
     */
    public Result<FxQuoteDetailRes> retrieveFxQuote(FxQuoteQueryReq req) {
        return client.execute(remittanceApi.retrieveFxQuote(req));
    }

    /**
     * <h3>Create a remittance</h3>
     * Before sending out a remittance transaction, partner must initiate a remittance creation request to LianLian Global to ensure the transaction is able to send.
     * @param req
     * @return
     */
    public Result<RemittanceCreateRes> createRemittance(RemittanceCreateReq req) {
        return client.execute(remittanceApi.createRemittance(req));
    }

    /**
     * <h3>Submit a remittance</h3>
     * Partner initiates remittance submission request to send the transaction. The remittance creation request must be successful before remittance submission.
     * @param req
     * @return
     */
    public Result<RemittanceDetailRes> submitRemittance(RemittanceSubmitReq req) {
        return client.execute(remittanceApi.submitRemittance(req));
    }

    /**
     * <h3>Retrieve a remittance</h3>
     * Retrieve a Remittance by Request ID.
     * @param requestId
     * @return
     */
    public Result<RemittanceDetailRes> retrieveRemittance(String requestId) {
        return client.execute(remittanceApi.retrieveRemittance(requestId));
    }

    /**
     * Refresh access token
     * @param newAccessToken
     * @return
     */
    public AccountService newAccessToken(String newAccessToken) {
        this.client.getConfiguration().newAccessToken(newAccessToken);
        return this;
    }
}