package top.kshon.service;

import org.springframework.data.jpa.repository.JpaRepository;
import top.kshon.entity.User;

/*
数据访问接口
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
