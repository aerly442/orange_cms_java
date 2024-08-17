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

public interface NewsResourceListDao extends BaseMapper<NewsResourceList> {
  
    //@Select("select * from user where id>#{id}")
    //List<User> getList(@Param("id") int id);
//
//select a.*,b.title,c.title as ctitle,c.resource from news_resource_list  as a,news as b,news_resource as c where a.newsid=b.id and a.newsresourceid=c.id
   @Select("select a.*,b.title,c.title as ctitle,c.resource \n" +
            " from news_resource_list  as a,news as b,news_resource as c \n" +
            " where a.newsid=b.id and a.newsresourceid=c.id and  ${fieldName}#{fieldValue} order by a.id desc limit ${pageIndex},${pageSize}  ")
    List<NewsResourceListDTO> getList(String fieldName,@Param("fieldValue") String fieldValue,Integer pageIndex,Integer pageSize);

    @Select("select a.*,b.title,c.title as ctitle,c.resource \n" +
            " from news_resource_list  as a,news as b,news_resource as c \n" +
            " where a.newsid=b.id and a.newsresourceid=c.id and  a.id=#{id}  ")
   NewsResourceListDTO getSinger(@Param("id") Integer id);

   @Select("select a.*,b.title,c.title as ctitle,c.resource \n" +
   " from news_resource_list  as a,news as b,news_resource as c \n" +
   " where a.newsid=b.id and a.newsresourceid=c.id and  a.newsid=#{id} limit 1 ")
NewsResourceListDTO getSingerByNewsId(@Param("id") Integer id);

}
