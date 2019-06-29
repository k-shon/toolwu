package top.annakshon.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import top.annakshon.library.dao.UserDao;
import top.annakshon.library.entity.User;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(s);
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}
