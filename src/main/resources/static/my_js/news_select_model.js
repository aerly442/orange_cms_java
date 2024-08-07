var userJson = {

 
    "id":"",
    "title":"",
    "content":"",
    "author":"",
    "source":"",
    "newsCategoriesCode":"",
    "mainpic":"",
    "file":"",
    "url":"",
    "sort":"",
    "state":"",
    "hot":"",
    "keyWord":"",
    "abstract1":"",
    "visit":"",
    "isCharge":"",
    "chargeStarttime":"",
    "chargeEndtime":"",
    "price":"",
    "isComment":"",
    "chargeType":"",
    "createtime":""

}

var modeName = "news"
var frmName  = "frmNews"
var headerJson =  {

    "id":"编号",
    "title":"标题",
    "content":"内容",
    "author":"作者",
    "source":"来源",
    
    "mainpic":"主图",
    "file":"文件",
    "url":"链接地址",
    "sort":"排序",
    "state":"状态",
    "hot":"首页",
    "keyWord":"关键字",
    "abstract1":"摘要",
    "visit":"访问量",
    "isCharge":"是否付费",
    "chargeStarttime":"付费开始",
    "chargeEndtime":"付费终止",
    "price":"单价",
    "isComment":"是否评论",
    "chargeType":"付费类型",
    "createtime":"创建时间",

    

}

var listHeaderJson = {

    "id":"编号",    
    "title":"标题", 
    "createtime":"创建时间",
    "selected":"选择"


} ;
var detailHeaderJson = headerJson ;
var editHeaderJson = headerJson ;

var fieldFunction = {    
 
    "selected":function(value,type,item){return  "<a href='javascript:setParentCtlValue(\""+item.title+"\",\""+item.id+"\")'>选择</a>"}
 

}
//设置界面的时候回调用
var modeFunction = function(type){
    
 


}

var jqFunction   = function(){
 
 

}
function setParentCtlValue(title,newsid){

     window.opener.document.getElementById('title').value = title ;
     window.opener.document.getElementById('newsid').value = newsid ;
     window.close();


}