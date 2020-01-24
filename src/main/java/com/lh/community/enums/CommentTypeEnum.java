package com.lh.community.enums;

/**
 * @author lanhu
 * @create 2020-01-24 15:46
 */
public enum CommentTypeEnum {

    QUESTION(1),
    COMMENT(2);
    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if (value.getType().equals(type)){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {

        return type;
    }
}
