package com.lh.community.service;

import com.lh.community.dto.CommentDTO;
import com.lh.community.enums.CommentTypeEnum;
import com.lh.community.model.Comment;

import java.util.List;

/**
 * @author lanhu
 * @create 2020-01-24 15:48
 */
public interface CommentService {

    void insert(Comment comment);

    List<CommentDTO> listByTargetId(Long id, CommentTypeEnum type);
}
