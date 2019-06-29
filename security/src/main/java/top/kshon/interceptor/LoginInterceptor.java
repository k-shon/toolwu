package top.kshon.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    Log log = LogFactory.getLog("MyInterceptor:");
    /*处理请求前调用*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器生效");
        HttpSession session = request.getSession();
        Object isLogin = session.getAttribute("isLogin");
        log.info("是否已登录:"+isLogin);
        if (isLogin!=null && (boolean)isLogin){
            return true;
        }else {
            response.sendRedirect("/login");
        }
        return false;
    }

    /*处理请求后，视图渲染前调用(controller方法调用之后)*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("拦截器正在处理....");
    }

    /*视图渲染后调用*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("拦截器结束");
    }
}
