package com.dkq.controller;

import com.dkq.pojo.Admin;
import com.dkq.pojo.Subject;
import com.dkq.service.SubjectService;
import com.dkq.service.impl.AdminServiceImpl;
import com.dkq.service.impl.SubjectServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource(name = "adminService")
    private AdminServiceImpl adminService;
    @Resource(name = "subjectService")
    private SubjectService subjectService;
    /**
     * 到登录
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        return "behind/login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password, HttpSession session){
        Admin admin = new Admin(username, password);
        List<Admin> logins = adminService.login(admin);
        if(logins.get(0)!=null){
            session.setAttribute("username",username);
            return "success";
        }
        return "error";
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "redirect:/admin/toLogin";
    }

}
