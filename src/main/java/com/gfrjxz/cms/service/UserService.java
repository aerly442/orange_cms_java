package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.UserDao;

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
public class UserService {

@Autowired
private UserDao userDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public User getSinger(Integer id){

    QueryWrapper<User> wrapper = new QueryWrapper<User>();
    wrapper.eq("id", id);
    User u = userDao.selectOne(wrapper);
    return u;

 }

public User getSingerBy(Map<String,Object> map){

    QueryWrapper<User> wrapper = new QueryWrapper<User>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    User u = userDao.selectOne(wrapper);
    return u;

}

public List<User> getAll(){

    QueryWrapper<User> wrapper = new QueryWrapper<User>();
    wrapper.ne("id", 0);
    return userDao.selectList(wrapper);
}
private QueryWrapper<User> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<User> wrapper = new QueryWrapper<User>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<User> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     QueryWrapper<User> wrapper = this.getSearchWrapper(map);
     wrapper.last("limit "+ offset+","+ pageSize);
     wrapper.orderByDesc("id") ;
     return userDao.selectList(wrapper);
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<User> wrapper = this.getSearchWrapper(map);

    Integer count = userDao.selectCount(wrapper);

    return count;
}



public boolean add(User u){

    int result = userDao.insert(u);
    return result >0;

}

public boolean update(User u) {


    UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
    updateWrapper.eq("id", u.getId());
       updateWrapper.set("username", u.getUsername());
   updateWrapper.set("email", u.getEmail());
   updateWrapper.set("mobile", u.getMobile());
   updateWrapper.set("password", u.getPassword());
   updateWrapper.set("nickname", u.getNickname());
   updateWrapper.set("headerpic", u.getHeaderpic());
   updateWrapper.set("sex", u.getSex());
   updateWrapper.set("birthday", u.getBirthday());
   updateWrapper.set("age", u.getAge());
   updateWrapper.set("openid", u.getOpenid());
   updateWrapper.set("sns", u.getSns());
   updateWrapper.set("snstype", u.getSnstype());
   updateWrapper.set("continent", u.getContinent());
   updateWrapper.set("country", u.getCountry());
   updateWrapper.set("city", u.getCity());
   updateWrapper.set("intro", u.getIntro());
   updateWrapper.set("active", u.getActive());
   updateWrapper.set("activetime", u.getActivetime());
   updateWrapper.set("ismaster", u.getIsmaster());
   updateWrapper.set("isauthorized", u.getIsauthorized());
   updateWrapper.set("state", u.getState());
   updateWrapper.set("totalmoney", u.getTotalmoney());
   updateWrapper.set("lastlogindatetime", u.getLastlogindatetime());
   updateWrapper.set("logincount", u.getLogincount());
   updateWrapper.set("totalscore", u.getTotalscore());
   updateWrapper.set("masterScore", u.getMasterScore());
   updateWrapper.set("funsCount", u.getFunsCount());
   updateWrapper.set("friendsCount", u.getFriendsCount());
   updateWrapper.set("careusersCount", u.getCareusersCount());
   updateWrapper.set("homeplace", u.getHomeplace());
   updateWrapper.set("job", u.getJob());
   updateWrapper.set("school", u.getSchool());
   updateWrapper.set("language", u.getLanguage());
   updateWrapper.set("tripplace", u.getTripplace());
   updateWrapper.set("interest", u.getInterest());
   updateWrapper.set("aim", u.getAim());
   updateWrapper.set("updatetime", u.getUpdatetime());
   updateWrapper.set("usertype", u.getUsertype());
   updateWrapper.set("name", u.getName());
   updateWrapper.set("recommendUserid", u.getRecommendUserid());
   updateWrapper.set("recommendCode", u.getRecommendCode());
   updateWrapper.set("loginType", u.getLoginType());
   updateWrapper.set("adjustType", u.getAdjustType());

    int result = userDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(User u,Map<String, Object> map) {

    QueryWrapper<User> wrapper = new QueryWrapper<User>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = userDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    userDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<User> wrapper = new QueryWrapper<User>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        userDao.delete(wrapper);
     }

}
