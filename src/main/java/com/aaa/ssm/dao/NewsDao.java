package com.aaa.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * className:NewsDao
 * discription:
 * author:fhm
 * createTime:2018-11-20 18:42
 */
public interface NewsDao {

    /**
     * 新闻分页查询
     * @param map
     * @return
     */
    List<Map> getPage(Map map);

    /**
     * 查询分页总数量
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
     * 根据ID查询新闻列表
     * @param newsid
     * @return
     */
    Map getById(int newsid);
}
