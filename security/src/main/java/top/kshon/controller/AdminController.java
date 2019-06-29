package top.kshon.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminController {
    @RequestMapping("")
    public String admin(){
        return "admin"
;    }

@PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/article")
    public String article(HttpServletRequest request){
        return "article";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/user")
    public String user(HttpServletRequest request){
        return "user";
    }
}
