package com.lh.community.dto;

import com.lh.community.model.User;
import lombok.Data;

/**
 * @author lanhu
 * @create 2020-01-25 13:56
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
