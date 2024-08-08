var userJson = {

    			 
     
    "id":"",
    "resource":"",
    "note":"",

    "title":"",
    "state":"",
    
    "seed":"",
    "violationCnt":"",
    "clickPv":"",
    "savePv":"",
    
    "expiredAt":"",
    "lastSavePv":"",
    "lastClickPv":"",
    "checktime":"",
    "expiredDays":"",
    "createtime":"",
    "updatetime":""


}

var modeName = "news_resource"
var frmName = "frmNewsResource"
var headerJson =  {

    "id":"编号",
    "title":"资源名称",
    "resource":"资源内容", 
    "seed":"唯一标识",
    "violationCnt":"违规",
    "clickPv":"浏览",
    "savePv":"保存",  
    "expiredAt":"失效日",
    "lastSavePv":"上次保存",
    "lastClickPv":"上次浏览",
    "checktime":"检查日期",
    "expiredDays":"有效天",
    "state":"状态",
    "createtime":"保存时间",
    "updatetime":"更新时间",
    "action": "操作"
    

}
var listHeaderJson = 


    {

        "id":"编号",
        "title":"资源名称",
        "resource":"资源内容",              
        "clickPv":"浏览",
        "savePv":"保存",  
        "violationCnt":"违规",
        "expiredAt":"失效",
        "checktime":"检查日期",
        "updatetime":"更新时间",
        "action": "操作"
        
    
    } ;
var detailHeaderJson = headerJson ;
var editHeaderJson = headerJson ;

var fieldFunction = {    

    "state":function(value,type){return  (type=="list")?(value=='1'?"":"屏蔽"):value},
    "expiredAt":function(value,type){return  (type=="list")?(value.substring(0,10)):value},
    "checktime":function(value,type){return  (type=="list")?(value.substring(0,10)):value},
    "updatetime":function(value,type){return  (type=="list")?(value.substring(0,10)):value},

}
//在base_edit的set_edit_value_by_url 里面回调
//设置界面的时候回调用
var modeFunction = function(type){
    


}
//在base_edit的set_edit_value_by_url 后面执行
var jqFunction   = function(){


 
    

}