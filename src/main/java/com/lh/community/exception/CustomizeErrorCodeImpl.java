package com.lh.community.exception;

/**
 * @author lanhu
 * @create 2020-01-24 1:17
 */
public enum CustomizeErrorCodeImpl implements CustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"您找的问题不在了,要不要换一个试试?"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题和评论进行回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试"),
    SYSTEM_ERROR(2004,"服务冒烟了，请稍后试试!!!"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "回复的评论不存在了，要不要换个试试？"),
    CONTENT_IS_EMPTY(2007, "输入内容不能为空"),
    READ_NOTIFICATION_FAIL(2008, "兄弟你这是读别人的信息呢？"),
    NOTIFICATION_NOT_FOUND(2009, "消息莫非是不翼而飞了？"),
    FILE_UPLOAD_FAIL(2010, "图片上传失败"),
    INVALID_INPUT(2011, "非法输入"),
    INVALID_OPERATION(2012, "兄弟，是不是走错房间了？");

    private Integer code;
    private String message;

    CustomizeErrorCodeImpl(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
