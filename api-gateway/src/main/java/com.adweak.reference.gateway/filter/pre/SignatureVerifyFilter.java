package com.adweak.reference.gateway.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : xuzhaole
 * @date : 2021/1/14
 */

public class SignatureVerifyFilter extends ZuulFilter {

    @Value("${order.pre.SignatureVerifyFilter}")
    private int order;

    @Value("${ignore.signature.button}")
    private boolean button;

    @Value("${ignore.signature.endpoints}")
    private String endpoints;

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
        if (!button) {
            return false;
        }
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        String reqUri = request.getRequestURI();
        String[] endpoints = this.endpoints.split(",");
        for (String endpoint : endpoints) {
            if (reqUri.contains(endpoint)) {
                return false;
            }
        }
        return true;
    }
}
