package com.dkq.service.impl;

import com.dkq.dao.AdminDao;
import com.dkq.dao.VideoDao;
import com.dkq.pojo.Video;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class VideoServiceImplTest {
    @Test
    public void saveVideo() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        VideoDao videoDao = (VideoDao)classPathXmlApplicationContext.getBean("videoDao");

    }
}
