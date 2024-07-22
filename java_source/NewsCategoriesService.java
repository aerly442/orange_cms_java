package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.NewsCategoriesDao;

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
public class NewsCategoriesService {

@Autowired
private NewsCategoriesDao newsCategoriesDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public NewsCategories getSinger(Integer id){

    QueryWrapper<NewsCategories> wrapper = new QueryWrapper<NewsCategories>();
    wrapper.eq("id", id);
    NewsCategories u = newsCategoriesDao.selectOne(wrapper);
    return u;

 }

public NewsCategories getSingerBy(Map<String,Object> map){

    QueryWrapper<NewsCategories> wrapper = new QueryWrapper<NewsCategories>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    NewsCategories u = newsCategoriesDao.selectOne(wrapper);
    return u;

}

public List<NewsCategories> getAll(){

    QueryWrapper<NewsCategories> wrapper = new QueryWrapper<NewsCategories>();
    wrapper.ne("id", 0);
    return newsCategoriesDao.selectList(wrapper);
}
private QueryWrapper<NewsCategories> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<NewsCategories> wrapper = new QueryWrapper<NewsCategories>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<NewsCategories> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     QueryWrapper<NewsCategories> wrapper = this.getSearchWrapper(map);
     wrapper.last("limit "+ offset+","+ pageSize);
     return newsCategoriesDao.selectList(wrapper);
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<NewsCategories> wrapper = this.getSearchWrapper(map);

    Integer count = newsCategoriesDao.selectCount(wrapper);

    return count;
}



public boolean add(NewsCategories u){

    int result = newsCategoriesDao.insert(u);
    return result >0;

}

public boolean update(NewsCategories u) {


    UpdateWrapper<NewsCategories> wrapper = new UpdateWrapper<NewsCategories>();
    updateWrapper.eq("id", u.getId());
       updateWrapper.set("name", u.getName());
   updateWrapper.set("code", u.getCode());
   updateWrapper.set("sort", u.getSort());

    int result = newsCategoriesDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(NewsCategories u,Map<String, Object> map) {

    QueryWrapper<NewsCategories> wrapper = new QueryWrapper<NewsCategories>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = newsCategoriesDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    newsCategoriesDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<NewsCategories> wrapper = new QueryWrapper<NewsCategories>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        newsCategoriesDao.delete(wrapper);
     }

}
