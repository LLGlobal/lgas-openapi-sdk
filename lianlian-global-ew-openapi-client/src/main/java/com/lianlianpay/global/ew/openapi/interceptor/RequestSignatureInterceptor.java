package com.lianlianpay.global.ew.openapi.interceptor;

import com.lianlianpay.global.ew.openapi.exception.CipherException;
import com.lianlianpay.global.ew.openapi.utils.RSA;
import okhttp3.*;
import okio.Buffer;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * @author huyl
 * @since 2024/12/9
 */
public class RequestSignatureInterceptor implements Interceptor {

    private static final String SIGNATURE_HEADER = "LLPAY-Signature";

    private static final String SIGNATURE_SEPARATOR = "&";

    private String privateKey;

    public RequestSignatureInterceptor(String privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String method = request.method();
        String uri = request.url().uri().getRawPath();
        String requestBody = getRequestBody(request.body());
        String encodedQuery = request.url().encodedQuery();
        String sign = generateSign(uri, method, requestBody, encodedQuery, privateKey);
        request = request.newBuilder()
                .header(SIGNATURE_HEADER, sign)
                .build();
        return chain.proceed(request);
    }

    private String getRequestBody(RequestBody requestBody) throws IOException {
        if (requestBody == null) {
            return "";
        }
        MediaType contentType = requestBody.contentType();
        MediaType applicationJsonMediaType = MediaType.parse("application/json");
        if (!Objects.equals(applicationJsonMediaType.type(), contentType.type())
                || !Objects.equals(applicationJsonMediaType.subtype(), contentType.subtype())) {
            return "";
        }

        final Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        Charset charset = contentType.charset();
        return buffer.readString(charset);
    }

    /**
     * get sign to invoke LianLian Global API
     *
     * @param realUri
     * @param apiMethod
     * @param requestPayload
     * @param privateKey
     * @return
     */
    public static String generateSign(String realUri, String apiMethod, String requestPayload, String queryString, String privateKey) {
        long epoch = System.currentTimeMillis() / 1000;
        StringBuilder sBuilder = new StringBuilder(apiMethod);
        sBuilder
                .append(SIGNATURE_SEPARATOR)
                .append(realUri)
                .append(SIGNATURE_SEPARATOR)
                .append(epoch)
                .append(SIGNATURE_SEPARATOR)
                .append(requestPayload);
        if (queryString != null) {
            sBuilder.append(SIGNATURE_SEPARATOR).append(URLEncoder.encode(queryString));
        }
        try {
            String sign = RSA.sign(RSA.Mode.SHA256withRSA, sBuilder.toString(), privateKey);
            return String.format("t=%s,v=%s", epoch, sign);
        } catch (CipherException e) {

        }
        return sBuilder.toString();
    }
}
