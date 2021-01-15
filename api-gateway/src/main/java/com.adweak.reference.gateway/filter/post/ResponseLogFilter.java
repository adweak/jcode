package com.adweak.reference.gateway.filter.post;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author : xuzhaole
 * @date : 2021/1/14
 */

public class ResponseLogFilter extends ZuulFilter {

    @Value("${order.post.ResponseLogFilter}")
    private int order;

    @Override
    public Object run() throws ZuulException {
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
