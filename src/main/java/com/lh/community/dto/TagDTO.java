package com.lh.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @author lanhu
 * @create 2020-01-25 22:05
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
