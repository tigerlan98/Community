package com.lh.community.model;

import lombok.Data;

/**
 * @author lanhu
 * @create 2020-01-20 20:29
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
