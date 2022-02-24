package com.example.seatabusinessservice.config;

import io.netty.util.internal.StringUtil;
import io.seata.core.context.RootContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Deprecated // This Interceptor is currently not in used status.
@Component
public class SeataHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String xid = RootContext.getXID();

        System.out.println("###xid: " + xid);

        String rpcXid = request.getHeader("TX_XID");
        System.out.println("###rpcXid: " + rpcXid);

        if (StringUtil.isNullOrEmpty(xid) && rpcXid != null) {
            RootContext.bind(rpcXid);
        }

        return true;
    }
}
