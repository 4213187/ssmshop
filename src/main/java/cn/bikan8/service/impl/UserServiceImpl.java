package cn.bikan8.service.impl;



import cn.bikan8.entity.User;
import cn.bikan8.mapper.UserMapper;
import cn.bikan8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public  UserServiceImpl(){

    }
    public  UserServiceImpl(UserMapper userMapper){
      this.userMapper =userMapper;
    }
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public void resetPassword(User user) {
        userMapper.update(user);
    }

    @Override
    public void updateInfo(User user) {
        userMapper.update(user);
    }
}
