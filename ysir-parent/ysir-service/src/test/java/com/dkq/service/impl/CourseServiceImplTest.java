package com.dkq.service.impl;

import com.dkq.dao.AdminDao;
import com.dkq.dao.CourseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class CourseServiceImplTest {

    @Test
    public void courseDel() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseDao courseDao = (CourseDao) classPathXmlApplicationContext.getBean("courseDao");
        Integer integer = courseDao.courseDel(14);
        System.out.println(integer);
    }
}
