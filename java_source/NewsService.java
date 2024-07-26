package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.NewsDao;

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
public class NewsService {

@Autowired
private NewsDao newsDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public News getSinger(Integer id){

    QueryWrapper<News> wrapper = new QueryWrapper<News>();
    wrapper.eq("id", id);
    News u = newsDao.selectOne(wrapper);
    return u;

 }

public News getSingerBy(Map<String,Object> map){

    QueryWrapper<News> wrapper = new QueryWrapper<News>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    News u = newsDao.selectOne(wrapper);
    return u;

}

public List<News> getAll(){

    QueryWrapper<News> wrapper = new QueryWrapper<News>();
    wrapper.ne("id", 0);
    return newsDao.selectList(wrapper);
}
private QueryWrapper<News> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<News> wrapper = new QueryWrapper<News>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<News> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     QueryWrapper<News> wrapper = this.getSearchWrapper(map);
     wrapper.last("limit "+ offset+","+ pageSize);
     return newsDao.selectList(wrapper);
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<News> wrapper = this.getSearchWrapper(map);

    Integer count = newsDao.selectCount(wrapper);

    return count;
}



public boolean add(News u){

    int result = newsDao.insert(u);
    return result >0;

}

public boolean update(News u) {


    UpdateWrapper<News> updateWrapper = new UpdateWrapper<News>();
    updateWrapper.eq("id", u.getId());
       updateWrapper.set("title", u.getTitle());
   updateWrapper.set("content", u.getContent());
   updateWrapper.set("author", u.getAuthor());
   updateWrapper.set("source", u.getSource());
   updateWrapper.set("newsCategoriesCode", u.getNewsCategoriesCode());
   updateWrapper.set("mainpic", u.getMainpic());
   updateWrapper.set("file", u.getFile());
   updateWrapper.set("url", u.getUrl());
   updateWrapper.set("sort", u.getSort());
   updateWrapper.set("state", u.getState());
   updateWrapper.set("hot", u.getHot());
   updateWrapper.set("keyWord", u.getKeyWord());
   updateWrapper.set("abstract", u.getAbstract());
   updateWrapper.set("visit", u.getVisit());
   updateWrapper.set("isCharge", u.getIsCharge());
   updateWrapper.set("chargeStarttime", u.getChargeStarttime());
   updateWrapper.set("chargeEndtime", u.getChargeEndtime());
   updateWrapper.set("price", u.getPrice());
   updateWrapper.set("isComment", u.getIsComment());
   updateWrapper.set("chargeType", u.getChargeType());

    int result = newsDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(News u,Map<String, Object> map) {

    QueryWrapper<News> wrapper = new QueryWrapper<News>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = newsDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    newsDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<News> wrapper = new QueryWrapper<News>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        newsDao.delete(wrapper);
     }

}
