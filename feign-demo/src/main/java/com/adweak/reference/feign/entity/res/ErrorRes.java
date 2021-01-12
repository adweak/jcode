package com.adweak.reference.feign.entity.res;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author : xuzhaole
 * @date : 2020/11/23
 */

public class ErrorRes extends BaseRes{

    private int errorCode;
    private String errorDesc;

    public ErrorRes() {
    }
    public ErrorRes(int errorCode, String errorDesc) {
        super(1);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }
    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
