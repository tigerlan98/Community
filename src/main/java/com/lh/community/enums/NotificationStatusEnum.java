package com.lh.community.enums;

/**
 * @author lanhu
 * @create 2020-01-26 2:08
 */
public enum  NotificationStatusEnum {
    UNREAD(0),READ(1);
    private int status;

    NotificationStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
