package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.UserAuthorizeCodeDao;

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
public class UserAuthorizeCodeService {

@Autowired
private UserAuthorizeCodeDao userAuthorizeCodeDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public UserAuthorizeCode getSinger(Integer id){

    QueryWrapper<UserAuthorizeCode> wrapper = new QueryWrapper<UserAuthorizeCode>();
    wrapper.eq("id", id);
    UserAuthorizeCode u = userAuthorizeCodeDao.selectOne(wrapper);
    return u;

 }

public UserAuthorizeCode getSingerBy(Map<String,Object> map){

    QueryWrapper<UserAuthorizeCode> wrapper = new QueryWrapper<UserAuthorizeCode>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    UserAuthorizeCode u = userAuthorizeCodeDao.selectOne(wrapper);
    return u;

}

public List<UserAuthorizeCode> getAll(){

    QueryWrapper<UserAuthorizeCode> wrapper = new QueryWrapper<UserAuthorizeCode>();
    wrapper.ne("id", 0);
    return userAuthorizeCodeDao.selectList(wrapper);
}
private QueryWrapper<UserAuthorizeCode> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<UserAuthorizeCode> wrapper = new QueryWrapper<UserAuthorizeCode>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<UserAuthorizeCode> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     QueryWrapper<UserAuthorizeCode> wrapper = this.getSearchWrapper(map);
     wrapper.last("limit "+ offset+","+ pageSize);
     wrapper.orderByDesc("id") ;
     return userAuthorizeCodeDao.selectList(wrapper);
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<UserAuthorizeCode> wrapper = this.getSearchWrapper(map);

    Integer count = userAuthorizeCodeDao.selectCount(wrapper);

    return count;
}



public boolean add(UserAuthorizeCode u){

    int result = userAuthorizeCodeDao.insert(u);
    return result >0;

}

public boolean update(UserAuthorizeCode u) {


    UpdateWrapper<UserAuthorizeCode> updateWrapper = new UpdateWrapper<UserAuthorizeCode>();
    updateWrapper.eq("id", u.getId());
       updateWrapper.set("nickname", u.getNickname());
   updateWrapper.set("openid", u.getOpenid());
   updateWrapper.set("mobile", u.getMobile());
   updateWrapper.set("email", u.getEmail());
   updateWrapper.set("code", u.getCode());
   updateWrapper.set("sendtime", u.getSendtime());
   updateWrapper.set("sendstate", u.getSendstate());
   updateWrapper.set("state", u.getState());
   updateWrapper.set("messagetype", u.getMessagetype());

    int result = userAuthorizeCodeDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(UserAuthorizeCode u,Map<String, Object> map) {

    QueryWrapper<UserAuthorizeCode> wrapper = new QueryWrapper<UserAuthorizeCode>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = userAuthorizeCodeDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    userAuthorizeCodeDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<UserAuthorizeCode> wrapper = new QueryWrapper<UserAuthorizeCode>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        userAuthorizeCodeDao.delete(wrapper);
     }

}
