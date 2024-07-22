package com.gfrjxz.cms.controller;

import com.gfrjxz.cms.entity.*;
 
 
import com.gfrjxz.cms.service.NewsTagService;
 
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
@RequestMapping("news_tag")
public class NewsTagController {

    @Autowired
    private NewsTagService newsTagService;

 

    //private static final Logger logger = LoggerFactory.getLogger(NewsTagService.class);



    @RequestMapping(value = "/get_singer", method = RequestMethod.GET)
    public Object getSinger(@RequestParam(name="id") int id){

        return RessponseMessge.OK(newsTagService.getSinger(id), "ok");

    }


    @RequestMapping(value = "/get_singer_by", method = RequestMethod.POST)
    public Object getSingerBy(@RequestBody NewsTag newsTag){
        
        HashMap<String,Object> mapWhere = new HashMap<String,Object>();
        mapWhere.put("id",newsTag.getId());
        return RessponseMessge.OK(newsTagService.getSingerBy(mapWhere), "ok");

    }

    //返回所的数据
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object getAll(){
         
        return RessponseMessge.OK(newsTagService.getAll(), "ok");  

    }

    //根据条件返回所有的
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Object search(
        @RequestBody Map<String,Object> mapWhere,
        @RequestParam(name="pageSize",required=false,defaultValue="20")    Integer pageSize,    
        @RequestParam(name="pageIndex",required=false,defaultValue="0")    Integer pageIndex         
     ){

        Object o = newsTagService.search(mapWhere,pageIndex,pageSize);
        int totalCount = newsTagService.getSearchCount(mapWhere);
        return RessponseMessge.OK(o, String.valueOf(totalCount));
     }


         // 新增
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object add(@RequestBody  @Validated  NewsTag newsTag) {

        boolean result = newsTag.getId() >0 ?newsTagService.update(newsTag):newsTagService.add(newsTag);
        return RessponseMessge.OK(result, "ok");
    }

 

    @RequestMapping(value = "/updateby", method = RequestMethod.POST)
    public Object updateBy(@RequestBody NewsTag newsTag,
            @RequestParam(name="id")    String id
    ){

        HashMap<String,Object> mapData = new HashMap<String,Object>() ;   
        mapData.put("Id",0); //更新条件1,最多支持三个
        boolean  result =newsTagService.updateBy(newsTag,mapData);
        return RessponseMessge.OK(result, "ok");


    }

    //删除
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object delete(@RequestParam(name="id") int id){

        newsTagService.delete(id);
        return RessponseMessge.OK("1", "ok");  

    }

    @RequestMapping(value = "/deleteby", method = RequestMethod.POST)
    public Object deleteBy(@RequestBody NewsTag newsTag){


        HashMap<String,Object> mapWhere = new HashMap<String,Object>() ;
        mapWhere.put("id",1);
        newsTagService.deleteBy(mapWhere);
        return RessponseMessge.OK("1", "ok");  

    }

 
}
