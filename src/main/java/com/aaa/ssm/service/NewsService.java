package com.aaa.ssm.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:NewsService
 * discription:
 * author:fhm
 * createTime:2018-11-20 18:50
 */
public interface NewsService {
    /**
     * 新闻表分页方法
     * @param map
     * @return
     */
    List<Map> getPage(Map map);

    /**
     * 新闻分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 新闻添加
     * @param map
     * @return
     */
    int add(Map map);

    /**
     * 新闻更新
     * @param map
     * @return
     */
    int update(Map map);

    /**
     * 新闻删除
     * @param newsid
     * @return
     */
    int delete(int newsid);
    /**
     * 根据ID查询员工列表
     * @param newsid
     * @return
     */
    Map getById(int newsid);
}
