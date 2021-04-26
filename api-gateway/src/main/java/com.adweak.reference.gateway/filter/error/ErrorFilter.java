package com.adweak.reference.gateway.filter.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author : xuzhaole
 * @date : 2021/1/14
 */

@Component
public class ErrorFilter extends ZuulFilter {

    @Value("${order.error.ErrorFilter}")
    private int order;

    @Override
    public Object run() throws ZuulException {
        RequestContext rct = RequestContext.getCurrentContext();
        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
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
