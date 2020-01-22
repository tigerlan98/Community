package com.lh.community.dto;

import lombok.Data;

/**
 * @author lanhu
 * @create 2020-01-20 17:44
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
