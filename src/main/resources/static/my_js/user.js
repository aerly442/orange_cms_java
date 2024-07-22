$(function () {

    /*
    jQuery.validator.addMethod("isPhone", function(value, element) {  
        var length = value.length;  
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;  
        return this.optional(element) || (length == 11 && mobile.test(value));  
    }, "请填写正确的手机号码"); //可以自定义默认提示信息  
    */

    //01 用户登录
    function login(userName,passWord){
        
         var user = new ManagerUser();
         user.login(userName,passWord);

    }

    $("#btnLogin").click(function () {

        //alert("请输入密码！！！！");
        //swal("请输入用户名");
    });

    $('#sign_in').validate({
        highlight: function (input) {
            console.log(input);
            $(input).parents('.form-line').addClass('error');
        },
        unhighlight: function (input) {
            $(input).parents('.form-line').removeClass('error');
        },
        errorPlacement: function (error, element) {
            $(element).parents('.input-group').append(error);
        },
        submitHandler: function (form) {

            login($("#username").val(),$("#password").val());

        },
        //校验规则  
        rules: {
            password: {
                required: true,
                
            },
            username: {
                required: true,
               
            } 
        },
        //对应规则给出的提示信息  
        messages: {
            username: {
                required: '请输入用户名'
              
            },
            password: {
                required: "请输入密码"
              
            }
        }
    });

})