package com.adweak.reference.gateway.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author : xuzhaole
 * @date : 2021/1/14
 */

public class RequestLogFilter extends ZuulFilter {

    @Value("${order.error.RequestLogFilter}")
    private int order;

    @Override
    public Object run() throws ZuulException {
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
