package com.lh.community.mapper;

import com.lh.community.model.Comment;
import com.lh.community.model.CommentExample;
import com.lh.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}