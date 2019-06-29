package top.annakshon.library.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import top.annakshon.library.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    @Override
    List<User> findAll();

    @Override
    List<User> findAll(Sort sort);

    @Override
    <S extends User> S save(S s);

    @Override
    Optional<User> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void deleteById(Long aLong);

    @Override
    void deleteAll();
}
