package cn.bikan8.mapper;

import cn.bikan8.entity.User;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface UserMapper {
    List<User> findAll();
    void update(User user);
    User findById(int id);
}
