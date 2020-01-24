package com.lh.community.service;

import com.lh.community.dto.PaginationDTO;
import com.lh.community.dto.QuestionDTO;
import com.lh.community.model.Question;

/**
 * @author lanhu
 * @create 2020-01-22 15:56
 */
public interface QuestionService {
    PaginationDTO list(Integer page, Integer size);

    PaginationDTO list(Long userId,Integer page,Integer size);

    //根据id查询问题
    QuestionDTO findById(Long id);

    void createOrUpdate(Question question);

    void intView(Long id);
}
