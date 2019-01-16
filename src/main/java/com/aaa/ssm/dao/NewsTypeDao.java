package com.aaa.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * className:NewsTypeDao
 * discription:
 * author:fhm
 * createTime:2018-11-20 18:49
 */
public interface NewsTypeDao {
    /**
     * 获取所有的新闻分类信息
     * @return
     */
    List<Map> getList();
}
