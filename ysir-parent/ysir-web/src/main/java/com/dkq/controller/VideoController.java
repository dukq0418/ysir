package com.dkq.controller;

import com.dkq.pojo.Course;
import com.dkq.pojo.QueryVo;
import com.dkq.pojo.Speaker;
import com.dkq.pojo.Video;
import com.dkq.service.CourseService;
import com.dkq.service.SpeakerService;
import com.dkq.service.VideoService;
import com.dkq.utils.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Resource(name="speakerService")
    private SpeakerService speakerService;
    @Resource(name = "videoService")
    private VideoService videoService;
    @Resource(name = "courseService")
    private CourseService courseService;

    @RequestMapping("/list")
    public String list(QueryVo queryVo, Model model){
        Page<Video> page = videoService.queryVideoByQueryVo(queryVo);
        List<Speaker> speakerList = speakerService.queryAllSpeaker();
        List<Course> courseList = courseService.queryAllCourse();
        model.addAttribute("queryVo",queryVo);
        model.addAttribute("speakerList",speakerList);
        model.addAttribute("courseList",courseList);
        model.addAttribute("page",page);

        //数据回显
        model.addAttribute("title",queryVo.getTitle());
        model.addAttribute("speakerId",queryVo.getSpeakerId());
        model.addAttribute("courseId",queryVo.getCourseId());

        return "behind/videoList";
    }

    @RequestMapping("/addVideo")
    public String addVideo(Model model){
        List<Speaker> speakerList = speakerService.queryAllSpeaker();
        List<Course> courseList = courseService.queryAllCourse();
        model.addAttribute("speakerList",speakerList);
        model.addAttribute("courseList",courseList);
        return "behind/addVideo";
    }

    @RequestMapping("/edit")
    public String edit(Model model,Integer id){
        Video video = videoService.queryVideoById(id);
        System.out.println(video);
        Speaker speaker = speakerService.querySpeakerById(id);
        List<Speaker> speakerList = speakerService.queryAllSpeaker();
        List<Course> courseList = courseService.queryAllCourse();
        model.addAttribute("speakerList",speakerList);
        model.addAttribute("courseList",courseList);
        model.addAttribute("video",video);
        model.addAttribute("speaker",speaker);
        return "behind/addVideo";
    }

    @RequestMapping("/videoDel")
    @ResponseBody
    public String videoDel(Integer id){
        videoService.videoDel(id);
        return "success";
    }


    @RequestMapping("/delBatchVideos")
    public String delBatchVideos(Integer[] ids){
        for (int i = 0;i<ids.length;i++){
            videoService.videoDel(ids[i]);
        }
        return "redirect:/video/list";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Video video){
        if(video.getId()!=null) {
            videoService.updateVideo(video);
        }else{
            videoService.saveVideo(video);
        }
        return "redirect:/video/list";
    }

    @RequestMapping("/showVideo")
    public String showVideo(@Param("id") Integer id, @Param("subject_name")String subject_name, @Param("cid") Integer cid, Model model){
        System.out.println(cid);
        Video video = videoService.queryVideoMapById(id);
        Course course = courseService.queryCourseVideoByCid(cid);
        model.addAttribute("subject_name",subject_name);
        model.addAttribute("video",video);
        model.addAttribute("course",course);
        return "before/section";
    }

}
