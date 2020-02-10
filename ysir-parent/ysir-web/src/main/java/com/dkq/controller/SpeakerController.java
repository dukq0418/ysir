package com.dkq.controller;

import com.dkq.pojo.QueryVo;
import com.dkq.pojo.Speaker;
import com.dkq.pojo.Video;
import com.dkq.service.SpeakerService;
import com.dkq.utils.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {

    @Resource(name = "speakerService")
    private SpeakerService speakerService;


    @RequestMapping("/showSpeakerList")
    public String showSpeakerList(Model model, QueryVo queryVo){
        Page<Speaker> page = speakerService.querySpeaker(queryVo);
        model.addAttribute("page",page);
        return "behind/speakerList";
    }

    @RequestMapping("/toAddSpeaker")
    public String toAddSpeaker(){
        return "behind/addSpeaker";
    }

    @RequestMapping("/edit")
    public String edit(Integer id, Model model){
        Speaker speaker = speakerService.querySpeakerById(id);
        model.addAttribute("speaker",speaker);
        return "behind/addSpeaker";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Speaker speaker){
        if(speaker.getId()!=null) {
            speakerService.editSpeaker(speaker);
        }else{
            speakerService.saveSpeaker(speaker);
        }
        return "redirect:/speaker/showSpeakerList";
    }

    @RequestMapping("/speakerDel")
    @ResponseBody
    public String speakerDel(Integer id){
        speakerService.delSpeakerById(id);
        return "success";
    }
}
