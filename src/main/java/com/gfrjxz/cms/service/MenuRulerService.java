package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.dao.MenuRulerDao;

import com.gfrjxz.cms.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


@Service
public class MenuRulerService {

@Autowired
private MenuRulerDao menuRulerDao;

 

/**
* @description 001 根据用户id获取一个用户实例
* @param
* @author
* @date
* @return
*/
public MenuRuler getSinger(Integer id){

    QueryWrapper<MenuRuler> wrapper = new QueryWrapper<MenuRuler>();
    wrapper.eq("id", id);
    MenuRuler u = menuRulerDao.selectOne(wrapper);
    return u;

 }

public MenuRuler getSingerBy(Map<String,Object> map){

    QueryWrapper<MenuRuler> wrapper = new QueryWrapper<MenuRuler>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    wrapper.last("limit 1");
    MenuRuler u = menuRulerDao.selectOne(wrapper);
    return u;

}

public List<MenuRuler> getAll(){

    QueryWrapper<MenuRuler> wrapper = new QueryWrapper<MenuRuler>();
    wrapper.ne("id", 0);
    return menuRulerDao.selectList(wrapper);
}
private QueryWrapper<MenuRuler> getSearchWrapper(Map<String, Object> map){

   
    QueryWrapper<MenuRuler> wrapper = new QueryWrapper<MenuRuler>();
    if (map!=null &&  map.size() > 0){    

        for (String key : map.keySet()) {
            wrapper.like(key, map.get(key));
        }

    }       
    return wrapper;
   


}

public List<MenuRuler> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

     pageSize = pageSize > 0 ? pageSize : 20;
     pageIndex = pageIndex <= 1 ? 1 : pageIndex;
     Integer offset=(pageIndex - 1) * pageSize;
     QueryWrapper<MenuRuler> wrapper = this.getSearchWrapper(map);
     wrapper.last("limit "+ offset+","+ pageSize);
     return menuRulerDao.selectList(wrapper);
  }


public Integer getSearchCount(Map<String, Object> map) {

    QueryWrapper<MenuRuler> wrapper = this.getSearchWrapper(map);

    Integer count = menuRulerDao.selectCount(wrapper);

    return count;
}



public boolean add(MenuRuler u){

    int result = menuRulerDao.insert(u);
    return result >0;

}

public boolean update(MenuRuler u) {

    UpdateWrapper<MenuRuler> updateWrapper = new UpdateWrapper<MenuRuler>();
    updateWrapper.eq("id", u.getId());
    updateWrapper.set("username", u.getUsername());
    updateWrapper.set("menuid", u.getMenuid());
    updateWrapper.set("managerid", u.getManagerid());

    int result = menuRulerDao.update(null, updateWrapper);
    return result > 0;

}

public boolean updateBy(MenuRuler u,Map<String, Object> map) {

    QueryWrapper<MenuRuler> wrapper = new QueryWrapper<MenuRuler>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
    }
    int result = menuRulerDao.update(u, wrapper);
    return result > 0;

}

public void delete(Integer id){

    menuRulerDao.deleteById(id);
}

public void deleteBy(Map<String, Object> map) {

    QueryWrapper<MenuRuler> wrapper = new QueryWrapper<MenuRuler>();
    for (String key : map.keySet()) {
        wrapper.eq(key, map.get(key));
        }
        menuRulerDao.delete(wrapper);
     }

}
