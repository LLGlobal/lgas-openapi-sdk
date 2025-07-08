package com.lianlianpay.global.ew.openapi.api.supporting;

import com.lianlianpay.global.ew.openapi.http.SpecialMethod;
import com.lianlianpay.global.ew.openapi.model.common.PageResult;
import com.lianlianpay.global.ew.openapi.model.supporting.*;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.*;

/**
 * Files
 * This is an object representing a File witch stored on LianLian Globals servers.
 * @author huyl
 * @since 2024/11/25
 */
public interface FileApi {

    /**
     * <h3>Upload a file</h3>
     * Upload a file to LianLian Global's server. The max size of an upload file is up to 10MB. When you upload a file, the API responds with a id. This id will be referenced as required as part of the File Folder object.
     * Allowed file types: application/x-rar-compressed application/zip application/pdf image/jpeg image/png
     * business_type is KYC. The zip rar file type is not supported.
     * Uploaded successfully. Need to add to folder. Only then can it be queried.
     * @param file File stream, A maximum of 10 MB files are supported. Empty files are not allowed.
     * @param businessType The business type of the uploaded file.Upload KYC file, this value is required. eg: PAYOUT PAYEE KYC
     * @param notes The notes of the File, max length is 128 characters.
     * @return
     */
    @Multipart
    @POST("/api/v1/files/upload")
    Single<FileUploadRes> uploadFile(@Part MultipartBody.Part file, @Part("business_type") RequestBody businessType, @Part("notes") RequestBody notes);

    /**
     * <h3>Retrieve all files</h3>
     * Retrieve all files uploaded to LianLian Global's server.
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path = "/gateway/v1/ew-files", hasBody = true)
    Single<PageResult<FileDetailRes>> retrieveAllFiles(@Body FilePageReq req);

    /**
     * <h3>Download a file</h3>
     * Download a file from LianLian Global's server.
     * @param req
     * @return
     */
    @POST("/api/v1/files/download")
    Single<ResponseBody> downloadFile(@Body FileDownloadReq req);

    /**
     * <h3>Delete a file</h3>
     * Delete a file from LianLian Globals' server.
     * @param id
     * @return
     */
    @DELETE("/gateway/v1/file/{id}")
    Single<FileDeleteRes> deleteFile(@Path("id") String id);


    /**
     * <h3>Create a file folder</h3>
     * create a new File Folder with multiple File reference.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-folders")
    Single<FileFolderDetailRes> createFileFolder(@Body FileFolderCreateReq req);

    /**
     * <h3>Retrieve all file folders</h3>
     * Retrieve all file folders uploaded to LianLian Global's server.
     * @param req
     * @return
     */
    @HTTP(method = SpecialMethod.FORCE_GET_WITH_BODY, path = "/gateway/v1/ew-folders", hasBody = true)
    Single<PageResult<FileFolderRes>> retrieveAllFileFolders(@Body FileFolderPageReq req);

    /**
     * <h3>Add files to a file folder</h3>
     * Add files to a file folder.
     * @param req
     * @return
     */
    @POST("/gateway/v1/ew-folders/file")
    Single<FileFolderDetailRes> folderAddFile(@Body FileFolderAddFileReq req);

    /**
     * <h3>Delete a file from a file folder</h3>
     * Delete a file from a file folder.
     * @param fileFolderId
     * @param fileId
     * @return
     */
    @DELETE("/gateway/v1/ew-folders/file")
    Single<FileDeleteRes> deleteFolderFile(@Query("file_folder_id") String fileFolderId, @Query("file_id") String fileId);

    /**
     * <h3>Retrieve a file folder</h3>
     * Retrieve a file folder by id.
     * @param id file folder id
     * @return
     */
    @GET("/gateway/v1/ew-folders/{id}")
    Single<FileFolderDetailRes> retrieveFileFolder(@Path("id") String id);

    /**
     * <h3>Delete a file folder</h3>
     * Delete a file folder.
     * @param id file folder id
     * @param deleteFile Whether to delete the files in the file folder.
     * @return
     */
    @DELETE("/gateway/v1/ew-folders/{id}")
    Single<FileDeleteRes> deleteFileFolder(@Path("id") String id, @Query("delete_file") Boolean deleteFile);

}
