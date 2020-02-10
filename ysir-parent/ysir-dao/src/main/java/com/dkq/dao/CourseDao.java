package com.dkq.dao;

import com.dkq.pojo.Course;
import com.dkq.pojo.QueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseDao")
public interface CourseDao {

    public List<Course> queryAllCourse();

    public List<Course> queryCourseQueryVo(QueryVo queryVo);

    Course queryCourseById(Integer id);

    Integer queryCountByQueryVo(QueryVo queryVo);

    Integer saveCourse(Course course);

    Integer courseDel(Integer id);

    Integer editCourse(Course course);

    Course queryCourseVideoByCid(Integer cid);

}
