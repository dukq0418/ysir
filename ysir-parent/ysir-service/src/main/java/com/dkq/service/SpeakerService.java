package com.dkq.service;

import com.dkq.pojo.QueryVo;
import com.dkq.pojo.Speaker;
import com.dkq.utils.Page;

import java.util.List;

public interface SpeakerService {

    Page<Speaker> querySpeaker(QueryVo queryVo);

    List<Speaker> queryAllSpeaker();

    List<Speaker> querySpeakerNameById(Integer id);

    Integer saveSpeaker (Speaker speaker);

    Integer delSpeakerById(Integer id);

    Integer editSpeaker(Speaker speaker);

    Speaker querySpeakerById(Integer id);
}
