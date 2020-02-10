package com.dkq.controller;

import com.dkq.pojo.User;
import com.dkq.service.UserService;
import com.dkq.utils.ImageCut;
import com.dkq.utils.MailUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;


    /**
     * 忘记密码页面跳转登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "before/index";
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/loginOut2")
    public String loginOut2(HttpSession session){
        session.invalidate();
        return "before/index";
    }

    /**
     * 注册账户验证
     * @param email
     * @param session
     * @return
     */
    @RequestMapping("/validateEmail")
    @ResponseBody
    public String validateEmail( String email, HttpSession session){
        List<User> users = userService.queryUser(email);
        if (users.size()!=0){
            return "error";
        }
        return "success";
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(User user){
        userService.insertUser(user);
        return "success";
    }

    /**
     * 登录页面
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/loginUser")
    @ResponseBody
    public String loginUser(User user, HttpSession session){
        User user1 = userService.loginUser(user);
        if(user1!=null){
            session.setAttribute("user",user);
            session.setAttribute("userAccount",user1.getEmail());
            return "success";
        }
        return "error";
    }

    /**
     * 展示个人信息页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/showMyProfile")
    public String showMyProfile(HttpSession session , Model model){
        String email = (String) session.getAttribute("userAccount");
        User user = userService.queryUserByEmail(email);
        model.addAttribute("user",user);
        return "before/my_profile";
    }

    /**
     * 跳转忘记密码页面
     * @return
     */
    @RequestMapping("/forgetPassword")
    public String forgetPassword(){
        return "before/forget_password";
    }

    /**
     * 验证邮箱信息
     * @param email
     * @param session
     * @return
     */
    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(String email, HttpSession session){
        session.setAttribute("email", email);
        MailUtils.sendMail(email,"测试消息不用管",MailUtils.getValidateCode(6));
        return "success";
    }

    /**
     * 跳转到重置密码
     * @return
     */
    @RequestMapping("/validateEmailCode")
    public String validateEmailCode(){
        return "before/reset_password";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("/resetPassword")
    public String resetPassword(User user,HttpSession session){
        String email = (String) session.getAttribute("email");
        session.setAttribute("userAccount",user.getEmail());
        userService.editByUser(user);
        return "before/index";
    }

    /**
     * 跳转到更改资料页面
     * @return
     */
    @RequestMapping("/changeProfile")
    public String changeProfile(Model model,HttpSession session){
        String email = (String) session.getAttribute("userAccount");
        User user = userService.queryUserByEmail(email);
        model.addAttribute("user",user);
        return "before/change_profile";
    }

    /**
     * 更改资料
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user,Model model,HttpSession session){
        String email = (String) session.getAttribute("userAccount");
        user.setEmail(email);
        userService.editByUser(user);
        return "redirect:/user/showMyProfile";
    }

    /**
     * 跳转到更改头像
     * @return
     */
    @RequestMapping("/changeAvatar")
    public String changeAvatar(Model model,HttpSession session){
        String email = (String) session.getAttribute("userAccount");
        User user = userService.queryUserByEmail(email);
        model.addAttribute("user",user);
        return "before/change_avatar";
    }

    /**
     * 更改头像
     * @return
     */
    @RequestMapping("/upLoadImage")
    public String upLoadImage(MultipartFile image_file,User user,HttpSession session,double x1,double x2, double y1, double y2) throws Exception{
        ImageCut imageCut = new ImageCut();
        String email = (String) session.getAttribute("userAccount");
        //获取上传路径
        String path = "D:\\tomcat\\apache-tomcat-9.0.24\\webapps\\images";
        File file = new File(path);
        //获取上传文件名字
        String fileName = image_file.getOriginalFilename();
        System.out.println(fileName);
        //拼接文件名字
        String imgUrl = UUID.randomUUID().toString() + fileName;
        //完成文件上传
        image_file.transferTo(new File(path,imgUrl));
//        if(StringUtils.isNoneEmpty(x1) ||
//                StringUtils.isNoneEmpty(x2) ||
//                StringUtils.isNoneEmpty(y1) ||
//                StringUtils.isNoneEmpty(y2) ) {

            imageCut.cutImage(path + "\\" + imgUrl, (int)x1, (int)y1, (int)x2, (int)y2);
//        }
        user.setImgUrl(imgUrl);
        user.setEmail(email);
        userService.editByUser(user);
        return "redirect:/user/showMyProfile";
    }

    /**
     * 密码安全
     * @return
     */
    @RequestMapping("/passwordSafe")
    public String passwordSafe(Model model,HttpSession session){
        String email = (String) session.getAttribute("userAccount");
        User user = userService.queryUserByEmail(email);
        model.addAttribute("user",user);
        return "before/password_safe";
    }

    /**
     * 验证密码
     * @return
     */
    @RequestMapping("/validatePassword")
    @ResponseBody
    public String validatePassword(String password,Model model){
        List<User> userList = userService.queryUserByPassword(password);
        if(userList.size()!=0){
            return "success";
        }
        return "error";
    }
    /**
     * 修改密码
     * @return
     */
    @RequestMapping("/updatePassword")
    public String updatePassword(@Param("newPassword") String newPassword,User user){
        user.setPassword("newPassword");
        userService.editByUser(user);
        return "redirect:/user/showMyProfile";
    }

}

