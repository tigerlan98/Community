package com.lh.community.exception;

/**
 * @author lanhu
 * @create 2020-01-24 1:17
 */
public enum CustomizeErrorCodeImpl implements CustomizeErrorCode {

    QUESTION_NOT_FOUND("您找的问题不在了,要不要换一个试试?");

    private String message;

    CustomizeErrorCodeImpl(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
