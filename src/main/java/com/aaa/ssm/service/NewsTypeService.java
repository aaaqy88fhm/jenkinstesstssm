package com.aaa.ssm.service;

import java.util.List;
import java.util.Map;

/**
 * className:NewsTypeService
 * discription:
 * author:fhm
 * createTime:2018-11-20 19:02
 */
public interface NewsTypeService {
    /**
     * 获取所有的新闻信息
     * @return
     */
    List<Map> getList();
}
