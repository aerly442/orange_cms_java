package com.gfrjxz.cms.controller;

import com.gfrjxz.cms.entity.*;
 
 
import com.gfrjxz.cms.service.NewsOrderListService;
 
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
@RequestMapping("news_order_list")
public class NewsOrderListController {

    @Autowired
    private NewsOrderListService newsOrderListService;

 

    //private static final Logger logger = LoggerFactory.getLogger(NewsOrderListService.class);



    @RequestMapping(value = "/get_singer", method = RequestMethod.GET)
    public Object getSinger(@RequestParam(name="id") int id){

        return RessponseMessge.OK(newsOrderListService.getSinger(id), "ok");

    }


    @RequestMapping(value = "/get_singer_by", method = RequestMethod.POST)
    public Object getSingerBy(@RequestBody NewsOrderList newsOrderList){
        
        HashMap<String,Object> mapWhere = new HashMap<String,Object>();
        mapWhere.put("id",newsOrderList.getId());
        return RessponseMessge.OK(newsOrderListService.getSingerBy(mapWhere), "ok");

    }

    //返回所的数据
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object getAll(){
         
        return RessponseMessge.OK(newsOrderListService.getAll(), "ok");  

    }

    //根据条件返回所有的
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Object search(
        @RequestBody Map<String,Object> mapWhere,
        @RequestParam(name="pageSize",required=false,defaultValue="20")    Integer pageSize,    
        @RequestParam(name="pageIndex",required=false,defaultValue="0")    Integer pageIndex         
     ){

        Object o = newsOrderListService.search(mapWhere,pageIndex,pageSize);
        int totalCount = newsOrderListService.getSearchCount(mapWhere);
        return RessponseMessge.OK(o, String.valueOf(totalCount));
     }


         // 新增
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object add(@RequestBody  @Validated NewsOrderList newsOrderList) {

        boolean result = newsOrderList.getId() >0 ?newsOrderListService.update(newsOrderList):newsOrderListService.add(newsOrderList);
        return RessponseMessge.OK(result, "ok");
    }

 

    @RequestMapping(value = "/updateby", method = RequestMethod.POST)
    public Object updateBy(@RequestBody NewsOrderList newsOrderList,
            @RequestParam(name="id")    String id
    ){

        HashMap<String,Object> mapData = new HashMap<String,Object>() ;   
        mapData.put("Id",0); //更新条件1,最多支持三个
        boolean  result =newsOrderListService.updateBy(newsOrderList,mapData);
        return RessponseMessge.OK(result, "ok");


    }

    //删除
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object delete(@RequestParam(name="id") int id){

        newsOrderListService.delete(id);
        return RessponseMessge.OK("1", "ok");  

    }

    @RequestMapping(value = "/deleteby", method = RequestMethod.POST)
    public Object deleteBy(@RequestBody NewsOrderList newsOrderList){


        HashMap<String,Object> mapWhere = new HashMap<String,Object>() ;
        mapWhere.put("id",1);
        newsOrderListService.deleteBy(mapWhere);
        return RessponseMessge.OK("1", "ok");  

    }

 
}
