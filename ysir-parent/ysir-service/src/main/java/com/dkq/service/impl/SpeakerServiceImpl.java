package com.dkq.service.impl;

import com.dkq.dao.SpeakerDao;
import com.dkq.pojo.QueryVo;
import com.dkq.pojo.Speaker;
import com.dkq.service.SpeakerService;
import com.dkq.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {

    @Resource(name = "speakerDao")
    private SpeakerDao speakerDao;


    @Override
    public Page<Speaker> querySpeaker(QueryVo queryVo) {
        /**
         * 设置开始查询的数据,从那一条开始查
         */
        queryVo.setStart((queryVo.getPage()-1) * queryVo.getRows());
        /**
         *  查询数据结果集
         */
        List<Speaker> speakerList = speakerDao.querySpeaker(queryVo);
        /**
         * 查询总条数
         */
        Integer total = speakerDao.queryCount(queryVo);

        /**
         * 封装返回的page对象
         */
        Page<Speaker> speakerPage = new Page<Speaker>();
        //查询数据
        speakerPage.setRows(speakerList);
        //当前页
        speakerPage.setPage(queryVo.getPage());
        //每页数据
        speakerPage.setSize(queryVo.getRows());
        //设置总记录数
        speakerPage.setTotal(total);

        return speakerPage;
    }

    //无条件查询所有讲师
    @Override
    public List<Speaker> queryAllSpeaker() {
        return speakerDao.queryAllSpeaker();
    }


    @Override
    public List<Speaker> querySpeakerNameById(Integer id) {
        return speakerDao.querySpeakerNameById(id);
    }

    @Override
    public Integer saveSpeaker(Speaker speaker) {
        return speakerDao.saveSpeaker(speaker);
    }

    @Override
    public Integer delSpeakerById(Integer id) {
        return speakerDao.delSpeakerById(id);
    }

    @Override
    public Integer editSpeaker(Speaker speaker) {
        return speakerDao.editSpeaker(speaker);
    }

    @Override
    public Speaker querySpeakerById(Integer id) {
        return speakerDao.querySpeakerById(id);
    }
}
