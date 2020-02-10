package com.dkq.controller;

import com.dkq.pojo.Subject;
import com.dkq.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Resource(name = "subjectService")
    private SubjectService subjectService;

    @RequestMapping("/queryAll")
    public String queryAll(Model model, HttpSession session){
        List<Subject> subjectList = subjectService.querySubject();
        session.setAttribute("subjectList",subjectList);
        return "before/index";
    }

}
