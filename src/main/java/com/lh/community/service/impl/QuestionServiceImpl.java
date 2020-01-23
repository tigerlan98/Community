package com.lh.community.service.impl;

import com.lh.community.dto.PaginationDTO;
import com.lh.community.dto.QuestionDTO;
import com.lh.community.mapper.QuestionMapper;
import com.lh.community.mapper.UserMapper;
import com.lh.community.model.Question;
import com.lh.community.model.User;
import com.lh.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanhu
 * @create 2020-01-22 15:59
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        int totalPage;
        Integer totalCount = questionMapper.totalCount();
        totalPage = totalCount % size == 0 ? totalCount / size : totalCount / size + 1;
        if (page<1){
            page = 1;
        }
        if (page > totalPage){
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage,page);

        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }

    @Override
    public PaginationDTO list(Integer userId,Integer page,Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        int totalPage;
        Integer totalCount = questionMapper.countByUserId(userId);
        totalPage = totalCount % size == 0 ? totalCount / size : totalCount / size + 1;
        if (page<1){
            page = 1;
        }
        if (page > totalPage){
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage,page);

        int offset = size * (page - 1);
        if (offset < 0){
            offset = 1;
        }

        List<Question> questions = questionMapper.listByUserId(userId,offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    @Override
    public QuestionDTO findById(String id) {
        Question question = questionMapper.getById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.findById(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }
}
