package com.gfrjxz.cms.controller;

import com.gfrjxz.cms.config.Consts;
import com.gfrjxz.cms.entity.*;


import com.gfrjxz.cms.exception.UserException;
import com.gfrjxz.cms.service.ManagerService;

import com.gfrjxz.cms.util.RessponseMessge;

import com.gfrjxz.cms.util.StrUtil;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gfrjxz.cms.entity.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("manager")
//@CrossOrigin(origins = "*")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private HttpServletRequest request;

    //01 登录接口
   @RequestMapping(value="/login",method = RequestMethod.POST)
   public Object login(@RequestBody @Validated({ValidUpdateGroup.class}) Manager manager){

       String userName = manager.getUsername();
       String passWord = manager.getPassword();

       String token = managerService.checkUser(userName, passWord); //检测用户名和密码是否正确，是，返回token
       if (StrUtil.isNullOrEmpty(token) == false) {
           return RessponseMessge.OK(token, "登录成功");
       } else {
           return RessponseMessge.Error(null, "登录出错，用户名或密码错误");
       }

   }

   //02 修改密碼
    @RequestMapping(value="/change_password",method = RequestMethod.POST)
    public Object changePassword(@RequestBody @Validated ManagerDTO user,
                                 @RequestHeader(Consts.TOKEN_NAME) String token) throws UserException {

        String newPassword = user.getNewPassword();
        String oldPassword = user.getOldPassword();
        boolean blnChange  = managerService.updatePassword(token,oldPassword,newPassword);
        if ( blnChange){
            return RessponseMessge.OK(null, "修改成功");
        } else{
            return RessponseMessge.Error(null, "修改失败");
        }
    }

    @RequestMapping(value = "/get_singer", method = RequestMethod.GET)
    public Object getSinger(@RequestParam(name="id") int id){

        return RessponseMessge.OK(managerService.getSinger(id), "ok");

    }


    @RequestMapping(value = "/get_singer_by", method = RequestMethod.POST)
    public Object getSingerBy(@RequestBody Manager manager){

        HashMap<String,Object> mapWhere = new HashMap<String,Object>();
        mapWhere.put("id",manager.getId());
        return RessponseMessge.OK(managerService.getSingerBy(mapWhere), "ok");

    }

    //返回所的数据
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object getAll(){

        return RessponseMessge.OK(managerService.getAll(), "ok");

    }

    //根据条件返回所有的
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Object search(
        @RequestBody Map<String,Object> mapWhere,
        @RequestParam(name="pageSize",required=false,defaultValue="20")    Integer pageSize,    
        @RequestParam(name="pageIndex",required=false,defaultValue="0")    Integer pageIndex         
     ){

        Object o = managerService.search(mapWhere,pageIndex,pageSize);
        int totalCount = managerService.getSearchCount(mapWhere);
        return RessponseMessge.OK(o, String.valueOf(totalCount));
     }



    // 新增
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object add(@RequestBody  @Validated Manager manager) {

        boolean result = manager.getId() >0 ?managerService.update(manager):managerService.add(manager);
        return RessponseMessge.OK(result, "ok");
    }



    @RequestMapping(value = "/updateby", method = RequestMethod.POST)
    public Object updateBy(@RequestBody Manager manager,
                           @RequestParam(name="id")    String id
    ){

        HashMap<String,Object> mapData = new HashMap<String,Object>() ;
        mapData.put("Id",0); //更新条件1,最多支持三个
        boolean  result =managerService.updateBy(manager,mapData);
        return RessponseMessge.OK(result, "ok");


    }

    //删除
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object delete(@RequestParam(name="id") int id){

        managerService.delete(id);
        return RessponseMessge.OK("1", "ok");

    }

    @RequestMapping(value = "/deleteby", method = RequestMethod.POST)
    public Object deleteBy(@RequestBody Manager manager){

        HashMap<String,Object> mapWhere = new HashMap<String,Object>() ;
        mapWhere.put("id",1);
        managerService.deleteBy(mapWhere);
        return RessponseMessge.OK("1", "ok");

    }


}
