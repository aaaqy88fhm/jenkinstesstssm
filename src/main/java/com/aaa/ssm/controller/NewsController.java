package com.aaa.ssm.controller;

import com.aaa.ssm.service.NewsService;
import com.aaa.ssm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * className:NewsController
 * discription:
 * author:fhm
 * createTime:2018-11-20 19:50
 */
@Controller
@RequestMapping("news")
public class NewsController {
    //依赖注入
    @Autowired
    private NewsService newsService;

    /**
     * 新闻列表方法
     * @param pageNo
     * @param model
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/list")
    public String list(Integer pageNo, Model model, HttpServletRequest request, String info){
        //int pageNo, int pageSize, int totalSize, HttpServletRequest request
        int pageSize=5;
        Map map = new HashMap();
        int tPageNo = pageNo==null?1:pageNo;
        map.put("pageNo",tPageNo);
        map.put("pageSize",pageSize);
        String pageString = new PageUtil(tPageNo, pageSize, newsService.getPageCount(map), request).getPageString();
        model.addAttribute("pageString",pageString);
        model.addAttribute("newsList",newsService.getPage(map));
        if (info!=null){
            model.addAttribute("pageno",pageNo);
            model.addAttribute("info",info);
        }
        return "news/list";
    }
    /**
     * 新闻添加
     * @param paramMap
     * @return
     */
    @RequestMapping("/add")
    public String add(@RequestParam Map paramMap, Model model){
        //System.out.println(paramMap);
        int add=newsService.add(paramMap);
        if(add==0){
            model.addAttribute("info","添加失败");
        }else{
            model.addAttribute("info","添加成功");
            return "redirect:list.do";
        }
        return null;
    }

    /**
     * 跳转到更新页面
     * @return
     */
    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(int newsid){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("news",newsService.getById(newsid));
        //设置逻辑视图名
        modelAndView.setViewName("news/update");
        return modelAndView;
    }

    /**
     * 新闻更新
     * @param paramMap
     * @return
     */
    @RequestMapping("/update")
    public String update(@RequestParam Map paramMap,Model model){
        //System.out.println(paramMap);
        int update=newsService.update(paramMap);
        if(update==0){
            model.addAttribute("info","更新失败");
        }else{
            model.addAttribute("info","更新成功");
            return "redirect:list.do";
        }
        return null;
    }

    /**
     * 新闻删除
     * @param newsid
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer newsid,Model model){
        int del=newsService.delete(newsid);
        if(del==0){
            model.addAttribute("info","删除失败");
        }else{
            model.addAttribute("info","删除成功");
            return "redirect:list.do";
        }
        return null;
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "news/add";
    }

}
