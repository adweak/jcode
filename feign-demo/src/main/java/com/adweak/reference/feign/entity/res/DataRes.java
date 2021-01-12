package com.adweak.reference.feign.entity.res;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author : xuzhaole
 * @date : 2020/11/23
 */

public class DataRes<T> extends BaseRes {

    private T data;

    public DataRes(T data) {
        super();
        this.data = data;
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
