package top.annakshon.library.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String username;
    @Column(length = 20)
    private String password;
    private boolean status;  //用户状态：激活、冻结
    private Person person; //个人信息
    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<Role> roles; //角色表
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createtime;

    public User(String username, String password, boolean status, Person person, Date createtime) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.person = person;
        this.createtime = createtime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public Long getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }

    public Date getCreatetime() {
        return createtime;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities  = new ArrayList<>();
        List<Role> roleList = this.roles;
        for (Role role:roleList){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
