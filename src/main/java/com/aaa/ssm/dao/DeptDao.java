package com.aaa.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * className:DeptDao
 * discription:
 * author:fhm
 * createTime:2018-11-20 15:42
 */
public interface DeptDao {

    /**
     * 获取所有的部门
     * @return
     */
    List<Map> getList();
}
