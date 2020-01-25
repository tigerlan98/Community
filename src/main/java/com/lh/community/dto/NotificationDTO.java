package com.lh.community.dto;

import lombok.Data;

/**
 * @author lanhu
 * @create 2020-01-26 2:23
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}
