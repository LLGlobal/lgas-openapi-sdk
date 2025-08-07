package com.lianlianpay.global.ew.openapi.service;

import com.lianlianpay.global.ew.openapi.api.supporting.BankAccountVerificationApi;
import com.lianlianpay.global.ew.openapi.api.supporting.FileApi;
import com.lianlianpay.global.ew.openapi.api.supporting.TransactionDocumentApi;
import com.lianlianpay.global.ew.openapi.client.Client;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.model.supporting.*;
import okhttp3.*;

import java.io.*;
import java.nio.file.Files;

/**
 * @author huyl
 * @since 2024/12/17
 */
public class SupportingService {

    /**
     * Client
     */
    private final Client client;

    /**
     * File API
     */
    private final FileApi fileApi;

    /**
     * Transaction Document API
     */
    private final TransactionDocumentApi transactionDocumentApi;

    /**
     * Bank Account Verification API
     */
    private final BankAccountVerificationApi bankAccountVerificationApi;
    
    public SupportingService(Client client) {
        this.client = client;
        this.fileApi = this.client.create(FileApi.class);
        this.transactionDocumentApi = this.client.create(TransactionDocumentApi.class);
        this.bankAccountVerificationApi = this.client.create(BankAccountVerificationApi.class);
    }


    /**
     * <h3>Upload a file</h3>
     * Upload a file to LianLian Global's server. The max size of an upload file is up to 10MB. When you upload a file,
     * the API responds with a id. This id will be referenced as required as part of the File Folder object.
     * Allowed file types: application/x-rar-compressed application/zip application/pdf image/jpeg image/png
     * business_type is KYC. The zip rar file type is not supported.
     * Uploaded successfully. Need to add to folder. Only then can it be queried.
     * @param file Local File, A maximum of 10 MB files are supported. Empty files are not allowed.
     * @param businessType The business type of the uploaded file.Upload KYC file, this value is required. eg: PAYOUT PAYEE KYC
     * @param notes The notes of the File, max length is 128 characters.
     * @return
     */
    public Result<FileUploadRes> uploadFile(File file, String businessType, String notes) {
        String contentType = probeContentType(file);
        RequestBody fileBody = RequestBody.create(MediaType.parse(contentType), file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), fileBody);
        RequestBody businessTypePart = RequestBody.create(MediaType.parse("text/plain"), businessType);
        RequestBody notesPart = RequestBody.create(MediaType.parse("text/plain"), notes);
        return this.client.execute(fileApi.uploadFile(filePart, businessTypePart, notesPart));
    }

    /**
     * <h3>Upload a file</h3>
     * Upload a file to LianLian Global's server. The max size of an upload file is up to 10MB. When you upload a file,
     * the API responds with a id. This id will be referenced as required as part of the File Folder object.
     * Allowed file types: application/x-rar-compressed application/zip application/pdf image/jpeg image/png
     * business_type is KYC. The zip rar file type is not supported.
     * Uploaded successfully. Need to add to folder. Only then can it be queried.
     * @param file File stream, A maximum of 10 MB files are supported. Empty files are not allowed.
     * @param businessType The business type of the uploaded file.Upload KYC file, this value is required. eg: PAYOUT PAYEE KYC
     * @param notes The notes of the File, max length is 128 characters.
     * @return
     */
    public Result<FileUploadRes> uploadFile(InputStream file, String filename, String businessType, String notes) {
        RequestBody fileBody = createRequestBody(file, MediaType.parse("application/octet-stream"));
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", filename, fileBody);
        RequestBody businessTypePart = RequestBody.create(MediaType.parse("text/plain"), businessType);
        RequestBody notesPart = RequestBody.create(MediaType.parse("text/plain"), notes);
        return this.client.execute(fileApi.uploadFile(filePart, businessTypePart, notesPart));
    }

    /**
     * <h3>Retrieve all files</h3>
     * Retrieve all files uploaded to LianLian Global's server.
     * @param req
     * @return
     */
    public Result<PageResult<FileDetailRes>> retrieveAllFiles(FilePageReq req) {
        return this.client.execute(fileApi.retrieveAllFiles(req));
    }

    /**
     * <h3>Download a file</h3>
     * Download a file from LianLian Global's server.
     * @param req
     * @return
     */
    public Result<ResponseBody> downloadFile(FileDownloadReq req) {
        return this.client.execute(fileApi.downloadFile(req));
    }

    /**
     * <h3>Delete a file</h3>
     * Delete a file from LianLian Globals' server.
     * @param id
     * @return
     */
    public Result<FileDeleteRes> deleteFile(String id) {
        return this.client.execute(fileApi.deleteFile(id));
    }


    /**
     * <h3>Create a file folder</h3>
     * create a new File Folder with multiple File reference.
     * @param req
     * @return
     */
    public Result<FileFolderDetailRes> createFileFolder(FileFolderCreateReq req) {
        return this.client.execute(fileApi.createFileFolder(req));
    }

    /**
     * <h3>Retrieve all file folders</h3>
     * Retrieve all file folders uploaded to LianLian Global's server.
     * @param req
     * @return
     */
    public Result<PageResult<FileFolderRes>> retrieveAllFileFolders(FileFolderPageReq req) {
        return this.client.execute(fileApi.retrieveAllFileFolders(req));
    }

    /**
     * <h3>Add files to a file folder</h3>
     * Add files to a file folder.
     * @param req
     * @return
     */
    public Result<FileFolderDetailRes> folderAddFile(FileFolderAddFileReq req) {
        return this.client.execute(fileApi.folderAddFile(req));
    }

    /**
     * <h3>Delete a file from a file folder</h3>
     * Delete a file from a file folder.
     * @param fileFolderId
     * @param fileId
     * @return
     */
    public Result<FileDeleteRes> deleteFolderFile(String fileFolderId, String fileId) {
        return this.client.execute(fileApi.deleteFolderFile(fileFolderId, fileId));
    }

    /**
     * <h3>Retrieve a file folder</h3>
     * Retrieve a file folder by id.
     * @param id file folder id
     * @return
     */
    public Result<FileFolderDetailRes> retrieveFileFolder(String id) {
        return this.client.execute(fileApi.retrieveFileFolder(id));
    }

    /**
     * <h3>Delete a file folder</h3>
     * Delete a file folder.
     * @param id file folder id
     * @param deleteFile Whether to delete the files in the file folder.
     * @return
     */
    public Result<FileDeleteRes> deleteFileFolder(String id, Boolean deleteFile) {
        return this.client.execute(fileApi.deleteFileFolder(id, deleteFile));
    }

    /**
     * <h3>Create transaction document</h3>
     * Create a transaction document.
     * @param req
     * @return
     */
    public Result<TransactionDocumentCreateRes> createTransactionDocument(TransactionDocumentCreateReq req) {
        return this.client.execute(transactionDocumentApi.createTransactionDocument(req));
    }

    /**
     * <h3>Update transaction document</h3>
     * Update transaction document.
     * @param req
     * @return
     */
    public Result<TransactionDocumentUpdateRes> updateTransactionDocument(TransactionDocumentUpdateReq req) {
        return this.client.execute(transactionDocumentApi.updateTransactionDocument(req));
    }

    /**
     * <h3>Retrieve transaction document</h3>
     * Retrieve transaction document by requestId.
     * @param requestId
     * @return
     */
    public Result<TransactionDocumentDetailRes> retrieveTransactionDocument(String requestId) {
        return this.client.execute(transactionDocumentApi.retrieveTransactionDocument(requestId));
    }

    /**
     * <h3>Retrieve all transaction documents</h3>
     * Retrieve all transaction documents.
     * @param req
     * @return
     */
    public Result<PageResult<TransactionDocumentDetailRes>> retrieveAllTransactionDocuments(TransactionDocumentPageReq req) {
        return this.client.execute(transactionDocumentApi.retrieveAllTransactionDocuments(req));
    }

    /**
     * <h3>Get quota</h3>
     * Get quota by ID.
     * @param req
     * @return
     */
    public Result<TransactionDocumentQuotaRes> getTransactionDocumentQuota(TransactionDocumentQuotaQueryReq req) {
        return this.client.execute(transactionDocumentApi.getTransactionDocumentQuota(req));
    }


    /**
     * Verify a bank account
     * @param req
     * @return
     */
    public Result<BankAccountVerifyRes> verifyBankAccount(BankAccountVerifyReq req) {
        return this.client.execute(bankAccountVerificationApi.verifyBankAccount(req));
    }


    /**
     * Validate verification.
     * @param req
     * @return
     */
    public Result<BankAccountVerifyDetailRes> validateBankAccountVerification(BankAccountVerificationValidateReq req) {
        return this.client.execute(bankAccountVerificationApi.validateBankAccountVerification(req));
    }


    /**
     * Retrieve a bank account verification
     * @param requestId
     * @return
     */
    public Result<BankAccountVerifyDetailRes> retrieveBankAccountVerification(String requestId) {
        return this.client.execute(bankAccountVerificationApi.retrieveBankAccountVerification(requestId));
    }


    /**
     * Retrieve all bank account verifications
     * @param req
     * @return
     */
    public Result<PageResult<BankAccountVerifyDetailRes>> retrieveAllBankAccountVerification(BankAccountVerificationPageReq req) {
        return this.client.execute(bankAccountVerificationApi.retrieveAllBankAccountVerification(req));
    }


    /**
     * Refresh accessToken
     * @param accessToken
     * @return
     */
    public SupportingService accessToken(String accessToken) {
        this.client.getConfiguration().setAccessToken(accessToken);
        return this;
    }

    /**
     * Create RequestBody
     * @param inputStream
     * @param mediaType
     * @return
     */
    private static RequestBody createRequestBody(InputStream inputStream, MediaType mediaType) {
        try (InputStream bufferedInputStream = new BufferedInputStream(inputStream);
             ByteArrayOutputStream byteStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = bufferedInputStream.read(buffer)) != -1) {
                byteStream.write(buffer, 0, length);
            }
            byte[] bytes = byteStream.toByteArray();
            return RequestBody.create(mediaType, bytes);
        } catch (IOException e) {
            throw new RuntimeException("Error reading input stream", e);
        }
    }


    private static String probeContentType(File file) {
        String contentType;
        try {
            contentType = Files.probeContentType(file.toPath());
        } catch (IOException e) {
            contentType = "application/octet-stream";
        }
        return contentType;
    }

}
