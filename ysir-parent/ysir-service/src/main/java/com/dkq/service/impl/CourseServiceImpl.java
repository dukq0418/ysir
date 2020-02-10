package com.dkq.service.impl;

import com.dkq.dao.CourseDao;
import com.dkq.pojo.Course;
import com.dkq.pojo.QueryVo;
import com.dkq.service.CourseService;
import com.dkq.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Resource(name="courseDao")
    private CourseDao courseDao;

    @Override
    public List<Course> queryAllCourse() {
        return courseDao.queryAllCourse();
    }

    @Override
    public Page<Course> queryCourseQueryVo(QueryVo queryVo) {
        // 设置查询条件,从哪一条数据开始查
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

        // 查询数据结果集
        List<Course> list = courseDao.queryCourseQueryVo(queryVo);
        // 查询到的数据总条数
        Integer total = courseDao.queryCountByQueryVo(queryVo);

        // 封装返回的page对象
        Page<Course> coursePage = new Page<Course>();
        //查询数据
        coursePage.setRows(list);
        //当前页
        coursePage.setPage(queryVo.getPage());
        //每页数据
        coursePage.setSize(queryVo.getRows());
        //总记录数
        coursePage.setTotal(total);

        return coursePage;
    }

    @Override
    public Course queryCourseById(Integer id) {
        return courseDao.queryCourseById(id);
    }

    @Override
    public Integer saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public Integer courseDel(Integer id) {
        return courseDao.courseDel(id);
    }

    @Override
    public Integer editCourse(Course course) {
        return courseDao.editCourse(course);
    }

    @Override
    public Course queryCourseVideoByCid(Integer cid) {
        return courseDao.queryCourseVideoByCid(cid);
    }

}
