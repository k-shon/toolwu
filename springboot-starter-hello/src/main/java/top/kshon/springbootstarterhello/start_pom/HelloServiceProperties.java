package top.kshon.springbootstarterhello.start_pom;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg = "love you";  //默认的配置值

}
