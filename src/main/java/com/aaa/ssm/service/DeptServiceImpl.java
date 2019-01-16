package com.aaa.ssm.service;

import com.aaa.ssm.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptServiceImpl
 * discription:
 * author:fhm
 * createTime:2018-11-20 15:41
 */
@Service
public class DeptServiceImpl implements DeptService {

    //依赖注入
    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Map> getList() {
        return deptDao.getList();
    }
}
