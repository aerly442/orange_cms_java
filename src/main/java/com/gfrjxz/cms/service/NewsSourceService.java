package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.NewsSourceDao;

import com.gfrjxz.cms.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


@Service
public class NewsSourceService {

@Autowired
private NewsSourceDao newsSourceDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public NewsSource getSinger(Integer id){

    QueryWrapper<NewsSource> wrapper = new QueryWrapper<NewsSource>();
    wrapper.eq("id", id);
    NewsSource u = newsSourceDao.selectOne(wrapper);
    return u;

 }

public NewsSource getSingerBy(Map<String,Object> map){

    QueryWrapper<NewsSource> wrapper = new QueryWrapper<NewsSource>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    NewsSource u = newsSourceDao.selectOne(wrapper);
    return u;

}

public List<NewsSource> getAll(){

    QueryWrapper<NewsSource> wrapper = new QueryWrapper<NewsSource>();
    wrapper.ne("id", 0);
    return newsSourceDao.selectList(wrapper);
}
private QueryWrapper<NewsSource> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<NewsSource> wrapper = new QueryWrapper<NewsSource>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<NewsSource> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     QueryWrapper<NewsSource> wrapper = this.getSearchWrapper(map);
     wrapper.last("limit "+ offset+","+ pageSize);
     wrapper.orderByDesc("id") ;
     return newsSourceDao.selectList(wrapper);
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<NewsSource> wrapper = this.getSearchWrapper(map);

    Integer count = newsSourceDao.selectCount(wrapper);

    return count;
}



public boolean add(NewsSource u){

    int result = newsSourceDao.insert(u);
    return result >0;

}

public boolean update(NewsSource u) {


    UpdateWrapper<NewsSource> updateWrapper = new UpdateWrapper<NewsSource>();
    updateWrapper.eq("id", u.getId());
       updateWrapper.set("title", u.getTitle());
   updateWrapper.set("note", u.getNote());
   updateWrapper.set("url", u.getUrl());
   updateWrapper.set("type", u.getType());
   updateWrapper.set("updatetime", u.getUpdatetime());

    int result = newsSourceDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(NewsSource u,Map<String, Object> map) {

    QueryWrapper<NewsSource> wrapper = new QueryWrapper<NewsSource>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = newsSourceDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    newsSourceDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<NewsSource> wrapper = new QueryWrapper<NewsSource>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        newsSourceDao.delete(wrapper);
     }

}
