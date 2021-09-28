package com.jz.controller.login;

import com.jz.mapper.user.UserMapper;
import com.jz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/toLogin.action")
    public String toLogin(Model model) {
        return "login";
    }

    @PostMapping("/login.action")
    public String login(Model model, HttpServletRequest request,String userName, String userPassword) {
        User loginUser = userMapper.login(userName,userPassword);
        if (userName.equals(loginUser.getUserName()) && userPassword.equals(loginUser.getUserPassword())) {
            request.getSession().setAttribute("user",loginUser);
            return "redirect:/order/findUnfinshedOrder.action";
        } else {
            model.addAttribute("error","账户或密码错误");
            return "login";
        }

    }
}
