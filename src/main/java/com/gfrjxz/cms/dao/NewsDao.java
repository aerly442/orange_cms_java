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

    @Select("select n.id,title,c.name as newsCategoriesCode,hot,visit,is_charge as isCharge,price,n.sort,state,n.createtime\n" +
            " from news as n left join news_categories as c on n.news_categories_code=c.code  where  ${fieldName} like #{fieldValue} order by n.id desc limit ${pageIndex},${pageSize}  ")
    List<News> getList(String fieldName,@Param("fieldValue") String fieldValue,Integer pageIndex,Integer pageSize);

    @Select("select n.id,title,c.code as newsCategoriesCode,hot,visit,is_charge as isCharge,price,n.sort,state,n.createtime,abstract\n" +
            " from news as n left join news_categories as c on n.news_categories_code=c.code  where n.state=1 and  ${fieldName} like #{fieldValue} order by n.id desc limit ${pageIndex},${pageSize}  ")
    List<News> getListForFront(String fieldName,@Param("fieldValue") String fieldValue,Integer pageIndex,Integer pageSize);

}
