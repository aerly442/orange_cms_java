package com.gfrjxz.cms.dao;
import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.*;


public interface CreateCodeDao extends BaseMapper<Manager> {


    //@Select("select * from user where id>#{id}")
    //List<User> getList(@Param("id") int id);
    //获取所有的表字段
    @Select("show tables")
    List<String> getTable();

    //获取表结构描述
    @Select("select COLUMN_NAME as name,DATA_TYPE as  type,COLUMN_COMMENT  as comment\n" +
            " from information_schema.COLUMNS where table_name =#{tableName} and table_schema = 'myorange_cms';")
    List<Map<String,Object>> getTableDesc(@Param("tableName") String tableName);

}
