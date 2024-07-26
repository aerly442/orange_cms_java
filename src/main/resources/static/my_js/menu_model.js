var userJson = {

 
     
    "id":"",
    "name":"",
    "cssclass":"",
    "linktext":"",
    "parentid":"",
    "createtime":"",
    "sort":"",
   


}

var modeName = "menu"
var frmName = "frmMenu"
var headerJson =  {

    "id": "编号",
    "name":"名称",
    "cssclass":"样式",
    "linktext":"链接",
    "parentid":"父菜单ID",
    "sort":"排序",
    "createtime":"创建时间",
    "action": "操作"
    

}

var listHeaderJson = headerJson ;
var detailHeaderJson = headerJson ;
var editHeaderJson = headerJson ;

var fieldFunction = {    

}
//设置界面的时候回调用
var modeFunction = function(type){
     
    let m = new BaseModel("menu");
    m.getall(function(data){
       
         if (data.code && data.code=='0'){
             let aryData = data.data ;
             let parentId = $("#parentid").val();
             $("#parentName").append("<option value=0>一级菜单</option>");
             aryData.forEach(function(item) {  

                 if (item.parentid =="0"){
                    let sel = parentId == item.id?"selected":"";                    
                    $("#parentName").append("<option "+sel+" value='"+item.id+"'>"+item.name+"</option>");
                     
                 }

                //console.log(item);  
              }); 
         }
        //console.log(data);     
     

    })


}

var jqFunction   = function(){

    $("#parentName").change(function(){
          
        $("#parentid").val(this.value);  

    });

}