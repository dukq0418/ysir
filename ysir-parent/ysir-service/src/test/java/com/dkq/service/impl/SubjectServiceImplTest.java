package com.dkq.service.impl;

import com.dkq.dao.SubjectDao;
import com.dkq.dao.VideoDao;
import com.dkq.pojo.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class SubjectServiceImplTest {

    @Test
    public void querySubjectByCourse() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectDao subjectDao = (SubjectDao)classPathXmlApplicationContext.getBean("subjectDao");
        Subject subjects = subjectDao.querySubjectByCourse(10);
    }
}
