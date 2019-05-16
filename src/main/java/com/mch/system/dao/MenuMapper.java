package com.mch.system.dao;

import com.mch.system.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     * @param parentId
     * @return parentId=0,返回一级目录，
     * */
    List<Menu> selectMenuByParentId(int parentId);
    /**
     * @param parentId
     * @return 查询是否有子目录
     * */
    int  selectMenuChildCount(int parentId);
}