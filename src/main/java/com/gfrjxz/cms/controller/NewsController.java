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

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

 

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

    //返回所的数据
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object getAll(){
         
        return RessponseMessge.OK(newsService.getAll(), "ok");  

    }

    //根据条件返回所有的
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Object search(
        @RequestBody Map<String,Object> mapWhere,
        @RequestParam(name="pageSize",required=false,defaultValue="20")    Integer pageSize,    
        @RequestParam(name="pageIndex",required=false,defaultValue="0")    Integer pageIndex         
     ){

        Object o = newsService.search(mapWhere,pageIndex,pageSize);
        int totalCount = newsService.getSearchCount(mapWhere);
        return RessponseMessge.OK(o, String.valueOf(totalCount));
     }


         // 新增
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object add(@RequestBody  @Validated News news) {

        boolean result = news.getId() >0 ?newsService.update(news):newsService.add(news);
        return RessponseMessge.OK(result, "ok");
    }

 

    @RequestMapping(value = "/updateby", method = RequestMethod.POST)
    public Object updateBy(@RequestBody News news,
            @RequestParam(name="id")    String id
    ){

        HashMap<String,Object> mapData = new HashMap<String,Object>() ;   
        mapData.put("Id",0); //更新条件1,最多支持三个
        boolean  result =newsService.updateBy(news,mapData);
        return RessponseMessge.OK(result, "ok");


    }

    //删除
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object delete(@RequestParam(name="id") int id){

        newsService.delete(id);
        return RessponseMessge.OK("1", "ok");  

    }

    @RequestMapping(value = "/deleteby", method = RequestMethod.POST)
    public Object deleteBy(@RequestBody News news){


        HashMap<String,Object> mapWhere = new HashMap<String,Object>() ;
        mapWhere.put("id",1);
        newsService.deleteBy(mapWhere);
        return RessponseMessge.OK("1", "ok");  

    }

 
}
