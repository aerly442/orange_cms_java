package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

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
public class MenuService {

    @Autowired
    private MenuDao menuDao;

 

    /**
     * @description 001 根据用户id获取一个用户实例
     * @param
     * @author
     * @date
     * @return
     */
    public Menu getSinger(Integer id) {

        QueryWrapper<Menu> wrapper = new QueryWrapper<Menu>();
        wrapper.eq("id", id);
        Menu u = menuDao.selectOne(wrapper);
        return u;

    }

    public Menu getSingerBy(Map<String, Object> map) {

        QueryWrapper<Menu> wrapper = new QueryWrapper<Menu>();
        for (String key : map.keySet()) {
            wrapper.eq(key, map.get(key));
        }
        wrapper.last("limit 1");
        Menu u = menuDao.selectOne(wrapper);
        return u;

    }

    public List<Menu> getAll() {

        QueryWrapper<Menu> wrapper = new QueryWrapper<Menu>();
        wrapper.ne("id", 0);
        wrapper.orderByDesc("sort");
        return menuDao.selectList(wrapper);
    }

    private QueryWrapper<Menu> getSearchWrapper(Map<String, Object> map) {


        QueryWrapper<Menu> wrapper = new QueryWrapper<Menu>();
        if (map!=null &&  map.size() > 0){    

            for (String key : map.keySet()) {
                wrapper.like(key, map.get(key));
            }

        }       
        return wrapper;

    }

    public List<Menu> search(Map<String, Object> map, Integer pageIndex, Integer pageSize) {

        pageSize = pageSize > 0 ? pageSize : 20;
        pageIndex = pageIndex <= 1 ? 1 : pageIndex;
        Integer offset = (pageIndex - 1) * pageSize;
        QueryWrapper<Menu> wrapper = this.getSearchWrapper(map);
        wrapper.last("limit " + offset + "," + pageSize);
        wrapper.orderByDesc("id") ;
        return menuDao.selectList(wrapper);
    }

    public Integer getSearchCount(Map<String, Object> map) {

        QueryWrapper<Menu> wrapper = this.getSearchWrapper(map);

        Integer count = menuDao.selectCount(wrapper);

        return count;
    }

    public boolean add(Menu u) {

        
        u.setCreatetime(DateCommon.getNowToday());
        int result = menuDao.insert(u);
        return result > 0;

    }

    public boolean update(Menu u) {

        UpdateWrapper<Menu> updateWrapper = new UpdateWrapper<Menu>();
        
        updateWrapper.eq("id", u.getId());

        updateWrapper.set("name", u.getName());
        updateWrapper.set("cssclass", u.getCssclass());
        updateWrapper.set("linktext", u.getLinktext());
        updateWrapper.set("parentid", u.getParentid());
       // updateWrapper.set("createtime", u.getCreatetime());
        updateWrapper.set("sort", u.getSort());

        int result = menuDao.update(null, updateWrapper);
        return result > 0;

    }

    public boolean updateBy(Menu u, Map<String, Object> map) {

        QueryWrapper<Menu> wrapper = new QueryWrapper<Menu>();
        for (String key : map.keySet()) {
            wrapper.eq(key, map.get(key));
        }
        int result = menuDao.update(u, wrapper);
        return result > 0;

    }

    public void delete(Integer id) {

        menuDao.deleteById(id);
    }

    public void deleteBy(Map<String, Object> map) {

        QueryWrapper<Menu> wrapper = new QueryWrapper<Menu>();
        for (String key : map.keySet()) {
            wrapper.eq(key, map.get(key));
        }
        menuDao.delete(wrapper);
    }

}
