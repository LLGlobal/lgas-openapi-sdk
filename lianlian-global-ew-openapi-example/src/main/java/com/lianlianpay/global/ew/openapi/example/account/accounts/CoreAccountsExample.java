package com.lianlianpay.global.ew.openapi.example.account.accounts;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.account.accounts.*;
import com.lianlianpay.global.ew.openapi.service.AccountService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

/**
 * @author huyl
 * @since 2024/12/19
 */
public class CoreAccountsExample extends AuthExample {

    private final AccountService accountService;

    public CoreAccountsExample() {
        this.accountService = new AccountService(oAuthClient("[access token]"));
    }

    /**
     * Create an account
     * @return
     */
    public void createAccount() {
        AccountCreateReq req = new AccountCreateReq();
        req.setEmail("huyl@lianlianpay.com");
        req.setCountryCode("HK");
        req.setEntityType("CORPORATE");
        req.setIdentifier("2024102400000001");
        req.setPhone("85212345678");
        req.setPhoneDistrict("HK");
        req.setAgreedToTermsAndConditions(true);
        Result<AccountDetailRes> result = this.accountService.createAccount(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve an account
     * @return
     */
    public void retrieveAccount() {
        //Retrieve account detail by current auth account
        Result<AccountDetailRes> result = this.accountService.retrieveAccount();
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Relate an associate account
     * @return
     */
    public void relateAssociateAccount() {
        AssociateAccountRelateReq req = new AssociateAccountRelateReq();
        req.setAccountId("[account id]");
        Result<AccountDetailRes> result = this.accountService.relateAssociateAccount(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Submit Corporate Account KYC
     * @return
     */
    public void submitCorporateAccountKyc() {
        CorporateAccountKycReq req = new CorporateAccountKycReq();
        CorporateBasicInfo corporateBasic = new CorporateBasicInfo();
        corporateBasic.setCorporateName("LGAS API 测试公司");
        corporateBasic.setCorporateNameEn("LGAS API TEST CO,LTD");
        corporateBasic.setEmail("lisi@lianlianpay.com");
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAddrCountry("HK");
        addressInfo.setState("浙江省");
        addressInfo.setCity("杭州市");
        addressInfo.setDistrict("滨江区");
        addressInfo.setAddressLineOne("越达巷79号");
        addressInfo.setPostalCode("310000");
        corporateBasic.setCompanyRegistrationAddress(addressInfo);
        corporateBasic.setCompanyOperationAddress(addressInfo);
        corporateBasic.setCompanyType("SELF_EMPLOYED");
        corporateBasic.setCompanyMonthlyRevenue("1000000");
        corporateBasic.setBusinessCategory_1("游戏");
        corporateBasic.setBusinessCategory_2("游戏数字娱乐");

        CorporateKycCertInfo certInfo = new CorporateKycCertInfo();
        certInfo.setCompanyDocCountry("HK");
        certInfo.setCompanyDocType("HK_Business_Registration_Ordinance");
        certInfo.setCompanyDocNumber("93323497D6CN5Q5D91");
        AttachmentInfo attachmentInfo = new AttachmentInfo();
        attachmentInfo.setFileId("e44fe5e25c7b4a618e7577432d341eb8");
        attachmentInfo.setAttachmentType("HK_Business_Registration_Ordinance");
        certInfo.setAttachments(Arrays.asList(attachmentInfo));
        corporateBasic.setCompanyDoc(Arrays.asList(certInfo));
        req.setCorporateBasic(corporateBasic);

        CorporateStaffBaseInfo staffBaseInfo = new CorporateStaffBaseInfo();
        staffBaseInfo.setCompanyMemberType("DIRECTOR");
        staffBaseInfo.setFullName("李四");
        staffBaseInfo.setFullNameEn("Li Si");
        staffBaseInfo.setBirthday(LocalDate.of(1989, 1, 1));
        staffBaseInfo.setNationality("HK");
        staffBaseInfo.setResidentialAddress(addressInfo);
        IndividualKycCertInfo individualDoc = new IndividualKycCertInfo();
        individualDoc.setIdCountry("HK");
        individualDoc.setCertType("HONGKONG_ID_CARD");
        individualDoc.setCertNo("33010319890101001X");

        AttachmentInfo attachmentInfo1 = new AttachmentInfo();
        attachmentInfo1.setFileId("e44fe5e25c7b4a618e7577432d341eb8");
        attachmentInfo1.setAttachmentType("HONGKONG_ID_CARD");
        individualDoc.setAttachments(Arrays.asList(attachmentInfo1));
        staffBaseInfo.setIndividualDoc(Arrays.asList(individualDoc));

        CorporateStaffBaseInfo staffBaseInfo1 = new CorporateStaffBaseInfo();
        staffBaseInfo1.setCompanyMemberType("UBO");
        staffBaseInfo1.setFullName("张三");
        staffBaseInfo1.setFullNameEn("Zhang San");
        staffBaseInfo1.setBirthday(LocalDate.of(1989, 1, 1));
        staffBaseInfo1.setNationality("HK");
        staffBaseInfo1.setResidentialAddress(addressInfo);
        IndividualKycCertInfo individualDoc1 = new IndividualKycCertInfo();
        individualDoc1.setIdCountry("HK");
        individualDoc1.setCertType("HONGKONG_ID_CARD");
        individualDoc1.setCertNo("330103198901010013");
        individualDoc1.setAttachments(Arrays.asList(attachmentInfo1));
        staffBaseInfo1.setIndividualDoc(Arrays.asList(individualDoc1));


        req.setCorporateMembers(Arrays.asList(staffBaseInfo, staffBaseInfo1));
        Result<AccountDetailRes> result = this.accountService.submitCorporateAccountKyc(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Submit Individual Account KYC
     * @return
     */
    public void submitIndividualAccountKyc() {
        IndividualKycReq req = new IndividualKycReq();
        IndividualBasicInfo individualBasic = new IndividualBasicInfo();
        individualBasic.setEmail("lisi@lianlianpay.com");
        individualBasic.setFullName("李四");
        individualBasic.setFullNameEn("Li Si");
        individualBasic.setFirstName("Si");
        individualBasic.setLastName("Li");
        individualBasic.setNationality("HK");
        individualBasic.setBirthday(LocalDate.of(1989, 1, 1));
        individualBasic.setPhone("85212345678");

        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAddrCountry("HK");
        addressInfo.setState("香港");
        addressInfo.setCity("九龙");
        addressInfo.setDistrict("油尖旺");
        addressInfo.setAddressLineOne("油尖旺道88号");
        addressInfo.setAttachment("[file id]");
        individualBasic.setResidentialAddress(addressInfo);
        individualBasic.setMonthlyIncome("50000");

        IndividualKycCertInfo individualDoc = new IndividualKycCertInfo();
        individualDoc.setIdCountry("HK");
        individualDoc.setCertType("PASSPORT");
        individualDoc.setCertNo("33010319890101001X");
        //upload file and create folder first, then pass the folder id
        AttachmentInfo attachmentInfo = new AttachmentInfo();
        attachmentInfo.setFileId("e44fe5e25c7b4a618e7577432d341eb8");
        attachmentInfo.setAttachmentType("PASSPORT");
        individualDoc.setAttachments(Arrays.asList(attachmentInfo));
        individualBasic.setIndividualDoc(Arrays.asList(individualDoc));
        req.setIndividualBasic(individualBasic);
        req.setRegion("HK");

        Result<AccountDetailRes> result = this.accountService.submitIndividualAccountKyc(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Authorize an account
     * @return
     */
    public void authorizeAccount() {
        AccountAuthorizeReq req = new AccountAuthorizeReq();
        req.setAccountId("[Account ID]");
        Result<AccountAuthorizeRes> result = this.accountService.authorizeAccount(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Retrieve interim info
     * @return
     */
    public void retrieveInterimInfo() {
        Result<AccountDetailRes> result = this.accountService.retrieveInterimInfo();
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }


    /**
     * Submit Corporate Interim KYC
     * @return
     */
    public void submitCorporateInterimKyc() {
        CorporateInterimKycReq req = new CorporateInterimKycReq();
        CorporateBasicInfo corporateBasic = new CorporateBasicInfo();
        corporateBasic.setCorporateName("LGAS API 测试公司");
        corporateBasic.setCorporateNameEn("LGAS API TEST CO,LTD");
        corporateBasic.setEmail("lisi@lianlianpay.com");
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAddrCountry("HK");
        addressInfo.setState("浙江省");
        addressInfo.setCity("杭州市");
        addressInfo.setDistrict("滨江区");
        addressInfo.setAddressLineOne("越达巷79号");
        addressInfo.setPostalCode("310000");
        corporateBasic.setCompanyRegistrationAddress(addressInfo);
        corporateBasic.setCompanyOperationAddress(addressInfo);
        corporateBasic.setCompanyType("SELF_EMPLOYED");
        corporateBasic.setCompanyMonthlyRevenue("1000000");
        corporateBasic.setBusinessCategory_1("游戏");
        corporateBasic.setBusinessCategory_2("游戏数字娱乐");

        CorporateKycCertInfo certInfo = new CorporateKycCertInfo();
        certInfo.setCompanyDocCountry("HK");
        certInfo.setCompanyDocType("HK_Business_Registration_Ordinance");
        certInfo.setCompanyDocNumber("93323497D6CN5Q5D91");
        AttachmentInfo attachmentInfo = new AttachmentInfo();
        attachmentInfo.setFileId("e44fe5e25c7b4a618e7577432d341eb8");
        attachmentInfo.setAttachmentType("HK_Business_Registration_Ordinance");
        certInfo.setAttachments(Arrays.asList(attachmentInfo));
        corporateBasic.setCompanyDoc(Arrays.asList(certInfo));
        req.setCorporateBasic(corporateBasic);

        CorporateStaffBaseInfo staffBaseInfo = new CorporateStaffBaseInfo();
        staffBaseInfo.setCompanyMemberType("DIRECTOR");
        staffBaseInfo.setFullName("李四");
        staffBaseInfo.setFullNameEn("Li Si");
        staffBaseInfo.setBirthday(LocalDate.of(1989, 1, 1));
        staffBaseInfo.setNationality("HK");
        staffBaseInfo.setResidentialAddress(addressInfo);
        IndividualKycCertInfo individualDoc = new IndividualKycCertInfo();
        individualDoc.setIdCountry("HK");
        individualDoc.setCertType("HONGKONG_ID_CARD");
        individualDoc.setCertNo("33010319890101001X");

        AttachmentInfo attachmentInfo1 = new AttachmentInfo();
        attachmentInfo1.setFileId("e44fe5e25c7b4a618e7577432d341eb8");
        attachmentInfo1.setAttachmentType("HONGKONG_ID_CARD");
        individualDoc.setAttachments(Arrays.asList(attachmentInfo1));
        staffBaseInfo.setIndividualDoc(Arrays.asList(individualDoc));

        CorporateStaffBaseInfo staffBaseInfo1 = new CorporateStaffBaseInfo();
        staffBaseInfo1.setCompanyMemberType("UBO");
        staffBaseInfo1.setFullName("张三");
        staffBaseInfo1.setFullNameEn("Zhang San");
        staffBaseInfo1.setBirthday(LocalDate.of(1989, 1, 1));
        staffBaseInfo1.setNationality("HK");
        staffBaseInfo1.setResidentialAddress(addressInfo);
        IndividualKycCertInfo individualDoc1 = new IndividualKycCertInfo();
        individualDoc1.setIdCountry("HK");
        individualDoc1.setCertType("HONGKONG_ID_CARD");
        individualDoc1.setCertNo("330103198901010013");
        individualDoc1.setAttachments(Arrays.asList(attachmentInfo1));
        staffBaseInfo1.setIndividualDoc(Arrays.asList(individualDoc1));

        req.setCorporateMembers(Arrays.asList(staffBaseInfo, staffBaseInfo1));

        Result<AccountDetailRes> result = this.accountService.submitCorporateInterimKyc(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }

    /**
     * Submit Individual Interim KYC
     * @return
     */
    public void submitIndividualInterimKyc() {
        IndividualInterimKycReq req = new IndividualInterimKycReq();
        IndividualBasicInfo individualBasic = new IndividualBasicInfo();
        individualBasic.setEmail("lisi@lianlianpay.com");
        individualBasic.setFullName("李四");
        individualBasic.setFullNameEn("Li Si");
        individualBasic.setFirstName("Si");
        individualBasic.setLastName("Li");
        individualBasic.setNationality("HK");
        individualBasic.setBirthday(LocalDate.of(1989, 1, 1));
        individualBasic.setPhone("85212345678");

        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAddrCountry("HK");
        addressInfo.setState("香港");
        addressInfo.setCity("九龙");
        addressInfo.setDistrict("油尖旺");
        addressInfo.setAddressLineOne("油尖旺道88号");
        addressInfo.setAttachment("[file id]");
        individualBasic.setResidentialAddress(addressInfo);
        individualBasic.setMonthlyIncome("50000");

        IndividualKycCertInfo individualDoc = new IndividualKycCertInfo();
        individualDoc.setIdCountry("HK");
        individualDoc.setCertType("PASSPORT");
        individualDoc.setCertNo("33010319890101001X");
        //upload file and create folder first, then pass the folder id
        AttachmentInfo attachmentInfo = new AttachmentInfo();
        attachmentInfo.setFileId("e44fe5e25c7b4a618e7577432d341eb8");
        attachmentInfo.setAttachmentType("PASSPORT");
        individualDoc.setAttachments(Arrays.asList(attachmentInfo));
        individualBasic.setIndividualDoc(Arrays.asList(individualDoc));
        req.setIndividualBasic(individualBasic);

        Result<AccountDetailRes> result = this.accountService.submitIndividualInterimKyc(req);
        if (result.isHttpOk()) {
            // do something when success
            System.out.println(result.getData());
        }
    }
}
