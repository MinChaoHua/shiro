package com.mch.system.dao;

import com.mch.system.entity.Role_Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Role_MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role_Menu record);

    int insertSelective(Role_Menu record);

    Role_Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role_Menu record);

    int updateByPrimaryKey(Role_Menu record);
}