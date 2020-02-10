package com.dkq.dao;

import com.dkq.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {

    public Integer insertUser(User user);

    public User loginUser(User user);

    public List<User> queryUser(String email);

    public Integer editByUser(User user);

    public User queryUserByEmail(String email);

    public List<User> queryUserByPassword(String password);
}
