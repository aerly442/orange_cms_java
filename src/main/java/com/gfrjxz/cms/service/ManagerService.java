package com.gfrjxz.cms.service;

import com.gfrjxz.cms.dao.ManagerDao;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gfrjxz.cms.exception.UserException;
import com.gfrjxz.cms.util.DateCommon;
import com.gfrjxz.cms.util.EncryptUtil;
import com.gfrjxz.cms.util.RessponseMessge;
import com.gfrjxz.cms.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


@Service
public class ManagerService {

    @Autowired
    private ManagerDao managerDao;

 

    /**
     * @description 001 根据用户id获取一个用户实例
     * @param
     * @author
     * @date
     * @return
     */
    public Manager getSinger(Integer id){

        QueryWrapper<Manager> wrapper = new QueryWrapper<Manager>();
        wrapper.eq("id", id);
        Manager u = managerDao.selectOne(wrapper);
        return u;

    }

    public Manager getSingerBy(Map<String,Object> map){

        QueryWrapper<Manager> wrapper = new QueryWrapper<Manager>();
        for (String key : map.keySet()) {
            wrapper.eq(key, map.get(key));
        }
        wrapper.last("limit 1");
        Manager u = managerDao.selectOne(wrapper);
        return u;

    }
    /*检测用户是否登录成功*/
    public String checkUser(String userName,String passWord){

        HashMap<String,Object> mapWhere = new HashMap<String,Object>();
        passWord                        = StrUtil.getPassWord(passWord);
        mapWhere.put("username",userName);
        mapWhere.put("password",passWord);
        Manager user                   = this.getSingerBy(mapWhere);
        String token                   = "" ;
        if (user!=null && user.getId() >0){
            token = EncryptUtil.DESencode(String.valueOf(user.getId())); //加密的token
        }
        return token;

    }

    public List<Manager> getAll(){

        QueryWrapper<Manager> wrapper = new QueryWrapper<Manager>();
        wrapper.ne("id", 0);
        return managerDao.selectList(wrapper);
    }

    public List<Manager> search(Map<String, Object> map,Integer pageIndex,Integer pageSize) {

        pageSize = pageSize > 0 ? pageSize : 20;
        pageIndex = pageIndex <= 1 ? 1 : pageIndex;
        Integer offset=(pageIndex - 1) * pageSize;
        QueryWrapper<Manager> wrapper = new QueryWrapper<Manager>();
        for (String key : map.keySet()) {
            wrapper.eq(key, map.get(key));
        }

        wrapper.last("limit "+ offset+","+ pageSize);
        return managerDao.selectList(wrapper);
    }


    public Integer getSearchCount(Map<String, Object> map) {

        QueryWrapper<Manager> wrapper = new QueryWrapper<Manager>();
        for (String key : map.keySet()) {
            wrapper.eq(key, map.get(key));
        }

        Integer count = managerDao.selectCount(wrapper);

        return count;
    }



    public boolean add(Manager u){

        u.setLastlogindatetime(DateCommon.getNowToday());
        u.setCreatetime(DateCommon.getNowToday());
        String pwd = StrUtil.getPassWord(u.getPassword());
        u.setPassword(pwd);
        int result = managerDao.insert(u);
        return result >0;

    }

    public boolean update(Manager u) {

        UpdateWrapper<Manager> updateWrapper = new UpdateWrapper<Manager>();
        
        updateWrapper.eq("id", u.getId());

        String  oldPassword = this.getSinger(u.getId()).getPassword();
        updateWrapper.set("username", u.getUsername());
        if (!oldPassword.equals(u.getPassword())){
            String pwd = StrUtil.getPassWord(u.getPassword());
            updateWrapper.set("password",pwd);
        }
        updateWrapper.set("name", u.getName());

        updateWrapper.set("depart", u.getDepart());
        updateWrapper.set("power", u.getPower());
        updateWrapper.set("lastlogindatetime", u.getLastlogindatetime());

        updateWrapper.set("lastloginip", u.getLastloginip());
        updateWrapper.set("createtime", u.getCreatetime());


        int result = managerDao.update(null, updateWrapper);
        return result > 0;

    }

    //02 修改密碼
    public boolean updatePassword(String  token,String oldPassword,String newPassword) throws UserException{

        oldPassword  = StrUtil.getPassWord(oldPassword);
        newPassword  = StrUtil.getPassWord(newPassword);

        Integer id  = this.getUserId(token);
        UpdateWrapper<Manager> updateWrapper = new UpdateWrapper<Manager>();
        updateWrapper.eq("id", id);
        updateWrapper.eq("password", oldPassword);

        updateWrapper.set("password", newPassword);

        int result = managerDao.update(null, updateWrapper);
        return result > 0;

    }

    public boolean updateBy(Manager u,Map<String, Object> map) {

        QueryWrapper<Manager> wrapper = new QueryWrapper<Manager>();
        for (String key : map.keySet()) {
            wrapper.eq(key, map.get(key));
        }
        int result = managerDao.update(u, wrapper);
        return result > 0;

    }

    public void delete(Integer id){

        managerDao.deleteById(id);
    }

    public void deleteBy(Map<String, Object> map) {

        QueryWrapper<Manager> wrapper = new QueryWrapper<Manager>();
        for (String key : map.keySet()) {
            wrapper.eq(key, map.get(key));
        }
        managerDao.delete(wrapper);
    }

    /** 根据token获取用户  */
    public Integer getUserId(String token) throws UserException {

        if (token == null || token.equals("")){
            throw new UserException("token为空");
        }
        String strId = EncryptUtil.DESdecode(String.valueOf(token));
        if (strId == null || strId.equals("")){
            throw new UserException("token错误，无法解密");
        }
        Integer id   = Integer.parseInt(strId);

        return  id;

    }

    /** 根据token获取用户  */
    public Manager getUserByToken(String token) throws  UserException{

        Integer id   = this.getUserId(token);
        Manager u    = this.getSinger(id);
        return  u;

    }

}