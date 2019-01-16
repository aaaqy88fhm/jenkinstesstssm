package com.aaa.ssm.controller;

import com.aaa.ssm.service.DeptService;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * className:DeptController
 * discription:
 * author:fhm
 * createTime:2018-11-20 15:34
 */
@Controller
@RequestMapping("dept")
public class DeptController {

    //依赖注入
    @Autowired
    private DeptService deptService;

    @ResponseBody
    @RequestMapping("/list")
    public Object list(){
        //获取所有的部门信息
        List<Map> deptList = deptService.getList();
        if (deptList!=null&&deptList.size()>0){
            return deptList;
        }
        return null;
    }
}
