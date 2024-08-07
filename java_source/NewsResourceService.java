package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.NewsResourceDao;

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
public class NewsResourceService {

@Autowired
private NewsResourceDao newsResourceDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public NewsResource getSinger(Integer id){

    QueryWrapper<NewsResource> wrapper = new QueryWrapper<NewsResource>();
    wrapper.eq("id", id);
    NewsResource u = newsResourceDao.selectOne(wrapper);
    return u;

 }

public NewsResource getSingerBy(Map<String,Object> map){

    QueryWrapper<NewsResource> wrapper = new QueryWrapper<NewsResource>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    NewsResource u = newsResourceDao.selectOne(wrapper);
    return u;

}

public List<NewsResource> getAll(){

    QueryWrapper<NewsResource> wrapper = new QueryWrapper<NewsResource>();
    wrapper.ne("id", 0);
    return newsResourceDao.selectList(wrapper);
}
private QueryWrapper<NewsResource> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<NewsResource> wrapper = new QueryWrapper<NewsResource>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<NewsResource> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     QueryWrapper<NewsResource> wrapper = this.getSearchWrapper(map);
     wrapper.last("limit "+ offset+","+ pageSize);
     wrapper.orderByDesc("id") ;
     return newsResourceDao.selectList(wrapper);
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<NewsResource> wrapper = this.getSearchWrapper(map);

    Integer count = newsResourceDao.selectCount(wrapper);

    return count;
}



public boolean add(NewsResource u){

    int result = newsResourceDao.insert(u);
    return result >0;

}

public boolean update(NewsResource u) {


    UpdateWrapper<NewsResource> updateWrapper = new UpdateWrapper<NewsResource>();
    updateWrapper.eq("id", u.getId());
       updateWrapper.set("resource", u.getResource());
   updateWrapper.set("note", u.getNote());
   updateWrapper.set("updatetime", u.getUpdatetime());
   updateWrapper.set("title", u.getTitle());
   updateWrapper.set("state", u.getState());
   updateWrapper.set("checktime", u.getChecktime());
   updateWrapper.set("seed", u.getSeed());
   updateWrapper.set("violationCnt", u.getViolationCnt());
   updateWrapper.set("clickPv", u.getClickPv());
   updateWrapper.set("savePv", u.getSavePv());
   updateWrapper.set("expiredDays", u.getExpiredDays());
   updateWrapper.set("expiredAt", u.getExpiredAt());
   updateWrapper.set("lastSavePv", u.getLastSavePv());
   updateWrapper.set("lastClickPv", u.getLastClickPv());

    int result = newsResourceDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(NewsResource u,Map<String, Object> map) {

    QueryWrapper<NewsResource> wrapper = new QueryWrapper<NewsResource>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = newsResourceDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    newsResourceDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<NewsResource> wrapper = new QueryWrapper<NewsResource>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        newsResourceDao.delete(wrapper);
     }

}
