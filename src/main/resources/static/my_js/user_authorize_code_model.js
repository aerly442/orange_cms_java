var userJson = {

 
    "id":"",
    "nickname":"",
    "openid":"",
    "mobile":"",
    "email":"",
    "code":"",
    "sendtime":"",
    "sendstate":"",
    "state":"",
    "createtime":"",
    "messagetype":""



}

var modeName = "user_authorize_code"
var frmName = "frmUserAuthorizeCode"
var headerJson =  {

    "id":"编号",
 
    "nickname":"昵称",
    "openid":"OpenId",
    "mobile":"手机号",
    "email":"Email",
    "code":"验证码",
    "sendtime":"发送时间",
    "sendstate":"发送状态",
    "state":"状态",
    
    "messagetype":"类型",
    "createtime":"创建时间",
    "action":"操作"
    

}
var listHeaderJson = {

    "id":"编号",
 
    "nickname":"昵称",
    "openid":"OpenId",
    "mobile":"手机号",
    "email":"Email",
    "code":"验证码",
    "sendtime":"发送时间",
    "sendstate":"发送状态",
 
    
    "messagetype":"类型",
    "createtime":"创建时间",
    "action":"操作"
 


} ;
var detailHeaderJson = headerJson ;
var editHeaderJson = headerJson ;

var fieldFunction = {    

    
    "sendstate":function(value,type){return  (type=="list")?(value=='1'?"已发":""):value},
    "messagetype":function(value,type){return  (type=="list")?(value=='01'?"短信":(value=='02'?"邮件":"")):value},

}
//在base_edit的set_edit_value_by_url 里面回调
//设置界面的时候回调用
var modeFunction = function(type){
    


}
//在base_edit的set_edit_value_by_url 后面执行
var jqFunction   = function(){


 
    

}