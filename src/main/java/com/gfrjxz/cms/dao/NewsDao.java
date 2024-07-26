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

public interface NewsDao extends BaseMapper<News> {
  
    //@Select("select * from user where id>#{id}")
    //List<User> getList(@Param("id") int id);

    @Select("select n.id,title,c.name as news_categories_code,hot,visit,is_charge,price,sort,state,createtime\n" +
            " from news_categories as n left join news_categories_code as where n.news_categories_code=c.code and  ${fieldName} like '%#{fieldValue}%' limit ${pageIndex},${pageSize} ")
    List<News> getList( String fieldName,@Param("fieldValue") String fieldValue,
      Integer pageIndex, Integer pageSize
    );

}
