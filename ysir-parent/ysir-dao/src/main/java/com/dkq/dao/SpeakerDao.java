package com.dkq.dao;

import com.dkq.pojo.QueryVo;
import com.dkq.pojo.Speaker;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("speakerDao")
public interface SpeakerDao {

    List<Speaker> querySpeaker(QueryVo queryVo);

    List<Speaker> queryAllSpeaker();

    Integer queryCount(QueryVo queryVo);

    Speaker querySpeakerById(Integer id);

    List<Speaker> querySpeakerNameById(Integer id);

    Integer saveSpeaker(Speaker speaker);

    Integer delSpeakerById(Integer id);

    Integer editSpeaker(Speaker speaker);



}
