$(function () {

    /*
    jQuery.validator.addMethod("isPhone", function(value, element) {  
        var length = value.length;  
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;  
        return this.optional(element) || (length == 11 && mobile.test(value));  
    }, "请填写正确的手机号码"); //可以自定义默认提示信息  
    */
    $.validator.addMethod(
        "regex",
        function (value, element, regexp) {
            var re = new RegExp(regexp);
            return this.optional(element) || re.test(value);
        }
    );

    let userJson = {

        "id": "0",
        "name": "",
        "headerpic": "",
        "email": "",
        "mobile": "",
        "sex": "",
        "birthday": "",
        "age": "",
        "intro": "",
        "homeplace": "",
        "job": "",
        "education": "",
        "idnumber": "",
        "state": ""

    }



    var m           = new BaseModel("member");
    let aryRules    = m.getFormRule(userJson);//获取表单校验规则
    let aryMessages = m.getFormRuleMessage(userJson);//获取表单校验规则提示

    m.set_edit_value_by_url();//根据URL的id=xx设置界面的值
 
    $('#frmMember').validate({
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

            

            for (let key in userJson) {

                if ($("#" + key).val() != "") {
                    userJson[key] = $("#" + key).val();
                }

            }
            //return;
            m.edit(userJson);

        },
        //校验规则  
        rules:
            aryRules
        ,
        //对应规则给出的提示信息  
        messages:
            aryMessages


    });

})