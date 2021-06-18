package com.adweak.reference.hibernate.constants;

/**
 * @author : xuzhaole
 * @date : 2020/11/23
 */

public enum ErrorCodes {

    SERVICE_ERROR(986500,"系统错误%s"),
    PARAM_EMPTY(986001,"请求参数为空%s"),
    PARAM_ERROR(986002,"请求参数不符合要求%s"),
    PARAM_REPEAT(986003,"保存或修改的参数重复%s"),
    OP_EXIST_FK(986004,"存在外键引用，不允许删除%s"),
    DATA_NOT_EXIST(986005,"数据不存在%s"),


    ;

    private int code;
    private String desc;
    private String desc1;

    private ErrorCodes(int code, String desc) {
        this.code = code;
        this.desc = desc;
        this.desc1 = desc;
    }

    public int value() {
        return this.code;
    }

    public String desc() {
        return String.format(this.desc, "！");
    }

    public String desc(String param) {
        return String.format(this.desc1, ": " + param);
    }

    public ErrorCodes getError(String param) {
        this.desc = String.format(this.desc1, param);
        return this;
    }
}
