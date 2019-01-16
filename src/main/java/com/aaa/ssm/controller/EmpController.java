package com.aaa.ssm.controller;

import com.aaa.ssm.service.EmpService;
import com.aaa.ssm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * className:EmpController
 * discription:
 * author:fhm
 * createTime:2018-11-19 11:43
 */
@Controller
@RequestMapping("emp")
public class EmpController {
    //依赖注入服务层
    @Autowired
    private EmpService empService;
    /**
     * 员工列表方法
     * @param pageNo
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Integer pageNo, Model model, HttpServletRequest request,String info){
        //int pageNo, int pageSize, int totalSize, HttpServletRequest request
        int pageSize=5;
        Map map = new HashMap();
        int tPageNo = pageNo==null?1:pageNo;
        map.put("pageNo",tPageNo);
        map.put("pageSize",pageSize);
        String pageString = new PageUtil(tPageNo, pageSize, empService.getPageCount(map), request).getPageString();
        model.addAttribute("pageString",pageString);
        model.addAttribute("empList",empService.getPage(map));
        if (info!=null){
            model.addAttribute("pageno",pageNo);
            model.addAttribute("info",info);
        }
        return "emp/list";
    }

    /**
     * 员工添加
     * @param paramMap
     * @return
     */
    @RequestMapping("/add")
    public String add(@RequestParam Map paramMap, Model model){
        //System.out.println(paramMap);
        int add=empService.add(paramMap);
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
    public ModelAndView toUpdate(int empno){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("emp",empService.getById(empno));
        //设置逻辑视图名
        modelAndView.setViewName("emp/update");
        return modelAndView;
    }

    /**
     * 员工更新
     * @param paramMap
     * @return
     */
    @RequestMapping("/update")
    public String update(@RequestParam Map paramMap,Model model){
        int update=empService.update(paramMap);
        if(update==0){
            model.addAttribute("info","更新失败");
        }else{
            model.addAttribute("info","更新成功");
            return "redirect:list.do";
        }
        return null;
    }

    /**
     * 员工删除
     * @param empno
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer empno,Model model){
        int del=empService.delete(empno);
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
       return "emp/add";
    }

}
