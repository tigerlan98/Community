package com.lh.community.exception;

/**
 * @author lanhu
 * @create 2020-01-24 1:07
 */
public class CustomizeException extends RuntimeException {

    private Integer code;
    private String message;

    public CustomizeException(CustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
