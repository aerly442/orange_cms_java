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
    "abstract":"",
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
    "abstract":"摘要",
    "visit":"访问量",
    "isCharge":"是否付费",
    "chargeStarttime":"付费开始",
    "chargeEndtime":"付费终止",
    "price":"单价",
    "isComment":"是否评论",
    "chargeType":"付费类型",
    "createtime":"创建时间",
    "action": "操作"
    

}

var listHeaderJson = {

    "id":"编号",    
    "title":"标题", 
    "newsCategoriesCode":"栏目",
    "hot":"首页推荐", 
    "visit":"访问量",
    "isCharge":"付费",
    "price":"单价",
    "sort":"排序",
    "state":"状态",
    "createtime":"创建时间",
    "action": "操作"


} ;
var detailHeaderJson = headerJson ;
var editHeaderJson = headerJson ;

var fieldFunction = {    
 
    "state":function(value,type){return  (type=="list")?(value=='1'?"":"屏蔽"):value},
    "hot":function(value,type){return  (type=="list")?(value=='1'?"是":""):value},
    "isCharge":function(value,type){return  (type=="list")?(value=='1'?"是":""):value}

}
//设置界面的时候回调用
var modeFunction = function(type){
    


}

var jqFunction   = function(){

 

}