package top.annakshon.library.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import top.annakshon.library.service.MyUserDetailsService;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private Log log = LogFactory.getLog("mySecurity");
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("安全访问机制生效");
        auth.userDetailsService(myUserDetailsService).passwordEncoder(myPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/*","/js/*","index").permitAll() //访问无权限
                .antMatchers("/admin/**").hasRole("ADMIN") //需要admin权限
                .and()
                .formLogin()
                .loginPage("/login").permitAll() //登陆页面
                .and()
                .logout().permitAll(); //注销
    }
}
