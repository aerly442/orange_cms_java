$(function () {

    /*
    jQuery.validator.addMethod("isPhone", function(value, element) {  
        var length = value.length;  
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;  
        return this.optional(element) || (length == 11 && mobile.test(value));  
    }, "请填写正确的手机号码"); //可以自定义默认提示信息  
    */

 



    $('#frmManager').validate({
        highlight: function (input) {
            $(input).parents('.form-line').addClass('error');
        },
        unhighlight: function (input) {

            $(input).parents('.form-line').removeClass('error');
        },
        errorPlacement: function (error, element) {
             $(element).parents('.form-group').append(error);
        },
        submitHandler: function (form) {

            var user        = new BaseModel("manager");
            let username    = $("#username").val();
            let password    = $("#password").val();
            let userJson    = {"username": username, "password": password };
            let actionUrl   = "/manager/login";
            let locationUrl = "main.html";
            
            //登录成功
            let callback    = function(data){
               
                sessionStorage.setItem("orange-token", data.data);

            } ;
            let tips        = "登录成功"
            user.post(userJson, actionUrl, locationUrl, callback, tips)
            

        },
        //校验规则  
        rules: {
            username: {
                required: true,
                
            },
            password: {
                required: true,
               
            } 
        },
        //对应规则给出的提示信息  
        messages: {
            username: {
                required: '请输入您的用户名'
              
            },
            password: {
                required: "请输入您的密码"
              
            }
        }
    });

})