var userJson = {

 
     
    "id":"",
    "title":"",
    "nickname":"",
    "content":"",
    "createtime":"",
    "updatetime":"",
    "state":"",
    "parentid":"",
    "userid":"",
    "likecount":"",
    "hatecount":"",
    "newsid":"",
    "createtime":""


}

var modeName = "news_comment"
var frmName = "frmNewsComment"
var headerJson =  {

    "id":"编号",
 
    "title":"标题",
    "nickname":"昵称",
    "content":"内容",
    "parentid":"父Id",
    "userid":"用户Id",
    "likecount":"点赞",
    "hatecount":"点踩",
    "newsid":"内容Id",
    "state":"状态",
    "updatetime":"更新时间",
    "createtime":"创建时间",
    "action": "操作"
    

}
var listHeaderJson = 


    {

        "id":"编号",     
        "title":"标题",
        "nickname":"昵称",
        "content":"内容",
        "likecount":"点赞",
        "hatecount":"点踩",
        "state":"状态",
        "updatetime":"更新时间",
  
        "action": "操作"
        
    
    } ;
var detailHeaderJson = headerJson ;
var editHeaderJson = headerJson ;

var fieldFunction = {    

    "state":function(value,type){return  (type=="list")?(value=='1'?"":"屏蔽"):value}

}
//在base_edit的set_edit_value_by_url 里面回调
//设置界面的时候回调用
var modeFunction = function(type){
    


}
//在base_edit的set_edit_value_by_url 后面执行
var jqFunction   = function(){


 
    

}