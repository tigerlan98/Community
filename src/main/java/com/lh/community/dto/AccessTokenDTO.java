package com.lh.community.dto;

import lombok.Data;

/**
 * @author lanhu
 * @create 2020-01-20 17:00
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
