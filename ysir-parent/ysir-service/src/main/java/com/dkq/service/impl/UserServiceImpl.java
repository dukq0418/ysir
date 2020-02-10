package com.dkq.service.impl;

import com.dkq.dao.UserDao;
import com.dkq.pojo.User;
import com.dkq.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User loginUser(User user) {
        return userDao.loginUser(user);
    }

    @Override
    public List<User> queryUser(String email) {
        return userDao.queryUser(email);
    }

    @Override
    public Integer editByUser(User user) {
        return userDao.editByUser(user);
    }

    @Override
    public User queryUserByEmail(String email) {
        return userDao.queryUserByEmail(email);
    }

    @Override
    public List<User> queryUserByPassword(String password) {
        return userDao.queryUserByPassword(password);
    }


}
