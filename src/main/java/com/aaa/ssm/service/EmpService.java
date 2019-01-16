package com.aaa.ssm.service;

import java.util.List;
import java.util.Map;

/**
 * className:EmpService
 * discription:
 * author:fhm
 * createTime:2018-11-19 11:26
 */
public interface EmpService {
    /**
     * 员工分页方法
     * @param map
     * @return
     */
    List<Map> getPage(Map map);

    /**
     * 员工分页总数量
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
     * @param empno
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
