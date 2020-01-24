package com.lh.community.advice;

import com.alibaba.fastjson.JSON;
import com.lh.community.dto.ResultDTO;
import com.lh.community.exception.CustomizeErrorCode;
import com.lh.community.exception.CustomizeErrorCodeImpl;
import com.lh.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lanhu
 * @create 2020-01-24 0:43
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(HttpServletRequest request, Throwable ex, Model model, HttpServletResponse response){

        String contentType = request.getContentType();
        if ("application/json".equals(contentType)) {
            ResultDTO resultDTO;
            // 返回 JSON
            if (ex instanceof CustomizeException) {
                resultDTO = ResultDTO.errorOf((CustomizeException) ex);
            } else {
                resultDTO = ResultDTO.errorOf(CustomizeErrorCodeImpl.SYSTEM_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException ioe) {
            }
            return null;
        }else {
            //错误页面跳转
            if (ex instanceof CustomizeException){
                model.addAttribute("message",ex.getMessage());
            }else{
                model.addAttribute("message",CustomizeErrorCodeImpl.SYSTEM_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }

}
