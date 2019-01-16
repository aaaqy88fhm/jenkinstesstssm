package com.aaa.ssm.service;

import com.aaa.ssm.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:NewsServiceImpl
 * discription:
 * author:fhm
 * createTime:2018-11-20 18:56
 */
@Service
public class NewsServiceImpl implements NewsService {
    //依赖注入
    @Autowired
    private NewsDao newsDao;

    @Override
    public List<Map> getPage(Map map) {
        int pageNo=map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize=map.get("pageSize")==null?5:Integer.valueOf(map.get("pageSize")+"");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return newsDao.getPage(map);
    }

    @Override
    public int getPageCount(Map map) {
        return newsDao.getPageCount(map);
    }

    @Override
    public int add(Map map) {
        return newsDao.add(map);
    }

    @Override
    public int update(Map map) {
        return newsDao.update(map);
    }

    @Override
    public int delete(int newsid) {
        return newsDao.delete(newsid);
    }

    @Override
    public Map getById(int newsid) {
        return newsDao.getById(newsid);
    }
}
