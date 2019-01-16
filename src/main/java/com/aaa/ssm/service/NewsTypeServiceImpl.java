package com.aaa.ssm.service;

import com.aaa.ssm.dao.NewsTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:NewsTypeServiceImpl
 * discription:
 * author:fhm
 * createTime:2018-11-20 19:03
 */
@Service
public class NewsTypeServiceImpl implements NewsTypeService {
    //依赖注入
    @Autowired
    private NewsTypeDao newsTypeDao;

    @Override
    public List<Map> getList() {
        return newsTypeDao.getList();
    }
}
