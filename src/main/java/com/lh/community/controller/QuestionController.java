package com.lh.community.controller;

import com.lh.community.dto.CommentCreateDTO;
import com.lh.community.dto.CommentDTO;
import com.lh.community.dto.QuestionDTO;
import com.lh.community.service.CommentService;
import com.lh.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author lanhu
 * @create 2020-01-23 19:11
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String showQuestion(@PathVariable Long id, Model model){
        QuestionDTO questionDTO = questionService.findById(id);
        List<CommentDTO> comments =  commentService.listByQuestionId(id);
        //累计阅读数
        questionService.intView(id);
        model.addAttribute("question",questionDTO);
        model.addAttribute("comments",comments);
        return "question";
    }
}
