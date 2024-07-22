package com.gfrjxz.cms.controller;

import com.gfrjxz.cms.entity.*;
import com.gfrjxz.cms.service.ManagerService;
import com.gfrjxz.cms.service.MenuRulerService;
 
import com.gfrjxz.cms.util.RessponseMessge;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("menu_ruler")
public class MenuRulerController {

    @Autowired
    private MenuRulerService menuRulerService;

    @Autowired
    private ManagerService managerService;
 

    //private static final Logger logger = LoggerFactory.getLogger(MenuRulerService.class);



    @RequestMapping(value = "/get_singer", method = RequestMethod.GET)
    public Object getSinger(@RequestParam(name="id") int id){

        //注意这里查的是managerid 一个用户对应一个菜单数据
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("managerid",id);
        MenuRuler m = menuRulerService.getSingerBy(map);
        if (m ==null || m.getId() ==  0 ){
          
            m = new MenuRuler();
            m.setManagerid(id);
            m.setMenuid("[0]");
            String username = managerService.getSinger(id).getUsername();
            m.setUsername(username);

         
        }
        return RessponseMessge.OK(m, "ok");

    }


    @RequestMapping(value = "/get_singer_by", method = RequestMethod.POST)
    public Object getSingerBy(@RequestBody MenuRuler menuRuler){
        
        HashMap<String,Object> mapWhere = new HashMap<String,Object>();
        mapWhere.put("id",menuRuler.getId());
        return RessponseMessge.OK(menuRulerService.getSingerBy(mapWhere), "ok");

    }

    //返回所的数据
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object getAll(){
         
        return RessponseMessge.OK(menuRulerService.getAll(), "ok");  

    }

    //根据条件返回所有的
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Object search(
        @RequestBody Map<String,Object> mapWhere,
        @RequestParam(name="pageSize",required=false,defaultValue="20")    Integer pageSize,    
        @RequestParam(name="pageIndex",required=false,defaultValue="0")    Integer pageIndex         
     ){

        Object o = menuRulerService.search(mapWhere,pageIndex,pageSize);
        int totalCount = menuRulerService.getSearchCount(mapWhere);
        return RessponseMessge.OK(o, String.valueOf(totalCount));
     }


         // 新增
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object add(@RequestBody  @Validated MenuRuler menuRuler) {

        boolean result = menuRuler.getId() >0 ?menuRulerService.update(menuRuler):menuRulerService.add(menuRuler);
        return RessponseMessge.OK(result, "ok");
    }

 

    @RequestMapping(value = "/updateby", method = RequestMethod.POST)
    public Object updateBy(@RequestBody MenuRuler menuRuler,
            @RequestParam(name="id")    String id
    ){

        HashMap<String,Object> mapData = new HashMap<String,Object>() ;   
        mapData.put("Id",0); //更新条件1,最多支持三个
        boolean  result =menuRulerService.updateBy(menuRuler,mapData);
        return RessponseMessge.OK(result, "ok");


    }

    //删除
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object delete(@RequestParam(name="id") int id){

        menuRulerService.delete(id);
        return RessponseMessge.OK("1", "ok");  

    }

    @RequestMapping(value = "/deleteby", method = RequestMethod.POST)
    public Object deleteBy(@RequestBody MenuRuler menuRuler){


        HashMap<String,Object> mapWhere = new HashMap<String,Object>() ;
        mapWhere.put("id",1);
        menuRulerService.deleteBy(mapWhere);
        return RessponseMessge.OK("1", "ok");  

    }

 
}
