var userJson = {

 
     
    "id":"",
    "newsid":"",
    "newsresourceid":"",
    "createtime":"",
    "updatetime":""


}

var modeName = "news_resource_list"
var frmName = "frmNewsResourceList"
var headerJson =  {

    "id":"编号",
    "newsid":"内容Id",
    "newsresourceid":"资源Id",
    "createtime":"创建时间",
    "updatetime":"更新时间",
    "action": "操作"
 

}
var listHeaderJson = {

    "id":"编号",
 
    "title":"标题",
    "ctitle":"资源名称",
    "resource":"资源内容",
 
    "createtime":"创建时间",

    "action": "操作"

} ;
var detailHeaderJson = headerJson ;
var editHeaderJson = headerJson ;

var fieldFunction = {    

    "title":function(value,type,item){return  (type=="list")?(value+"("+item.newsid+")"):value},
    "ctitle":function(value,type,item){return  (type=="list")?(value+"("+item.newsresourceid+")"):value},

}
//在base_edit的set_edit_value_by_url 里面回调
//设置界面的时候回调用
var modeFunction = function(type){
    


}
//在base_edit的set_edit_value_by_url 后面执行
var jqFunction   = function(){


 
    

}