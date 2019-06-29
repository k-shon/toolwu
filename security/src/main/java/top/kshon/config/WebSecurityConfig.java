package top.kshon.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import top.kshon.service.MyUserDetailService;

@Configuration
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    Log log = LogFactory.getLog("MySecurity:");
    @Bean
    UserDetailsService customUserService() {
        return new MyUserDetailService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("Spring Security生效");
        auth.userDetailsService(customUserService())
        .passwordEncoder(new MyPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**","/js/**","index").permitAll()   //访问无限制
                .and()
                .formLogin()
                .loginProcessingUrl("/login/form")    //需要跟登录页面表单的action同名
                .loginPage("/login").permitAll()  //登录页面
                .and()
                .logout().permitAll();  //注销
    }
}
