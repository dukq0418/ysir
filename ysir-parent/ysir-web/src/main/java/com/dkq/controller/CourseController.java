package com.dkq.controller;

import com.dkq.pojo.Course;
import com.dkq.pojo.QueryVo;
import com.dkq.pojo.Subject;
import com.dkq.service.CourseService;
import com.dkq.service.SubjectService;
import com.dkq.utils.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Resource(name = "courseService")
    private CourseService courseService;
    @Resource(name = "subjectService")
    private SubjectService subjectService;

    @RequestMapping("/showCourseList")
    public String showCourseList(QueryVo queryVo, Model model){
        Page<Course> page = courseService.queryCourseQueryVo(queryVo);
        model.addAttribute("page",page);
        return "behind/courseList";
    }

    @RequestMapping("/addCourse")
    public String addCourse(Model model,@Param("subject_id") Integer id){
        List<Subject> subjectList = subjectService.querySubject();
        model.addAttribute("subjectList",subjectList);
        return "behind/addCourse";
    }


    @RequestMapping("/edit")
    public String edit(Integer id,Model model){
        List<Subject> subjectList = subjectService.querySubject();
        Subject subject = subjectService.querySubjectById(id);
        Course course = courseService.queryCourseById(id);
        model.addAttribute("subjectList",subjectList);
        model.addAttribute("course",course);
        model.addAttribute("subject",subject);

        return "behind/addCourse";
    }

    @RequestMapping("/courseDel")
    @ResponseBody
    public String courseDel(Integer id){
        System.out.println(id);
        Integer integer = courseService.courseDel(id);
        System.out.println(integer);
        return "success";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Course course){
        if(course.getId()!=null) {
            courseService.editCourse(course);
        }else{
            courseService.saveCourse(course);
        }
        return "redirect:/course/showCourseList";
    }

    @RequestMapping("/course/{id}")
    public String course(@PathVariable(name = "id") Integer id, Model model, HttpSession session){
        Subject subject = subjectService.querySubjectByCourse(id);
        session.setAttribute("cid",id);
        model.addAttribute("subject",subject);
        return "before/course";
    }



}
