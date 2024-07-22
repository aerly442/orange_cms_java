function ManagerUser() {


    //01 用户登录
    this.login = function (username, password) {

        var userJson = { "username": username, "password": password };
        ajaxPost(userJson, "/manager/login", "/main.html", function (data) {

            sessionStorage.setItem("orange-token", data.data);
            //成功的话保存token到本地

        });

    }

    //02 修改密码
    this.changePassword = function (oldPassword, newPassword,) {
        let userJson = { "oldPassword": oldPassword, "newPassword": newPassword };
        ajaxPost(userJson, "/manager/change_password",false,function(data){

            $("#newPassword").val("");
            $("#oldPassword").val("");

        });

    }

    function ajaxPost(userJson, actionUrl, locationUrl, callback) {


        var url = SITE_URL + actionUrl; //ajax地址

        $.ajax({
            url: url,
            data: JSON.stringify(userJson),
            type: 'post',
            cache: false,
            dataType: 'json',
            contentType: "application/json",
            beforeSend: function (request) {
                if (sessionStorage.getItem("orange-token")) {
                    request.setRequestHeader("orange-token", sessionStorage.getItem("orange-token"));
                }
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






}