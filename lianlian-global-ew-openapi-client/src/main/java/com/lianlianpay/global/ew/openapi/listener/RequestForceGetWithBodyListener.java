package com.lianlianpay.global.ew.openapi.listener;

import com.lianlianpay.global.ew.openapi.utils.HttpUtils;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Request;

/**
 * @author huyl
 * @since 2025/3/2
 */
public class RequestForceGetWithBodyListener extends EventListener {




    /**
     * Invoked immediately after sending request headers.
     *
     * <p>This method is always invoked after {@link #requestHeadersStart(Call)}.
     *
     * @param call
     * @param request the request sent over the network. It is an error to access the body of this
     *                request.
     */
    @Override
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        HttpUtils.byPassBodyPermits(request);
    }
}
