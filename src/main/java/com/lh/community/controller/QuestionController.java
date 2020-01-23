package com.lh.community.controller;

import com.lh.community.dto.QuestionDTO;
import com.lh.community.mapper.QuestionMapper;
import com.lh.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lanhu
 * @create 2020-01-23 19:11
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String showQuestion(@PathVariable String id, Model model){
        QuestionDTO questionDTO = questionService.findById(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
