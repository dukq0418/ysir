package com.dkq.dao;

import com.dkq.pojo.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("subjectDao")
public interface SubjectDao {

    public List<Subject> querySubject();

    public Subject querySubjectById(Integer id);

    Subject querySubjectByCourse(Integer id);
}
