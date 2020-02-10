package com.dkq.service;

import com.dkq.pojo.User;

import java.util.List;

public interface UserService {

    public Integer insertUser(User user);

    public User loginUser(User user);

    public List<User> queryUser(String email);

    public Integer editByUser(User user);

    public User queryUserByEmail(String email);

    public List<User> queryUserByPassword(String password);

}
