package com.adweak.reference.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author : xuzhaole
 * @date : 2020/11/23
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataRes<T> {
    private int resultCode;
    private T data;

    public DataRes() {
        this.resultCode = 0;
    }
    public DataRes(int resultCode) {
        this.resultCode = resultCode;
    }
    public DataRes(T data) {
        this.resultCode = 0;
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
