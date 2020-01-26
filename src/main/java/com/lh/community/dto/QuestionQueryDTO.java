package com.lh.community.dto;

import lombok.Data;

/**
 * @author lanhu
 * @create 2020-01-26 21:55
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private Integer page;
    private Integer size;
}
