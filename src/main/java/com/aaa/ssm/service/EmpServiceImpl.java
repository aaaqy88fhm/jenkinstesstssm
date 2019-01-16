package com.aaa.ssm.service;

import com.aaa.ssm.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:EmpServiceImpl
 * discription:
 * author:fhm
 * createTime:2018-11-19 11:31
 */
@Service
public class EmpServiceImpl implements EmpService {

    //依赖注入
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Map> getPage(Map map) {
        int pageNo=map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize=map.get("pageSize")==null?5:Integer.valueOf(map.get("pageSize")+"");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return empDao.getPage(map);
    }

    @Override
    public int getPageCount(Map map) {
        return empDao.getPageCount(map);
    }

    @Override
    public int add(Map map) {
        return empDao.add(map);
    }

    @Override
    public int update(Map map) {
        return empDao.update(map);
    }

    @Override
    public int delete(int empno) {
        return empDao.delete(empno);
    }

    @Override
    public Map getById(int empno) {
        return empDao.getById(empno);
    }
}
