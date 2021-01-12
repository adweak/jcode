package com.adweak.reference.feign.constants;

/**
 * @author : xuzhaole
 * @date : 2020/11/23
 */

public enum ErrorCodes {

    CLIENT_ERROR(100,"Client Call failed !"),



    ;

    private int code;
    private String desc;

    private ErrorCodes(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int value() {
        return this.code;
    }
    public String desc() {
        return this.desc;
    }
}
