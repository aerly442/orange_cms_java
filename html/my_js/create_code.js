$(function () {

    /*
    jQuery.validator.addMethod("isPhone", function(value, element) {  
        var length = value.length;  
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;  
        return this.optional(element) || (length == 11 && mobile.test(value));  
    }, "请填写正确的手机号码"); //可以自定义默认提示信息  
    */

    //01 获取数据库表名
    ajaxGet("/create_code/get_table",function(data){

        let aryTables = data.data;
        aryTables.forEach(el => {

            $("#tableName").append("<option value='"+el+"'>"+el+"</option>");
            
        });


    })

    function getToken(){

        if (sessionStorage.getItem("orange-token")) {
            console.log("orange-token is save!!!!!!");
            return sessionStorage.getItem("orange-token");
        }
        else{
            return "000000";
        }

    }

    function ajaxGet(actionUrl, callback) {


        var url = SITE_URL + actionUrl+"?orange-token="+getToken(); //ajax地址

        $.ajax({
            url: url,
            success: function (data) {

                if (data.code == "0") {
                    if (callback) { //如果有定义回调函数就执行回调函数
                        callback(data);
                    }

                }
                else {
                    swal(data.desc);
                }

            },

            error: function (e) {
                console.log(e);

            }

        });


    }

   $('#btnSubmit').click(function(){

     let packageName = $("#packageName").val();
     let sourcePath  = $("#sourcePath").val();
     let codeNote    = $("#codeNote").val();
     let tableName   = frmCreateCode.tableName.options[frmCreateCode.tableName.selectedIndex].value;
     let aryCheckBox         = document.getElementsByName("chbCodeName");
     let chbValue    = "";
     for (let i=0;i<aryCheckBox.length;i++) {
         if (aryCheckBox[i].checked){
            chbValue +=aryCheckBox[i].value+",";
         }
     }

      let form = {
        packageName:packageName,
        sourcePath:sourcePath,
        codeNote:codeNote,
        tableName:tableName,
        codeName:chbValue
      };
      ajaxPost(form,"/create_code/start");

   });

   function ajaxPost(userJson, actionUrl, locationUrl, callback) {


    var url = SITE_URL + actionUrl+"?orange-token="+getToken(); //ajax地址

    console.log(url);

    $.ajax({
        url: url,
        data: JSON.stringify(userJson),
        type: 'post',
        cache: false,
        dataType: 'json',
        contentType: "application/json",
        headers: {
            "orange-token": getToken()
        },
        success: function (data) {

            if (data.code == "0") {
                if (callback) { //如果有定义回调函数就执行回调函数
                    callback(data);
                }
                if (locationUrl) {
                    location.href = locationUrl;
                }
                else {
                    swal(data.desc);
                }

            }
            else {
                swal(data.desc);
            }

        },

        error: function (e) {
            console.log(e);

        }

    });


}


    $('#frmChangePassword').validate({
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

            var user = new ManagerUser();
            let newPassword = $("#newPassword").val();
            let oldPassword = $("#oldPassword").val();
            user.changePassword(oldPassword,newPassword);

        },
        //校验规则  
        rules: {
            newPassword: {
                required: true,
                
            },
            oldPassword: {
                required: true,
               
            } 
        },
        //对应规则给出的提示信息  
        messages: {
            newPassword: {
                required: '请输入您的新密码'
              
            },
            oldPassword: {
                required: "请输入您的旧密码"
              
            }
        }
    });

})