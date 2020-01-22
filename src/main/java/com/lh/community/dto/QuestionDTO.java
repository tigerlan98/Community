package com.lh.community.dto;

import com.lh.community.model.User;
import lombok.Data;

/**
 * @author lanhu
 * @create 2020-01-22 15:55
 */
@Data
public class QuestionDTO {
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
    private User user;
}
