package com.lianlianpay.global.ew.openapi.interceptor;

import com.lianlianpay.global.ew.openapi.exception.SignatureException;
import com.lianlianpay.global.ew.openapi.utils.RSA;
import okhttp3.*;
import okio.Buffer;
import okio.BufferedSource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author huyl
 * @since 2024/12/10
 */
public class ResponseSignatureInterceptor implements Interceptor {

    private static final String SIGNATURE_HEADER = "LLPAY-Signature";

    private static final String SIGNATURE_CONCAT = "&";

    private static final long REQUEST_TIME_THRESHOLD = TimeUnit.MINUTES.toSeconds(10);



    private String lianlianPublicKey;

    private boolean checkSignStrict;

    public ResponseSignatureInterceptor(String lianlianPublicKey, boolean checkSignStrict) {
        this.lianlianPublicKey = lianlianPublicKey;
        this.checkSignStrict = checkSignStrict;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        String signatureStr = response.header(SIGNATURE_HEADER);
        if (this.checkSignStrict && signatureStr == null) {
            throw new SignatureException("Response Missing Signature.");
        }
        if (signatureStr == null) {
            return response;
        }
        checkSignature(signatureStr, response.body());

        return response;
    }

    private String fetchResponseBody(ResponseBody responseBody) throws IOException {
        if (responseBody != null) {
            MediaType responseBodyMediaType = responseBody.contentType();
            MediaType applicationJsonMediaType = MediaType.parse("application/json");
            if (!Objects.equals(applicationJsonMediaType.type(), responseBodyMediaType.type())
                    || !Objects.equals(applicationJsonMediaType.subtype(), responseBodyMediaType.subtype())) {
                return null;
            }
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE);
            Charset charset = responseBodyMediaType.charset();
            try (Buffer buffer = source.getBuffer().clone()) {
                return buffer.readString(charset);
            }

        }
        return null;
    }


    /**
     * 签名校验
     *
     * @return
     * @throws SignatureException
     */

    private void checkSignature(String signatureStr, ResponseBody responseBody) throws IOException {
        String responseBodyStr = fetchResponseBody(responseBody);
        if (responseBody == null) {
            return;
        }
        String[] arr = signatureStr.split(",");
        String responseEpoch = arr[0].substring("t=".length());
        String responseSign = arr[1].substring("v=".length());
        validEpoch(responseEpoch);
        boolean valid = RSA.verify(RSA.Mode.SHA256withRSA, responseEpoch + SIGNATURE_CONCAT + responseBodyStr, responseSign, RSA.getPublicKey(this.lianlianPublicKey));
        if (!valid) {
            throw new SignatureException("Invalid signature.");
        }
    }

    /**
     * epoch时间校验，与当前时间误差10分钟内
     * Epoch time verification, within 10 minutes from the current time.
     *
     * @param epoch
     * @return
     * @throws SignatureException
     */
    private static String validEpoch(String epoch) {
        try {
            long t = Long.parseLong(epoch);
            if (Math.abs(System.currentTimeMillis() / 1000 - t) > REQUEST_TIME_THRESHOLD) {
                throw new SignatureException("Invalid signature time.");
            }
            return epoch;
        } catch (Exception e) {
            throw new SignatureException("Invalid signature time.");
        }
    }
}
