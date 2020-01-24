package com.lh.community.service.impl;

import com.lh.community.dto.PaginationDTO;
import com.lh.community.dto.QuestionDTO;
import com.lh.community.exception.CustomizeErrorCode;
import com.lh.community.exception.CustomizeErrorCodeImpl;
import com.lh.community.exception.CustomizeException;
import com.lh.community.mapper.QuestionExtMapper;
import com.lh.community.mapper.QuestionMapper;
import com.lh.community.mapper.UserMapper;
import com.lh.community.model.Question;
import com.lh.community.model.QuestionExample;
import com.lh.community.model.User;
import com.lh.community.service.QuestionService;
import org.apache.ibatis.session.RowBounds;
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

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Override
    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        int totalPage;
        Integer totalCount = (int)questionMapper.countByExample(new QuestionExample());
        totalPage = totalCount % size == 0 ? totalCount / size : totalCount / size + 1;
        if (page<1){
            page = 1;
        }
        if (page > totalPage){
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage,page);

        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, size));
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }

    @Override
    public PaginationDTO list(Long userId,Integer page,Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        int totalPage;
        QuestionExample example = new QuestionExample();
        example.createCriteria().andCreatorEqualTo(userId);
        Integer totalCount = (int)questionMapper.countByExample(example);
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

        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andCreatorEqualTo(userId);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(questionExample, new RowBounds(offset, size));

        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    @Override
    public QuestionDTO findById(Long id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question == null){
            throw new CustomizeException(CustomizeErrorCodeImpl.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    @Override
    public void createOrUpdate(Question question) {
        if (question.getId() == null){
            //创建
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            question.setViewCount(0);
            question.setLikeCount(0);
            question.setCommentCount(0);
            questionMapper.insert(question);
        }else {
            //更新
            Question record = new Question();
            record.setGmtModified(System.currentTimeMillis());
            record.setTitle(question.getTitle());
            record.setDescription(question.getDescription());
            record.setTag(question.getTag());
            QuestionExample example = new QuestionExample();
            example.createCriteria().andIdEqualTo(question.getId());
            int i = questionMapper.updateByExampleSelective(record, example);
            if (i != 1) {
                throw new CustomizeException(CustomizeErrorCodeImpl.QUESTION_NOT_FOUND);
            }
        }
    }

    @Override
    public void intView(Long id) {
        Question question = new Question();
        question.setId(id);
        question.setViewCount(1);
        questionExtMapper.intView(question);
    }
}
