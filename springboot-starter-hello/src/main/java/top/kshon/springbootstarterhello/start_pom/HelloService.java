package top.kshon.springbootstarterhello.start_pom;

public class HelloService {
    public String sayHello(){
        return "谢苏琴"+msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;
}
