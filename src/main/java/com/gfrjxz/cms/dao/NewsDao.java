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
            " from news as n left join news_categories as c on n.news_categories_code=c.code  where  ${fieldName} like  #{fieldValue} order by n.id desc limit ${pageIndex},${pageSize}  ")
    List<News> getList(String fieldName,@Param("fieldValue") String fieldValue,Integer pageIndex,Integer pageSize);

    //EXISTS (select 1 from news_tag where news.id=news_tag.newsid and tag like '%香港电影%')
    @Select("select n.id,title,c.code as newsCategoriesCode,hot,visit,is_charge as isCharge,price,n.sort,state,n.createtime,abstract\n" +
            " from news as n left join news_categories as c on n.news_categories_code=c.code  where n.state=1 and  ${fieldName} like #{fieldValue} ${otherWhere} order by n.id desc limit ${pageIndex},${pageSize}  ")
    List<News> getListForFront(String fieldName,@Param("fieldValue") String fieldValue,Integer pageIndex,Integer pageSize,String otherWhere);

    @Select("select count(1) \n" +
    " from news as n left join news_categories as c on n.news_categories_code=c.code  where n.state=1 and  ${fieldName} like #{fieldValue} ${otherWhere} ")
    Integer getListForFrontCount(String fieldName,@Param("fieldValue") String fieldValue,String otherWhere);

    @Select("select n.id,title,c.code as newsCategoriesCode,hot,visit,is_charge as isCharge,price,n.sort,state,n.createtime,abstract\n" +
    " from news as n left join news_categories as c on n.news_categories_code=c.code  where n.state=1 and c.createtime>'${createtime}'  order by n.visit desc limit 10  ")
   List<News> getHotListForFront(String createtime);

    @Update("update news set visit=visit+1 where id=#{id}")
    void updateVisit(@Param("id") Integer id);

}
