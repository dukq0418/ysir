package com.dkq.dao;

import com.dkq.pojo.QueryVo;
import com.dkq.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("videoDao")
public interface VideoDao {

    List<Video> queryVideoByQueryVo(QueryVo queryVo);

    Video queryVideoMapById(Integer id);

    Integer queryCountByQueryVo(QueryVo queryVo);

    Integer saveVideo(Video video);

    Integer updateVideo(Video video);

    Video queryVideoById(Integer id);

    Integer videoDel(Integer id);
}
