package com.adweak.reference.gateway.filter.post;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.adweak.reference.gateway.constants.CommonConstants.LOG_ID;
import static com.adweak.reference.gateway.constants.CommonConstants.START_TIME;
import static com.adweak.reference.gateway.constants.ErrorCode.SYS_ERROR;

/**
 * @author : xuzhaole
 * @date : 2021/1/14
 */

@Slf4j
@Component
public class ResponseLogFilter extends ZuulFilter {

    @Value("${order.post.ResponseLogFilter}")
    private int order;

    @Override
    public Object run() throws ZuulException {
        RequestContext rct = RequestContext.getCurrentContext();
        HttpServletRequest request = rct.getRequest();
        InputStream responseDataStream = rct.getResponseDataStream();
        int responseCode = rct.getResponseStatusCode();
        try {
            String responseAsString = StreamUtils.copyToString(responseDataStream, StandardCharsets.UTF_8);
            if (responseAsString.length() < 1) {
                responseAsString = rct.getResponseBody();
            }
            long consumeTime = System.currentTimeMillis() - Long.parseLong(rct.get(START_TIME).toString());
            log.info("Log-id:{}, Consume:{} for Request:{}, Response Code Is:{}, Body Is:{}",
                    rct.get(LOG_ID), consumeTime, request.getRequestURI(), responseCode, responseAsString);


        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new ZuulException(e.getMessage(), SYS_ERROR.value(), SYS_ERROR.desc());
        }
        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return order;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
}
