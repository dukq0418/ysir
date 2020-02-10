package com.dkq.service;

import com.dkq.pojo.Course;
import com.dkq.pojo.QueryVo;
import com.dkq.utils.Page;

import java.util.List;


public interface CourseService {

    List<Course> queryAllCourse();

    Page<Course> queryCourseQueryVo(QueryVo queryVo);

    Course queryCourseById(Integer id);

    Integer saveCourse(Course course);

    Integer courseDel(Integer id);

    Integer editCourse(Course course);

    Course queryCourseVideoByCid(Integer cid);

}
