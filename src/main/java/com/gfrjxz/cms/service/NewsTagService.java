package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.NewsTagDao;

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
public class NewsTagService {

@Autowired
private NewsTagDao newsTagDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public NewsTag getSinger(Integer id){

    QueryWrapper<NewsTag> wrapper = new QueryWrapper<NewsTag>();
    wrapper.eq("id", id);
    NewsTag u = newsTagDao.selectOne(wrapper);
    return u;

 }

public NewsTag getSingerBy(Map<String,Object> map){

    QueryWrapper<NewsTag> wrapper = new QueryWrapper<NewsTag>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    NewsTag u = newsTagDao.selectOne(wrapper);
    return u;

}

public List<NewsTag> getAll(){

    QueryWrapper<NewsTag> wrapper = new QueryWrapper<NewsTag>();
    wrapper.ne("id", 0);
    return newsTagDao.selectList(wrapper);
}
private QueryWrapper<NewsTag> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<NewsTag> wrapper = new QueryWrapper<NewsTag>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<NewsTag> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     QueryWrapper<NewsTag> wrapper = this.getSearchWrapper(map);
     wrapper.last("limit "+ offset+","+ pageSize);
     wrapper.orderByDesc("id") ;
     return newsTagDao.selectList(wrapper);
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<NewsTag> wrapper = this.getSearchWrapper(map);

    Integer count = newsTagDao.selectCount(wrapper);

    return count;
}



public boolean add(NewsTag u){

    int result = newsTagDao.insert(u);
    return result >0;

}

public boolean update(NewsTag u) {


    UpdateWrapper<NewsTag> updateWrapper = new UpdateWrapper<NewsTag>();
    updateWrapper.eq("id", u.getId());
       updateWrapper.set("tag", u.getTag());
   updateWrapper.set("newsId", u.getNewsId());

    int result = newsTagDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(NewsTag u,Map<String, Object> map) {

    QueryWrapper<NewsTag> wrapper = new QueryWrapper<NewsTag>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = newsTagDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    newsTagDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<NewsTag> wrapper = new QueryWrapper<NewsTag>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        newsTagDao.delete(wrapper);
     }

}
