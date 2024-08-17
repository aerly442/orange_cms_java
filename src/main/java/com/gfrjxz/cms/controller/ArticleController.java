package com.gfrjxz.cms.controller;

import com.gfrjxz.cms.entity.*;
 
 
import com.gfrjxz.cms.service.NewsService;
 
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

import com.gfrjxz.cms.util.*;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private NewsService newsService;

     @Autowired
    private NewsTagService newsTagService;

    //private static final Logger logger = LoggerFactory.getLogger(NewsService.class);



    @RequestMapping(value = "/get_singer", method = RequestMethod.GET)
    public Object getSinger(@RequestParam(name="id") int id){

        return RessponseMessge.OK(newsService.getSinger(id), "ok");

    }


    @RequestMapping(value = "/get_singer_by", method = RequestMethod.POST)
    public Object getSingerBy(@RequestBody News news){
        
        HashMap<String,Object> mapWhere = new HashMap<String,Object>();
        mapWhere.put("id",news.getId());
        return RessponseMessge.OK(newsService.getSingerBy(mapWhere), "ok");

    }

 

    //根据条件返回所有的
    @RequestMapping(value = "/get_news_list", method = RequestMethod.GET)
    public Object search(
        @RequestParam(name="cid",required=false,defaultValue="")    String cid,    
        @RequestParam(name="ctitle",required=false,defaultValue="")    String ctitle,  
        @RequestParam(name="pageSize",required=false,defaultValue="20")    Integer pageSize,    
        @RequestParam(name="pageIndex",required=false,defaultValue="0")    Integer pageIndex         
     ){
        HashMap<String,Object> mapWhere = new HashMap<String,Object>();
        
        if (StrUtil.isNullOrEmpty(cid)==false){
            mapWhere.put("c.code",cid);
        }
        if (StrUtil.isNullOrEmpty(ctitle)==false){
            mapWhere.put("title",ctitle);
        }
        //mapWhere.put("",news.getId());
   
        Object o = newsService.searchForFront(mapWhere,pageIndex,pageSize);
        int totalCount = newsService.getSearchCount(mapWhere);
        return RessponseMessge.OK(o, String.valueOf(totalCount));
     }

    @RequestMapping(value = "/get_tag_list", method = RequestMethod.GET)
    public Object get_tag_list(
             
     ){
        
        Object o = newsTagService.getList();
        return RessponseMessge.OK(o, String.valueOf(0));
     }
 
}
