package com.gfrjxz.cms.controller;

import com.gfrjxz.cms.entity.*;
import com.gfrjxz.cms.service.NewsResourceListService;
import com.gfrjxz.cms.service.NewsService;
import com.gfrjxz.cms.service.NewsTagService;

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

    @Autowired
    private NewsResourceListService newsResourceListService;

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
        @RequestParam(name="tag",required=false,defaultValue="")    String tag,  
        @RequestParam(name="pageSize",required=false,defaultValue="20")    Integer pageSize,    
        @RequestParam(name="pageIndex",required=false,defaultValue="0")    Integer pageIndex         
     ){
        HashMap<String,Object> mapWhere = new HashMap<String,Object>();
        
        //String mTag = "";
        if (StrUtil.isNullOrEmpty(cid)==false){
            mapWhere.put("c.code",cid);
        }
        if (StrUtil.isNullOrEmpty(ctitle)==false){
            mapWhere.put("title",ctitle);
        }

        if (StrUtil.isNullOrEmpty(tag)==false){

            tag = StrUtil.getClearString(tag);
        }
        Object o = newsService.searchForFront(mapWhere,pageIndex,pageSize,tag);
        int totalCount = newsService.getListForFrontCount(mapWhere,tag);
        return RessponseMessge.OK(o, String.valueOf(totalCount));
     }

    @RequestMapping(value = "/get_tag_list", method = RequestMethod.GET)
    public Object getTagList(
             
     ){
        
        Object o = newsTagService.getList();
        return RessponseMessge.OK(o, String.valueOf(0));
     }

     @RequestMapping(value = "/get_hot_list", method = RequestMethod.GET)
     public Object getHotList(
              
      ){
         
         Object o = newsService.getHotList();
         return RessponseMessge.OK(o, String.valueOf(0));
      }

      @RequestMapping(value = "/get_detail", method = RequestMethod.GET)
      public Object getDetail(
        @RequestParam(name="id",required=false,defaultValue="0")    Integer id
       ){
          
            News news = newsService.getSinger(id);
            if (news.getState() == 1){
                return RessponseMessge.OK(news, "成功");
            }
            else{
                return RessponseMessge.Error(null,"获取数据错误"); 
            }
       }

       @RequestMapping(value = "/get_detail_download", method = RequestMethod.GET)
       public Object getDetailDownload(
         @RequestParam(name="id",required=false,defaultValue="0")    Integer id
        ){
           
            NewsResourceListDTO news = newsResourceListService.getSingerByNewsId(id);
            return RessponseMessge.OK(news, "成功");
   
        }

        @RequestMapping(value = "/update_visit", method = RequestMethod.GET)
        public Object updateVisit(
          @RequestParam(name="id",required=false,defaultValue="0")    Integer id
         ){
            
            newsService.updateVisit(id) ;
            return RessponseMessge.OK("1", "成功");
    
         }
 
}
