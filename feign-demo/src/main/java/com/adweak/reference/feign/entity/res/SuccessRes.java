package com.adweak.reference.feign.entity.res;

/**
 * @author : xuzhaole
 * @date : 2020/11/24
 */

public class SuccessRes extends BaseRes{
    private String desc;

    public SuccessRes() {}
    public SuccessRes(String desc) {
        super(0);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
