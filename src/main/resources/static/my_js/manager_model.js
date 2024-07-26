var userJson = {

"id":"0",
"username":"",
"password":"",
"name":"",
"tel":"",
"depart":"",
"power":"",
"lastlogindatetime":"",
"lastloginip":"",
"createtime":"",
"corpid":""

}

var modeName = "manager"
var frmName = "frmManager"
var headerJson =  {

    "id": "编号",
    "username":"用户名",
    "password":"密码",
    "name":"姓名",
    "tel":"联系方式",
    "depart":"部门",
    "power":"账号类型",
    "lastlogindatetime":"登录时间",
    "lastloginip":"登录IP",
    "createtime":"创建时间", 
    "setting":"设置",
    "action": "操作"

}

var listHeaderJson = headerJson ;
var detailHeaderJson = headerJson ;
var editHeaderJson = headerJson ;


//遇到这个字段则使用回调函数处理
var fieldFunction = {
    //如果是list页面字段为power则调用回调函数
    "power":function(value,type){return  (type=="list")?(value=="1" ?"管理员":"普通用户"):value},
    "createtime":function(value,type){return value?value.replace(" 00:00:00",""):value},
    "lastlogindatetime":function(value,type){return value?value.replace(" 00:00:00",""):value},
    "setting":function(value,type,item){return type=="list"?"<a href='menu_ruler_edit.html?id="+item.id+"' target='_blank'>设置</a>":""}

}

//设置界面的时候回调用
var modeFunction = function(type){

    let userPower = $("#power").val();
    let aryData = [
        {"name":"普通用户","value":"2"},
        {"name":"管理员","value":"1"}
    ];
    aryData.forEach(function(item) {  
           let sel = userPower == item.value?"selected":"";                    
           $("#powerName").append("<option "+sel+" value='"+item.value+"'>"+item.name+"</option>");

     }); 


}
//注入到jQuery中处理的方法
var jqFunction   = function(){

    $("#powerName").change(function(){
          
        $("#power").val(this.value);  

    });


}