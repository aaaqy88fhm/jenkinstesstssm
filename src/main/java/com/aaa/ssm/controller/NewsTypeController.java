package com.aaa.ssm.controller;

import com.aaa.ssm.service.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * className:NewsTypeController
 * discription:
 * author:fhm
 * createTime:2018-11-20 20:03
 */
@Controller
@RequestMapping("newsType")
public class NewsTypeController {
    //依赖注入
    @Autowired
    private NewsTypeService newsTypeService;

    /**
     * 新闻类型列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Object getList(){
        //获取所有的新闻类型信息
        List<Map> newsTypeList = newsTypeService.getList();
        if (newsTypeList!=null&&newsTypeList.size()>0){
            return newsTypeList;
        }
        return null;
    }
}
