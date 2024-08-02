package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.NewsCommentDao;

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
public class NewsCommentService {

@Autowired
private NewsCommentDao newsCommentDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public NewsComment getSinger(Integer id){

    QueryWrapper<NewsComment> wrapper = new QueryWrapper<NewsComment>();
    wrapper.eq("id", id);
    NewsComment u = newsCommentDao.selectOne(wrapper);
    return u;

 }

public NewsComment getSingerBy(Map<String,Object> map){

    QueryWrapper<NewsComment> wrapper = new QueryWrapper<NewsComment>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    NewsComment u = newsCommentDao.selectOne(wrapper);
    return u;

}

public List<NewsComment> getAll(){

    QueryWrapper<NewsComment> wrapper = new QueryWrapper<NewsComment>();
    wrapper.ne("id", 0);
    return newsCommentDao.selectList(wrapper);
}
private QueryWrapper<NewsComment> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<NewsComment> wrapper = new QueryWrapper<NewsComment>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<NewsComment> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     QueryWrapper<NewsComment> wrapper = this.getSearchWrapper(map);
     wrapper.last("limit "+ offset+","+ pageSize);
     return newsCommentDao.selectList(wrapper);
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<NewsComment> wrapper = this.getSearchWrapper(map);

    Integer count = newsCommentDao.selectCount(wrapper);

    return count;
}



public boolean add(NewsComment u){

    int result = newsCommentDao.insert(u);
    return result >0;

}

public boolean update(NewsComment u) {


    UpdateWrapper<NewsComment> updateWrapper = new UpdateWrapper<NewsComment>();
    updateWrapper.eq("id", u.getId());
       updateWrapper.set("nickname", u.getNickname());
   updateWrapper.set("content", u.getContent());
   updateWrapper.set("updatetime", u.getUpdatetime());
   updateWrapper.set("state", u.getState());
   updateWrapper.set("parentid", u.getParentid());
   updateWrapper.set("userid", u.getUserid());
   updateWrapper.set("likecount", u.getLikecount());
   updateWrapper.set("hatecount", u.getHatecount());
   updateWrapper.set("newsid", u.getNewsid());
   updateWrapper.set("title", u.getTitle());

    int result = newsCommentDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(NewsComment u,Map<String, Object> map) {

    QueryWrapper<NewsComment> wrapper = new QueryWrapper<NewsComment>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = newsCommentDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    newsCommentDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<NewsComment> wrapper = new QueryWrapper<NewsComment>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        newsCommentDao.delete(wrapper);
     }

}
