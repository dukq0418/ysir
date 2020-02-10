package com.dkq.service;

import com.dkq.pojo.QueryVo;
import com.dkq.pojo.Video;
import com.dkq.utils.Page;

import java.util.List;


public interface VideoService {
    public Page<Video> queryVideoByQueryVo(QueryVo queryVo);

    Video queryVideoMapById(Integer id);

    Integer saveVideo(Video video);

    Integer updateVideo(Video video);

    Video queryVideoById(Integer id);

    Integer videoDel (Integer id);
}
