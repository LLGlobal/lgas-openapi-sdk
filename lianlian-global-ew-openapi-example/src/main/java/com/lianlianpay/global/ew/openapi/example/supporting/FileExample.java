package com.lianlianpay.global.ew.openapi.example.supporting;

import com.lianlianpay.global.ew.openapi.example.auth.AuthExample;
import com.lianlianpay.global.ew.openapi.http.Result;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.model.supporting.*;
import com.lianlianpay.global.ew.openapi.service.SupportingService;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

import java.io.*;
import java.util.Arrays;

/**
 * @author huyl
 * @since 2025/1/2
 */
public class FileExample extends AuthExample {

    private final SupportingService supportingService;

    public FileExample() {
        super();
        this.supportingService = new SupportingService(this.basicAuthClient());
    }

    /**
     * <h3>Upload a file</h3>
     * Upload a file to LianLian Global's server. The max size of an upload file is up to 10MB. When you upload a file, the API responds with a id. This id will be referenced as required as part of the File Folder object.
     * Allowed file types: application/x-rar-compressed application/zip application/pdf image/jpeg image/png
     * business_type is KYC. The zip rar file type is not supported.
     * Uploaded successfully. Need to add to folder. Only then can it be queried.
     * @return
     */
    public void uploadLocalFile() {
        File file = new File("D:\\test.txt");
        Result<FileUploadRes> result = supportingService.uploadFile(file, "KYC", "test");
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Upload a file</h3>
     * Upload a file to LianLian Global's server. The max size of an upload file is up to 10MB. When you upload a file,
     * the API responds with a id. This id will be referenced as required as part of the File Folder object.
     * Allowed file types: application/x-rar-compressed application/zip application/pdf image/jpeg image/png
     * business_type is KYC. The zip rar file type is not supported.
     * Uploaded successfully. Need to add to folder. Only then can it be queried.
     * @return
     */
    public void uploadFileStream() throws FileNotFoundException {
        String filePath = "D:\\test.txt";
        FileInputStream fis = new FileInputStream(filePath);

        Result<FileUploadRes> result = supportingService.uploadFile(fis, "test.txt", "KYC", "test");
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve all files</h3>
     * Retrieve all files uploaded to LianLian Global's server.
     * @return
     */
    public void retrieveAllFiles() {
        FilePageReq req = new FilePageReq();
        req.setPage(1);
        req.setPageSize(10);
        Result<PageResult<FileDetailRes>> result = supportingService.retrieveAllFiles(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Download a file</h3>
     * Download a file from LianLian Global's server.
     * @return
     */
    public void downloadFile() {
        FileDownloadReq req = new FileDownloadReq();
        req.setId("[file id]");
        Result<ResponseBody> result = supportingService.downloadFile(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            ResponseBody responseBody = result.getData();
            MediaType mediaType = responseBody.contentType();
            System.out.println(mediaType.type()+"/"+mediaType.subtype());
            System.out.println(responseBody.contentLength());

            try (FileOutputStream fos = new FileOutputStream("{your-file-root-path}/downloaded-file.txt")) {
                fos.write(responseBody.bytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    /**
     * <h3>Delete a file</h3>
     * Delete a file from LianLian Globals' server.
     * @return
     */
    public void deleteFile() {
        String id = "[file id]";
        Result<FileDeleteRes> result = supportingService.deleteFile(id);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }


    /**
     * <h3>Create a file folder</h3>
     * create a new File Folder with multiple File reference.
     * @return
     */
    public void createFileFolder() {
        FileFolderCreateReq req = new FileFolderCreateReq();
        req.setFileFolderName("test");
        req.setPurpose("kyc");
        req.setFileIds(Arrays.asList("[file id]"));
        Result<FileFolderDetailRes> result = supportingService.createFileFolder(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve all file folders</h3>
     * Retrieve all file folders uploaded to LianLian Global's server.
     * @return
     */
    public void retrieveAllFileFolders() {
        FileFolderPageReq req = new FileFolderPageReq();
        req.setPage(1);
        req.setPageSize(10);
        Result<PageResult<FileFolderRes>> result = supportingService.retrieveAllFileFolders(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Add files to a file folder</h3>
     * Add files to a file folder.
     * @return
     */
    public void folderAddFile() {
        FileFolderAddFileReq req = new FileFolderAddFileReq();
        req.setFileIds(Arrays.asList("[file id]"));
        req.setId("[file folder id]");
        Result<FileFolderDetailRes> result = supportingService.folderAddFile(req);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Delete a file from a file folder</h3>
     * Delete a file from a file folder.
     * @return
     */
    public void deleteFileFolder() {
        String fileFolderId = "[file folder id]";
        String fileId = "[file id]";
        Result<FileDeleteRes> result = supportingService.deleteFolderFile(fileFolderId, fileId);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Retrieve a file folder</h3>
     * Retrieve a file folder by id.
     * @return
     */
    public void retrieveFileFolder() {
        String id = "[file folder id]";
        Result<FileFolderDetailRes> result = supportingService.retrieveFileFolder(id);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }

    /**
     * <h3>Delete a file folder</h3>
     * Delete a file folder.
     * @return
     */
    public void deleteFileFolder1() {
        String id = "[file folder id]";
        Result<FileDeleteRes> result = supportingService.deleteFileFolder(id, true);
        if (result.isHttpOk()) {
            // do something when http status is 200
            System.out.println(result.getData());
        }
    }
}
