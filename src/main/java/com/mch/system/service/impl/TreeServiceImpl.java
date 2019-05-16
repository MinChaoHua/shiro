package com.mch.system.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mch.system.dao.MenuMapper;
import com.mch.system.entity.Menu;
import com.mch.system.entity.TreeBean;
import com.mch.system.service.TreeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TreeServiceImpl implements TreeService {

    @Resource
    MenuMapper menuMapper;

    @Override
    public Map<String, Object> loadRelTree(int parentId) {
        System.out.println("LLLL");
        System.out.println(parentId);
        Map<String,Object> map = new HashMap<>();
        List<TreeBean> treeList = new ArrayList<>();
        List<Menu> menuList ;
        if( parentId==0) {
            menuList = menuMapper.selectMenuByParentId(parentId);
            menuList.forEach(menu ->{
                TreeBean treeNode=new TreeBean();
                treeNode.setText(menu.getName());
                treeNode.setId(String.valueOf(menu.getMenuId()));
                treeNode.setState("close");
                treeList.add(treeNode);
            });
        }else {//异步加载
            System.out.println("KKKK");
            // 查询是否存在子目录
            int count = menuMapper.selectMenuChildCount(parentId);
            System.out.println(count);
            if(count>0) {
                //根据传递过来的id,查找名称
                Menu menu = menuMapper.selectByPrimaryKey(parentId);
                //查询子节点
                menuList = menuMapper.selectMenuByParentId(parentId);
                TreeBean treeNode=new TreeBean();
                treeNode.setText(menu.getName());
                treeNode.setId(String.valueOf(menu.getMenuId()));
                treeNode.setState("close");
                List<TreeBean> childTree = new ArrayList<>();
                //子节点转化成 TreeBean
                menuList.forEach(childMenu->{
                    TreeBean childNode=new TreeBean();
                    childNode.setText(childMenu.getName());
                    childNode.setId(String.valueOf(childMenu.getMenuId()));
                    childNode.setState("close");
                    childTree.add(childNode);

                });
                treeNode.setChildren(childTree);
                treeList.add(treeNode);

                treeList.forEach(tree->{
                    System.out.println(tree.toString());

                });

            }
        }

        map.put("treeJson", treeList);
        map.put("status", "succeed");
        return map;
    }

}
