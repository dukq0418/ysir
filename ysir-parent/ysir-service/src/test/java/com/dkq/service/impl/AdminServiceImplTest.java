package com.dkq.service.impl;

import com.dkq.dao.AdminDao;
import com.dkq.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class AdminServiceImplTest {

    @Test
    public void login() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao = (AdminDao) classPathXmlApplicationContext.getBean("adminDao");

        List<Admin> login = adminDao.login(new Admin("jack", "123456"));
        for (Admin admin : login) {
            System.out.println(admin);
        }
    }
}
