package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.*;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import com.gfrjxz.cms.util.DateCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

 

    /**
     * @description 001 根据用户id获取一个用户实例
     * @param
     * @author
     * @date
     * @return
     */
    public Member getSinger(Integer id){

        QueryWrapper<Member> wrapper = new QueryWrapper<Member>();
        wrapper.eq("id", id);
        Member u = memberDao.selectOne(wrapper);
        return u;

    }

    public Member getSingerBy(Map<String,Object> map){

        QueryWrapper<Member> wrapper = new QueryWrapper<Member>();
        for (String key : map.keySet()) {
            wrapper.eq(key, map.get(key));
        }
        wrapper.last("limit 1");
        Member u = memberDao.selectOne(wrapper);
        return u;

    }

    public List<Member> getAll(){

        QueryWrapper<Member> wrapper = new QueryWrapper<Member>();
        wrapper.ne("id", 0);
        return memberDao.selectList(wrapper);
    }


    private QueryWrapper<Member> getSearchWrapper(Map<String, Object> map){

        QueryWrapper<Member> wrapper = new QueryWrapper<Member>();
        if (map!=null &&  map.size() > 0){    

            for (String key : map.keySet()) {
                wrapper.like(key, map.get(key));
            }

        }       
        return wrapper;

    }

    public List<Member> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

        pageSize = pageSize > 0 ? pageSize : 20;
        pageIndex = pageIndex <= 1 ? 1 : pageIndex;
        Integer offset=(pageIndex - 1) * pageSize;
        QueryWrapper<Member> wrapper =  this.getSearchWrapper(map);
        wrapper.last("limit "+ offset+","+ pageSize);
        wrapper.orderByDesc("id") ;
        return memberDao.selectList(wrapper);
    }


    public Integer getSearchCount(Map<String, Object> map) {

        QueryWrapper<Member> wrapper = this.getSearchWrapper(map);
        Integer count = memberDao.selectCount(wrapper);

        return count;
    }



    public boolean add(Member u){

        u.setCreatetime(DateCommon.getNowToday());
        u.setUpdatetime(DateCommon.getNowToday());
        int result = memberDao.insert(u);
        return result >0;

    }

    public boolean update(Member u) {

        UpdateWrapper<Member> updateWrapper = new UpdateWrapper<Member>();
        updateWrapper.eq("id", u.getId());
        updateWrapper.set("name", u.getName());
        updateWrapper.set("headerpic", u.getHeaderpic());
        updateWrapper.set("email", u.getEmail());
        updateWrapper.set("mobile", u.getMobile());
        updateWrapper.set("sex", u.getSex());
        updateWrapper.set("birthday", u.getBirthday());
        updateWrapper.set("age", u.getAge());
        updateWrapper.set("intro", u.getIntro());
        //updateWrapper.set("createtime", u.getCreatetime());
        updateWrapper.set("homeplace", u.getHomeplace());
        updateWrapper.set("job", u.getJob());
        updateWrapper.set("education", u.getEducation());
        updateWrapper.set("idnumber", u.getIdnumber());
        updateWrapper.set("state", u.getState());
        updateWrapper.set("updatetime", DateCommon.getNowToday());

        int result = memberDao.update(null, updateWrapper);
        return result > 0;

    }

    public boolean updateBy(Member u,Map<String, Object> map) {

        QueryWrapper<Member> wrapper = new QueryWrapper<Member>();
        for (String key : map.keySet()) {
            wrapper.eq(key, map.get(key));
        }
        int result = memberDao.update(u, wrapper);
        return result > 0;

    }

    public void delete(Integer id){

        memberDao.deleteById(id);
    }

    public void deleteBy(Map<String, Object> map) {

        QueryWrapper<Member> wrapper = new QueryWrapper<Member>();
        for (String key : map.keySet()) {
            wrapper.eq(key, map.get(key));
        }
        memberDao.delete(wrapper);
    }

}
