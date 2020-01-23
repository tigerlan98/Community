package com.lh.community.exception;

/**
 * @author lanhu
 * @create 2020-01-24 1:07
 */
public class CustomizeException extends RuntimeException {

    private String message;

    public CustomizeException(CustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
