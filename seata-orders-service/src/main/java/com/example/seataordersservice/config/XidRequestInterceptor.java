package com.example.seataordersservice.config;

import io.netty.util.internal.StringUtil;
import io.seata.core.context.RootContext;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class XidRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept( HttpRequest request, byte[] body, ClientHttpRequestExecution execution ) throws
        IOException {
        String xid = RootContext.getXID();

        if (StringUtil.isNullOrEmpty(xid)) {
            return execution.execute(request, body);
        }

        HttpHeaders headers = request.getHeaders();
        headers.add(RootContext.KEY_XID, xid);

        return execution.execute(request, body);
    }
}
