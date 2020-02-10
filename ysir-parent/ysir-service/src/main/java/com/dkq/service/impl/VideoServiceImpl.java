package com.dkq.service.impl;

import com.dkq.dao.SpeakerDao;
import com.dkq.dao.VideoDao;
import com.dkq.pojo.QueryVo;
import com.dkq.pojo.Video;
import com.dkq.service.VideoService;
import com.dkq.utils.Page;
import jdk.nashorn.internal.runtime.Debug;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("videoService")
public class VideoServiceImpl implements VideoService {

    Logger logger = Logger.getLogger(VideoServiceImpl.class);
    @Resource(name = "videoDao")
    private VideoDao videoDao;
    @Resource(name = "speakerDao")
    private SpeakerDao speakerDao;
    @Override
    public Page<Video> queryVideoByQueryVo(QueryVo queryVo) {

        // 设置查询条件,从哪一条数据开始查
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());
        System.out.println(queryVo.getStart());
        // 查询数据结果集
        List<Video> list = videoDao.queryVideoByQueryVo(queryVo);
        // 查询到的数据总条数
        Integer total = videoDao.queryCountByQueryVo(queryVo);


        // 封装返回的page对象
        Page<Video> page = new Page<Video>();
        //查询数据
        page.setRows(list);
        //当前页
        page.setPage(queryVo.getPage());
        //每页数据
        page.setSize(queryVo.getRows());
        //总记录数
        page.setTotal(total);
        System.out.println(page);
        return page;
    }

    @Override
    public Video queryVideoMapById(Integer id) {
        return videoDao.queryVideoMapById(id);
    }

    @Override
    public Integer saveVideo(Video video) {
        return videoDao.saveVideo(video);
    }

    @Override
    public Integer updateVideo(Video video) {
        return videoDao.updateVideo(video);
    }

    @Override
    public Video queryVideoById(Integer id) {
        return videoDao.queryVideoById(id);
    }

    @Override
    public Integer videoDel(Integer id) {
        return videoDao.videoDel(id);
    }


}
