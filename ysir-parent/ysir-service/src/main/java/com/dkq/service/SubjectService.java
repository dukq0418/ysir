package com.dkq.service;

import com.dkq.dao.SubjectDao;
import com.dkq.pojo.Subject;

import javax.annotation.Resource;
import java.util.List;

public interface SubjectService {

    public List<Subject> querySubject();

    public Subject querySubjectById(Integer id);

    Subject querySubjectByCourse(Integer id);
}
