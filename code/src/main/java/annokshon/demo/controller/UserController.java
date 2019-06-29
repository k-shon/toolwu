package annokshon.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("/test")
    public String test(){
        return "succuess";
    }
    @RequestMapping("/hello")
    public String hello(ModelMap map,HttpServletRequest request) {
        map.put("thText", "th:text 设置文本内容 <b>加粗</b>");
        map.put("thUText", "th:utext 设置文本内容 <b>加粗</b>");
        map.put("thValue", "thValue 设置当前元素的value值");
        map.put("thEach", Arrays.asList("th:each", "遍历列表"));
        map.put("thIf", "msg is not null");
        HttpSession session = request.getSession();
        session.setAttribute("hello","kshon");

        return "hello";
    }

}
