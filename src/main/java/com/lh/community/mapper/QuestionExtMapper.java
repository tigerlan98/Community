package com.lh.community.mapper;

import com.lh.community.model.Question;
import com.lh.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    int intView(Question record);
    int incComment(Question record);
    List<Question> selectRelated(Question question);
}