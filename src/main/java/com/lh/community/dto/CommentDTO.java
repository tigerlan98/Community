package com.lh.community.dto;

import lombok.Data;

/**
 * @author lanhu
 * @create 2020-01-24 15:16
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
