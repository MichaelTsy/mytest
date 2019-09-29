package com.cskaoyan.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyExceptionHandler implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof AccountTooShort) {
            modelAndView.addObject("userMsg", ((AccountTooShort) e).getUserMsg());
        } else if (e instanceof PwdTooShort) {
            modelAndView.addObject("userMsg", ((PwdTooShort) e).getUserMsg());
        }else modelAndView.addObject("userMsg","出现异常");
        modelAndView.setViewName("/WEB-INF/error.jsp");
        return modelAndView;
    }
}
