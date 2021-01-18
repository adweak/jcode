package com.adweak.reference.gateway.constants;

public enum ErrorCode {

    SYS_ERROR(100500, "System Error"),

    ;

    private int code;
    private String desc;
    private String desc1;

    ErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
        this.desc1 = desc;
    }

    public int value() {
        return this.code;
    }
    public String desc() {
        return this.desc;
    }
    public String desc(String param) {
        return String.format(this.desc1, param);
    }
    public ErrorCode getError(String param) {
        this.desc = String.format(this.desc1, param);
        return this;
    }

}
