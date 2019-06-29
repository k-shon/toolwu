package top.annakshon.library.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String code; //学号或教师号
    @Column(length = 20)
    private String phone;
    @Column(length = 50)
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createtime;

    public Person(String name, String code, String phone, String email, Date createtime) {
        this.name = name;
        this.code = code;
        this.phone = phone;
        this.email = email;
        this.createtime = createtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
