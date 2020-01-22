package com.lh.community.model;

import lombok.Data;

/**
 * @author lanhu
 * @create 2020-01-21 23:24
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
