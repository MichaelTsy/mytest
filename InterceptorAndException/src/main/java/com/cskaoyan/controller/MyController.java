package com.cskaoyan.controller;

import com.cskaoyan.bean.User;
import com.cskaoyan.exception.AccountTooShort;
import com.cskaoyan.exception.PwdTooShort;
import com.cskaoyan.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
@Controller
public class MyController {

    @Autowired
    MyService service;

    @RequestMapping(value = "/register",method =RequestMethod.GET )
    public String register(){
        return "/WEB-INF/register.jsp";
    }

    @RequestMapping(value = "/register",method =RequestMethod.POST)
    public String registerHandle(HttpServletRequest request,User user, MultipartFile headpic) throws IOException {

        boolean flag=service.register(user);
        if(flag) {
            HttpSession session=request.getSession();
            session.setAttribute("email",user.getEmail());
            return "redirect:/info";
        }else return "forward:/registerFailed";
    }

    @RequestMapping("/registerFailed")
    public void registerFailed(HttpServletResponse response){
        try {
            response.getWriter().println("此账户无法注册，请重新注册");
            response.setHeader("refresh","5;url=/register");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(){
        return "/WEB-INF/login.jsp";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String loginHandle(HttpServletRequest request,User user) throws PwdTooShort, AccountTooShort {
        //按题目3要求在service层该方法要抛两种异常
        boolean flag=service.login(user);

            HttpSession session=request.getSession();
            session.setAttribute("email",user.getEmail());
        System.out.println("111");
            return "redirect:/info";

    }


    @RequestMapping("/info")
    public String info(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String email=(String) session.getAttribute("email");
        model.addAttribute("email",email);
        return "/WEB-INF/info.jsp";
    }
}
