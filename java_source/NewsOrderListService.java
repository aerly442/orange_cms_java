package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.NewsOrderListDao;

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
public class NewsOrderListService {

@Autowired
private NewsOrderListDao newsOrderListDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public NewsOrderList getSinger(Integer id){

    QueryWrapper<NewsOrderList> wrapper = new QueryWrapper<NewsOrderList>();
    wrapper.eq("id", id);
    NewsOrderList u = newsOrderListDao.selectOne(wrapper);
    return u;

 }

public NewsOrderList getSingerBy(Map<String,Object> map){

    QueryWrapper<NewsOrderList> wrapper = new QueryWrapper<NewsOrderList>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    NewsOrderList u = newsOrderListDao.selectOne(wrapper);
    return u;

}

public List<NewsOrderList> getAll(){

    QueryWrapper<NewsOrderList> wrapper = new QueryWrapper<NewsOrderList>();
    wrapper.ne("id", 0);
    return newsOrderListDao.selectList(wrapper);
}
private QueryWrapper<NewsOrderList> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<NewsOrderList> wrapper = new QueryWrapper<NewsOrderList>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<NewsOrderList> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     QueryWrapper<NewsOrderList> wrapper = this.getSearchWrapper(map);
     wrapper.last("limit "+ offset+","+ pageSize);
     wrapper.orderByDesc("id") ;
     return newsOrderListDao.selectList(wrapper);
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<NewsOrderList> wrapper = this.getSearchWrapper(map);

    Integer count = newsOrderListDao.selectCount(wrapper);

    return count;
}



public boolean add(NewsOrderList u){

    int result = newsOrderListDao.insert(u);
    return result >0;

}

public boolean update(NewsOrderList u) {


    UpdateWrapper<NewsOrderList> updateWrapper = new UpdateWrapper<NewsOrderList>();
    updateWrapper.eq("id", u.getId());
       updateWrapper.set("newsid", u.getNewsid());
   updateWrapper.set("email", u.getEmail());
   updateWrapper.set("userCode", u.getUserCode());
   updateWrapper.set("note", u.getNote());
   updateWrapper.set("updatetime", u.getUpdatetime());
   updateWrapper.set("payState", u.getPayState());
   updateWrapper.set("payPrice", u.getPayPrice());
   updateWrapper.set("payTime", u.getPayTime());
   updateWrapper.set("tradeNo", u.getTradeNo());
   updateWrapper.set("orderId", u.getOrderId());
   updateWrapper.set("payUrl", u.getPayUrl());
   updateWrapper.set("userid", u.getUserid());

    int result = newsOrderListDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(NewsOrderList u,Map<String, Object> map) {

    QueryWrapper<NewsOrderList> wrapper = new QueryWrapper<NewsOrderList>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = newsOrderListDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    newsOrderListDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<NewsOrderList> wrapper = new QueryWrapper<NewsOrderList>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        newsOrderListDao.delete(wrapper);
     }

}
