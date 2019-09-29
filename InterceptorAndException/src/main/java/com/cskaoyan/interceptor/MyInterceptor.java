package com.cskaoyan.interceptor;

import com.cskaoyan.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MyInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //访问注册与登录相关页面，直接放行
        int login = request.getRequestURI().indexOf("/login");
        int register = request.getRequestURI().indexOf("/register");
        if(login!=-1||register!=-1) return true;
        //其他情况用session取数据判定是否已登录
        HttpSession session = request.getSession();
        /*User user = (User) session.getAttribute("user");
        if(user==null) {
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }*/
        String email=(String)session.getAttribute("email") ;
        if (email == null) {
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
