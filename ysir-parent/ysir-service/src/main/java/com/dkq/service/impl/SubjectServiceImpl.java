package com.dkq.service.impl;

import com.dkq.dao.SubjectDao;
import com.dkq.pojo.Subject;
import com.dkq.service.SubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

    @Resource(name = "subjectDao")
    private SubjectDao subjectDao;

    @Override
    public List<Subject> querySubject() {
        return subjectDao.querySubject();
    }

    @Override
    public Subject querySubjectById(Integer id) {
        return subjectDao.querySubjectById(id);
    }

    @Override
    public Subject querySubjectByCourse(Integer id) {
        return subjectDao.querySubjectByCourse(id);
    }
}
