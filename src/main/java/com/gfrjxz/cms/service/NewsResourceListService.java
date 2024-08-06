package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.NewsResourceListDao;

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
public class NewsResourceListService {

@Autowired
private NewsResourceListDao newsResourceListDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public NewsResourceList getSinger(Integer id){

    QueryWrapper<NewsResourceList> wrapper = new QueryWrapper<NewsResourceList>();
    wrapper.eq("id", id);
    NewsResourceList u = newsResourceListDao.selectOne(wrapper);
    return u;

 }

public NewsResourceList getSingerBy(Map<String,Object> map){

    QueryWrapper<NewsResourceList> wrapper = new QueryWrapper<NewsResourceList>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    NewsResourceList u = newsResourceListDao.selectOne(wrapper);
    return u;

}

public List<NewsResourceList> getAll(){

    QueryWrapper<NewsResourceList> wrapper = new QueryWrapper<NewsResourceList>();
    wrapper.ne("id", 0);
    return newsResourceListDao.selectList(wrapper);
}
private QueryWrapper<NewsResourceList> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<NewsResourceList> wrapper = new QueryWrapper<NewsResourceList>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<NewsResourceListDTO> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     String fieldName  = "";
     String fieldValue = "";
     for (String key : map.keySet()) {
         fieldName = key;
         fieldValue = map.get(key).toString();
         break ;
     }
     fieldName  = fieldName.isEmpty()?"b.title<>":fieldName+"=";
     fieldValue = "" ;
     return newsResourceListDao.getList(fieldName,fieldValue,pageIndex,pageSize) ;
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<NewsResourceList> wrapper = this.getSearchWrapper(map);

    Integer count = newsResourceListDao.selectCount(wrapper);

    return count;
}



public boolean add(NewsResourceList u){

    int result = newsResourceListDao.insert(u);
    return result >0;

}

public boolean update(NewsResourceList u) {


    UpdateWrapper<NewsResourceList> updateWrapper = new UpdateWrapper<NewsResourceList>();
    updateWrapper.eq("id", u.getId());
       updateWrapper.set("newsid", u.getNewsid());
   updateWrapper.set("newsresourceid", u.getNewsresourceid());
   updateWrapper.set("updatetime", u.getUpdatetime());

    int result = newsResourceListDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(NewsResourceList u,Map<String, Object> map) {

    QueryWrapper<NewsResourceList> wrapper = new QueryWrapper<NewsResourceList>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = newsResourceListDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    newsResourceListDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<NewsResourceList> wrapper = new QueryWrapper<NewsResourceList>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        newsResourceListDao.delete(wrapper);
     }

}
