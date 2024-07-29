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
    
    let m = new BaseModel("news_categories");
    m.getall(function(data){
       
         if (data.code && data.code=='0'){
             let aryData = data.data ;
             let currentCode  = $("#newsCategoriesCode").val();
             //$("#parentName").append("<option value=0>一级菜单</option>");
             aryData.forEach(function(item) {  

                    let sel = currentCode == item.code?"selected":"";                    
                    $("#selNewsCategoriesCode").append("<option "+sel+" value='"+item.code+"'>"+item.name+"</option>");

              }); 
         }
     

    })

 
    try{
        if (type !="list"){
            ue.ready(function(){

                    let newsContent = $("#content").val();
                    ue.setContent(newsContent);

            })
        }
    }
    catch(error)
    {

    }


}

var jqFunction   = function(){

    $("#selNewsCategoriesCode").change(function(){
          
        $("#newsCategoriesCode").val(this.value);  

    });

   $(".btnNews").click(function(){

     var c       = UE.getEditor('myEditor').getContent() ;
     var content = UE.getEditor('myEditor').getPlainTxt() ;

     if (content=='' || content=='\n') { 
        alert('请输入内容');
        return false ;
       
     } 
      else{              
        $('#content').val(c);
        $("#frmNews").submit();  
     }

   });  
 

}