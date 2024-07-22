$(function () {

    let header = {

        "id": "编号",
        "name": "姓名",
        "email": "Email",
        "mobile": "电话",
        "sex": "性别",
        "birthday": "生日",
        "age": "年龄",
        "homeplace": "家乡",
        "job": "职业",
        "education": "教育",
        "state": "状态",
        "action": "操作"

    }



    let headerHtml = "";
    for (const key in header) {
        headerHtml += "<th>" + header[key] + "</th>";
    }
    $("#theadData").html(" <tr>" + headerHtml + "</tr>");

    var m = new BaseModel("member");
    m.search({ name: "" }, header, 1, 10);

    $('.pagination').click(function (e) {

        //用户点击的页面
        let pageIndex = $(e.target).attr("data-dt-idx");

        m.search({ name: "" }, header, pageIndex, 10);

    })

    $("#tbodyData").click(function (e) {


        let id = $(e.target).attr("data-dt-idx");
        let type = $(e.target).attr("data-dt-type");
        if (type && id) {
            if (type == "delete") {
                swal({
                    title: "您确定要删除吗?",
                    text: "您将删除选中的行!",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    closeOnConfirm: false,
                    closeOnCancel: false
                }, function (isConfirm) {
                    if (isConfirm) {
                        m.delete(id,$(e.target).parent().parent().remove());
                        //swal("Deleted!", "Your imaginary file has been deleted.", "success");
                    } else {
                        swal("取消", "您的删除已经取消", "error");
                    }
                });
                //
            }
            else {
                location.href = "member_" + type + ".html?id=" + id;
            }
        }
    });



})