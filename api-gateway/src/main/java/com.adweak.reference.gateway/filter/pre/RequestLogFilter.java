package com.adweak.reference.gateway.filter.pre;

import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.StreamUtils;

import javax.activation.MimeType;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
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
public class RequestLogFilter extends ZuulFilter {

    @Value("${order.pre.RequestLogFilter}")
    private int order;

    @Override
    public Object run() throws ZuulException {
        try {
            RequestContext rct = RequestContext.getCurrentContext();
            rct.set(START_TIME, System.currentTimeMillis());
            rct.set(LOG_ID, RandomStringUtils.randomNumeric(8));

            HttpServletRequest request = rct.getRequest();
            String requestMethod = request.getMethod();

            if (requestMethod.equalsIgnoreCase(Http.HttpMethod.GET.toString())) {
                log.info("Log-id:{}, Receive New GET Request, path:{}, params:{} ",
                        rct.get(LOG_ID), request.getRequestURI(), request.getQueryString());
            } else if (requestMethod.equalsIgnoreCase(Http.HttpMethod.POST.toString())) {
                String contentType = request.getContentType();
                if (contentType != null && contentType.contains(MimeTypeUtils.APPLICATION_JSON_VALUE)) {
                    InputStream in = (InputStream) rct.get(FilterConstants.REQUEST_ENTITY_KEY);
                    if (in == null) {
                        in = rct.getRequest().getInputStream();
                    }
                    String requestBody = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
                    log.info("Log-id:{}, Receive New POST Request, ContentType:{}, path:{}, params:{}",
                            rct.get(LOG_ID), contentType, request.getRequestURI(), URLDecoder.decode(requestBody, "UTF-8"));
                } else {
                    log.info("Log-id:{}, Receive New POST Request, ContentType:{}, path:{}",
                            rct.get(LOG_ID), contentType, request.getRequestURI());
                }
            } else {
                log.info("Log-id:{}, Receive New {} Request, path:{}",
                        rct.get(LOG_ID), requestMethod, request.getRequestURI());
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new ZuulException(e.getMessage(), SYS_ERROR.value(), SYS_ERROR.desc());
        }
        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
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
