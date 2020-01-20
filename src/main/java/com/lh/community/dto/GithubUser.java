package com.lh.community.dto;

/**
 * @author lanhu
 * @create 2020-01-20 17:44
 */
public class GithubUser {
    //
    private String name;
    private Long id;
    //
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
