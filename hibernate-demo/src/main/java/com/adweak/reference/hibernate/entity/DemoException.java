package com.adweak.reference.hibernate.entity;

/**
 * @author : xuzhaole
 * @date : 2021/6/17
 */

public class DemoException extends RuntimeException {
    private static final long serialVersionUID = 3080116114822860675L;
    private Integer errorCode = 500;
    private String errorMsg = "Server Internal Error";

    public DemoException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public DemoException(Integer errorCode, String errorMsg, Throwable e) {
        super(errorMsg, e);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMessage() {
        return this.errorCode + "-" + super.getMessage();
    }

    public String getLocalizedMessage() {
        return this.errorCode + "-" + super.getLocalizedMessage();
    }
}
