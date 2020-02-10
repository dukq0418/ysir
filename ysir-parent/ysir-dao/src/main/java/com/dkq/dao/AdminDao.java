package com.dkq.dao;

import com.dkq.pojo.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminDao")
public interface AdminDao {

    public List<Admin> login(Admin admin);
}
