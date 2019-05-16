package com.mch.system.controller;

import com.mch.system.service.TreeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class TreeController {


    @Resource
    TreeService treeService;

    @ResponseBody
    @RequestMapping(value = "/system/loadRelTree",method = RequestMethod.POST)
    public Map<String, Object> getTree(int id){
        System.out.println(id);
        return treeService.loadRelTree(id);
    }
}
