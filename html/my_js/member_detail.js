$(function () {

    var m = new BaseModel("member");
    //根据URL的id=xx设置界面的值
     m.set_edit_value_by_url("detail");
     $(".form-line").removeClass('focused');

})