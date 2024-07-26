$(function () {

    var m = new BaseModel(modeName);
    //根据URL的id=xx设置界面的值
     m.set_edit_value_by_url("detail",modeFunction,detailHeaderJson?detailHeaderJson:headerJson);
     $(".form-line").removeClass('focused');

     if (jqFunction){
        jqFunction();
     }

})