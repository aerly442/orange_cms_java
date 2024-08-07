package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.NewsResourceVisitReportDao;

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
public class NewsResourceVisitReportService {

@Autowired
private NewsResourceVisitReportDao newsResourceVisitReportDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public NewsResourceVisitReport getSinger(Integer id){

    QueryWrapper<NewsResourceVisitReport> wrapper = new QueryWrapper<NewsResourceVisitReport>();
    wrapper.eq("id", id);
    NewsResourceVisitReport u = newsResourceVisitReportDao.selectOne(wrapper);
    return u;

 }

public NewsResourceVisitReport getSingerBy(Map<String,Object> map){

    QueryWrapper<NewsResourceVisitReport> wrapper = new QueryWrapper<NewsResourceVisitReport>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    NewsResourceVisitReport u = newsResourceVisitReportDao.selectOne(wrapper);
    return u;

}

public List<NewsResourceVisitReport> getAll(){

    QueryWrapper<NewsResourceVisitReport> wrapper = new QueryWrapper<NewsResourceVisitReport>();
    wrapper.ne("id", 0);
    return newsResourceVisitReportDao.selectList(wrapper);
}
private QueryWrapper<NewsResourceVisitReport> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<NewsResourceVisitReport> wrapper = new QueryWrapper<NewsResourceVisitReport>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<NewsResourceVisitReport> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     QueryWrapper<NewsResourceVisitReport> wrapper = this.getSearchWrapper(map);
     wrapper.last("limit "+ offset+","+ pageSize);
     wrapper.orderByDesc("id") ;
     return newsResourceVisitReportDao.selectList(wrapper);
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<NewsResourceVisitReport> wrapper = this.getSearchWrapper(map);

    Integer count = newsResourceVisitReportDao.selectCount(wrapper);

    return count;
}



public boolean add(NewsResourceVisitReport u){

    int result = newsResourceVisitReportDao.insert(u);
    return result >0;

}

public boolean update(NewsResourceVisitReport u) {


    UpdateWrapper<NewsResourceVisitReport> updateWrapper = new UpdateWrapper<NewsResourceVisitReport>();
    updateWrapper.eq("id", u.getId());
       updateWrapper.set("updatetime", u.getUpdatetime());
   updateWrapper.set("title", u.getTitle());
   updateWrapper.set("reporttime", u.getReporttime());
   updateWrapper.set("clickPv", u.getClickPv());

    int result = newsResourceVisitReportDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(NewsResourceVisitReport u,Map<String, Object> map) {

    QueryWrapper<NewsResourceVisitReport> wrapper = new QueryWrapper<NewsResourceVisitReport>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = newsResourceVisitReportDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    newsResourceVisitReportDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<NewsResourceVisitReport> wrapper = new QueryWrapper<NewsResourceVisitReport>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        newsResourceVisitReportDao.delete(wrapper);
     }

}
