var userJson = {

 
     
    "id":"",
    "title":"",
    "clickPv":"",
    "reporttime":"",  
    "updatetime":"",
    "createtime":""


}

var modeName = "news_resource_visit_report"
var frmName = "frmNewsResourceVisitReport"
var headerJson =  {

    "id":"编号",
    "title":"标题",
    "clickPv":"点击量",
    "reporttime":"统计时间"
 
    

}
var listHeaderJson = headerJson ;
var detailHeaderJson = headerJson ;
var editHeaderJson = headerJson ;

var fieldFunction = {    

}
//在base_edit的set_edit_value_by_url 里面回调
//设置界面的时候回调用
var modeFunction = function(type){
    


}
//在base_edit的set_edit_value_by_url 后面执行
var jqFunction   = function(){


 
    

}

//重写查询json
var getSearchParameterFromModel = function(){
     
    let title     = $('#title').val();
    let starttime = $('#starttime').val();
    let endtime   = $('#endtime').val();
    let searchParameter = {
        "title":title,
        "starttime":starttime,
        "endtime":endtime
    };
    return searchParameter; 

}