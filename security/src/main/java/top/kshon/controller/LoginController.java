package top.kshon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("")
    public String login(){
        return "login";
    }
    @RequestMapping("/form")
    public String form(@RequestParam("username")String username,@RequestParam("password")String password,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("isLogin",true);
        System.out.println("用户名："+username);
        System.out.println("密码 ："+password);
        return "admin";
    }
}
