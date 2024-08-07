$(function () {

    let header = listHeaderJson?listHeaderJson:headerJson;



    let headerHtml = "";
    for (const key in header) {
        headerHtml += "<th id='tr"+key+"'>" + header[key] + "</th>";
    }
    $("#theadData").html(" <tr>" + headerHtml + "</tr>");

    function getSearchParameter(){

        //如果在model有重新获取查询json的则获取它的值
        if (typeof getSearchParameterFromModel === 'function' ){
            return getSearchParameterFromModel();
        }

        let fieldName  = $('.show-tick').val();
        let fieldValue = $('#txtKeyWord').val();
        let searchParameter = {};
        if (fieldName!="" && fieldValue!=""){
            searchParameter = JSON.parse("{\""+fieldName+"\":\""+fieldValue+"\"}");
        }
        return searchParameter; 

    }

    var m = new BaseModel(modeName);
    let searchParameter = getSearchParameter();

   
    m.search(searchParameter, header, 1, 10);

    if (jqFunction){
        jqFunction();
     }

    $('.pagination,#btnSearch').click(function (e) {

        //用户点击的页面
        let pageIndex = $(e.target).attr("data-dt-idx")?$(e.target).attr("data-dt-idx"):1;
        let searchParameter = getSearchParameter();
        m.search(searchParameter, header, pageIndex, 10);


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
                location.href = modeName+"_" + type + ".html?id=" + id;
            }
        }
    });



})