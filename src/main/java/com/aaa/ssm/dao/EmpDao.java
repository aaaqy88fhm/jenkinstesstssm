package com.aaa.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * className:EmpDao
 * discription:
 * author:fhm
 * createTime:2018-11-19 10:31
 */
public interface EmpDao {
    /**
     * 员工分页查询
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
     * 员工添加
     * @param map
     * @return
     */
    int add(Map map);

    /**
     * 员工更新
     * @param map
     * @return
     */
    int update(Map map);

    /**
     * 员工删除
     * @return
     */
    int delete(int empno);

    /**
     * 根据ID查询员工列表
     * @param empno
     * @return
     */
    Map getById(int empno);
}
