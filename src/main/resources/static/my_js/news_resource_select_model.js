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
    "seed":"种子Id",
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
        "createtime":"创建时间",
        "selected":"选择"
 
        
    
    } ;
var detailHeaderJson = headerJson ;
var editHeaderJson = headerJson ;

var fieldFunction = {    

    "selected":function(value,type,item){return  "<a href='javascript:setParentCtlValue(\""+item.title+"\",\""+item.id+"\")'>选择</a>"}

}
//在base_edit的set_edit_value_by_url 里面回调
//设置界面的时候回调用
var modeFunction = function(type){
    


}
//在base_edit的set_edit_value_by_url 后面执行
var jqFunction   = function(){


 
    

}
function setParentCtlValue(title,newsid){

    window.opener.document.getElementById('ctitle').value = title ;
    window.opener.document.getElementById('newsresourceid').value = newsid ;
    window.close();


}