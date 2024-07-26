var userJson = {

 
     
    "id":"",
    
    "username":"",
    "menuid":"",
    "managerid":"",
    "createtime":""


}

var modeName = "menu_ruler"
var frmName = "frmMenuRuler"
var headerJson =  {

    "id": "编号",
    "username":"用户名",
    "menuid":"菜单ID",
    "managerid":"用户ID",
    "createtime":"创建时间",
    "action": "操作"
    

}
var listHeaderJson = headerJson ;
var detailHeaderJson = headerJson ;
var editHeaderJson = headerJson ;

var fieldFunction = {    

}
//在base_edit的set_edit_value_by_url 里面回调
//设置界面的时候回调用
var modeFunction = function(type){
    
    let menu = new BaseModel("menu");
    menu.getall(function(data){

        if (data.code && data.code=='0'){
            let aryData = data.data ;
            let menuHtml = "" ;
            aryData.forEach(function(item) {

                if (item.parentid =="0"){
                    let menuName = `<div class="row clearfix">
                                        <div class="col-lg-2 form-control-label"> 
                                            <label for="">${item.name}</label>
                                        </div>`;
                    let  sonMenuHtml = '';
                    for(let i = 0;i<aryData.length;i++){
                        if (aryData[i].parentid == item.id){

                            let sonMenu = aryData[i];

                            let menuid = $("#menuid").val();
                            let checkValue  = "" ;
                            if (menuid && menuid!=""){
                                 
                                let aryCheckData = JSON.parse(menuid);
                                for(let i=0;i<aryCheckData.length;i++){
                                    if (sonMenu.id ==aryCheckData[i]){
                                        checkValue = "checked";
                                        break;
                                    }
                                }

                            }

                            let tempMenu = `
                                    <input type="checkbox" name="chbMenu" 
                                        value="${sonMenu.id}" id="chb${sonMenu.id}" class="chbMenu filled-in " ${checkValue}  />
                                    <label for="chb${sonMenu.id}">${sonMenu.name}</label>
                                ` ;
                            sonMenuHtml += tempMenu ;
                            
                        }
                    }


                    let sonMenuName = `
                                     <div class="col-lg-8">
                                        <div class="form-group">
                                            <div class="form-line1"> 
                                                ${sonMenuHtml}
                                            </div>
                                        </div>
                                    </div>
                            </div>
                    `;

                    menuHtml += menuName+sonMenuName;
                }
               


            });
            $(".menusetting").html(menuHtml);
            $('.chbMenu').click(function() {


                // 事件处理代码
                var menuidValue = "[";
                $('input[name="chbMenu"]:checked').each(function(){
                    menuidValue +='"'+this.value+'",'; 
                });
                menuidValue +="0]";
                 $('#menuid').val(menuidValue);
 
            });
 
        }

    })
 


}
//在base_edit的set_edit_value_by_url 后面执行
var jqFunction   = function(){


 
    

}