function BaseModel(tableName) {



    //01 获取单挑数据
    this.get_detail = function (id,callback) {

        ajaxGet("/" + tableName + "/get_singer?id=" + id, callback);

    }

    //02-01 设置编辑界面的值
    this.set_edit_value_by_url = function(type,modeFunction,header){

        let url     = location.href;
        let aryPath = url.split('?');
        if (aryPath.length>1){
           
            let aryPara = aryPath[1].split('=');
            if (aryPara.length == 2 && aryPara[0] =='id' && aryPara[1]!=""){
               
                let id = aryPara[1];
                this.get_detail(aryPara[1],function(data){
    
                    let u = data.data;
                    for (const key in u) {

                         let value = u[key];
                         if ($("#"+key)){
                             value = getFieldValue(key,value) ;
                             $("#"+key).val(value);
                             if (type && type=="detail"){
                                $("#"+key).attr("disabled",true);
                             }
                         }
                     
                    }

                            //如果有其他回调，则执行
                    if (modeFunction){
                        modeFunction(type);
                    }
                
                 })

                if (type && type=="detail"){

                    $('.btn-detail-edit').attr("href",tableName+"_edit.html?id="+id)

                }

    
            }
            
    
    
        }
        else
        {
            if (modeFunction){
                modeFunction(type);
            }

        }

        //设置lab标签值
        if (header){
 
            for (let key in header) {

                if (header.hasOwnProperty(key)) { //
                    
                    let lbContent = header[key];
                    let lbId      = "#lb"+key;
                    $(lbId).html(lbContent);
                
                  }                               
                 
            }
            
        }

    }

    //02 编辑：新增和修改
    this.edit = function (userJson) {
        ajaxPost(userJson, "/" + tableName + "/save", tableName + "_list.html");

    }

    this.getall = function (callback) {

        ajaxGet("/" + tableName + "/getall", callback);

    }

    //03 删除
    this.delete = function (id,callback) {
        ajaxGet("/"+tableName+"/delete?id="+id,function(data){

            if (data.code =="0"){
                swal("删除成功");
                if (callback){
                    callback;
                }
            }
            else{
                swal("删除失败，错误："+data.desc);
            }

        })

    }

    //设置分页代码
    function setPageHtml(totalCount, pageIndex, pageSize) {

        let maxShowPageCount = 5;
        let htmlBody = "";
        let totalPage = totalCount % pageSize==0? parseInt(totalCount / pageSize):parseInt(totalCount / pageSize)+1;
        let prevIndex = (parseInt(pageIndex) - 1) <= 1 ? 1 : parseInt(pageIndex) - 1;
        let nextIndex = (parseInt(pageIndex) + 1) > totalPage ? totalPage : parseInt(pageIndex) + 1;

        let htmlPrev = ' <li  class="paginate_button previous " id="pgPrev"> \
                            <a href="#" aria-controls="DataTables_Table_0" data-dt-idx="'+ prevIndex + '" \
                             tabindex="0">上页</a> \
                          </li>';

        let startIndex = 1;
        let endIndex = maxShowPageCount;
        if (pageIndex <= maxShowPageCount) {
            //显示1-5

            if (totalPage<maxShowPageCount){
                endIndex = totalPage;
            }

        }
        else {
            //6,7,11    
            if (pageIndex % maxShowPageCount == 0) {
                startIndex = parseInt(pageIndex / maxShowPageCount) * maxShowPageCount;
            }
            else {
                startIndex = parseInt(pageIndex / maxShowPageCount) * maxShowPageCount + 1;
            }
            //11,12
            endIndex = startIndex + maxShowPageCount;
            if (endIndex>totalPage){
                endIndex = totalPage;
            }

        }

        console.log("pageindex is:" + pageIndex.toString());

        console.log("startIndex is:" + startIndex.toString());
        console.log("endIndex is:" + endIndex.toString());

        for (let i = startIndex; i <= endIndex; i++) {

            
            let pageNo = i;

            let active = (pageIndex == pageNo) ? "active" : "";


            htmlBody += '<li class="paginate_button ' + active + '">';
            htmlBody += '<a class="alinkPage" href="#"';
            htmlBody += '       aria-controls="DataTables_Table_0" data-dt-idx="' + (pageNo).toString() + '"';
            htmlBody += '      tabindex="0">' + (pageNo).toString() + '</a>';
            htmlBody += '</li>';



        }
        let htmlNext = '<li class="paginate_button next" id="pgNext"> \
                                <a href="#"\
                                    aria-controls="DataTables_Table_0" data-dt-idx="'+ nextIndex + '"\
                                 tabindex="0">下页</a>\
                        </li>';
        let pageHtml = htmlPrev + htmlBody + htmlNext
        $("#ulPage").html(pageHtml);






    }

    //如果在类_model.js 中定义了回调函数则调用处理
    //字段名称,字段值,类型，对象数据
    function getFieldValue(fieldName,fieldValue,type,item){

        if (fieldFunction && fieldFunction[fieldName]){
            let fun = fieldFunction[fieldName];
            fieldValue = fun(fieldValue,type,item) ;

        }
        return fieldValue ;
    }

    //设置表格列表数据
    function setTableData(aryData,header){

        let tbodyData = "";
        //设置
        aryData.forEach(row => {

            let rowHtml = "";
            let id = row['id']?row['id']:"0";
            for (const key in header) {

                let fieldValue = row[key]?row[key]:"";
                fieldValue     = getFieldValue(key,fieldValue,"list",row)
                if (key =="action"){
                    
                    fieldValue = "<a href='#' data-dt-type='detail' data-dt-idx='"+id+"' class='text text-info'>详细</a> | <a data-dt-type='edit' data-dt-idx='"+id+"' href='#' class='text text-success'>编辑</a> | <a data-dt-type='delete' data-dt-idx='"+id+"' href='#' class='text text-danger'>删除</a>"
                }
                
                rowHtml += "<td>" + fieldValue + "</td>";
            }
            rowHtml = "<tr id='tr"+id+"'>" + rowHtml + "</tr>";
            tbodyData += rowHtml;

        });
        $("#tbodyData").html(tbodyData);


    }

    //04 查询
    this.search = function (userJson, header, pageIndex, pageSize) {

        ajaxPost(userJson, "/" + tableName + "/search?pageIndex=" + pageIndex + "&pageSize=" + pageSize, null, function (data) {

            //回调
            if (data.code == "0") {

                //设置总记录数
                $("#totalCount").text(data.desc);
                //设置分页标
                setPageHtml(data.desc, pageIndex, pageSize);
                //设置表格数据
                setTableData( data.data,header);

            }
            else {
                swal("获取数据错误")
            }

        });

    }

    this.getFormRule = function(userJson){


        let aryRules = {};
        let aryMessages = {};
        let strRule = "";
        let strMessage = "";
        for (let key in userJson) {
    
            let checkRule = $("#" + key).attr("data-rule");
            if (checkRule) {
                let tip = $("#" + key).attr("placeholder");
                let aryCheckRule = checkRule.split("|");
                let temp1 = "";
                let temp2 = "";
                for (let i = 0; i < aryCheckRule.length; i++) {
    
                    let aryTempRule = aryCheckRule[i].split(",");
    
                    if (aryTempRule[1] == "true") {
                        temp1 += '"' + aryTempRule[0] + '":' + aryTempRule[1] + ',';
                    }
                    else {
                        let tempRule = aryCheckRule[i].replace(aryTempRule[0]+",","");
                        temp1 += '"' + aryTempRule[0] + '":"' + tempRule + '",';
                    }
    
                    temp2 += '"' + aryTempRule[0] + '":"' + tip + '",';
    
    
                }
                temp1 = temp1.substring(0, temp1.length - 1);
                temp2 = temp2.substring(0, temp2.length - 1);
                strRule += '"' + key + '":{' + temp1 + '},'
                strMessage += '"' + key + '":{' + temp2 + '},'
            }
    
    
        }
    
        if (strRule.length > 1) {
    
            strRule = "{" + strRule.substring(0, strRule.length - 1) + "}";
    
        }
        if (strMessage.length > 1) {
    
            strMessage = "{" + strMessage.substring(0, strMessage.length - 1) + "}";
    
        }
    
        console.log(strRule);
        console.log(strMessage);
    
        if (strRule!=""){
            aryRules    = JSON.parse(strRule);
        }
        if (strMessage!=""){
            aryMessages = JSON.parse(strMessage);
        }

        return aryRules;


    }

    this.getFormRuleMessage = function(userJson){


        let aryRules = {};
        let aryMessages = {};
        let strRule = "";
        let strMessage = "";
        for (let key in userJson) {
    
            let checkRule = $("#" + key).attr("data-rule");
            if (checkRule) {
                let tip = $("#" + key).attr("placeholder");
                let aryCheckRule = checkRule.split("|");
                let temp1 = "";
                let temp2 = "";
                for (let i = 0; i < aryCheckRule.length; i++) {
    
                    let aryTempRule = aryCheckRule[i].split(",");
    
                    if (aryTempRule[1] == "true") {
                        temp1 += '"' + aryTempRule[0] + '":' + aryTempRule[1] + ',';
                    }
                    else {
                        let tempRule = aryCheckRule[i].replace(aryTempRule[0]+",","");
                        temp1 += '"' + aryTempRule[0] + '":"' + tempRule + '",';
                    }
    
                    temp2 += '"' + aryTempRule[0] + '":"' + tip + '",';
    
    
                }
                temp1 = temp1.substring(0, temp1.length - 1);
                temp2 = temp2.substring(0, temp2.length - 1);
                strRule += '"' + key + '":{' + temp1 + '},'
                strMessage += '"' + key + '":{' + temp2 + '},'
            }
    
    
        }
    
        if (strRule.length > 1) {
    
            strRule = "{" + strRule.substring(0, strRule.length - 1) + "}";
    
        }
        if (strMessage.length > 1) {
    
            strMessage = "{" + strMessage.substring(0, strMessage.length - 1) + "}";
    
        }
    
        console.log(strRule);
        console.log(strMessage);
    
        console.log(strRule);
        console.log(strMessage);
    
        if (strRule!=""){
            aryRules    = JSON.parse(strRule);
        }
        if (strMessage!=""){
            aryMessages = JSON.parse(strMessage);
        }

        return aryMessages;


    }

    function getToken() {

        if (sessionStorage.getItem("orange-token")) {
            console.log("orange-token is save!!!!!!");
            return sessionStorage.getItem("orange-token");
        }
        else {
            return "000000";
        }

    }

    function ajaxGet(actionUrl, callback) {


        var url = SITE_URL + actionUrl ;
        
        url = url.indexOf("?")>0?url+"&orange-token=" + getToken():url+"?orange-token=" + getToken(); //ajax地址

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
                    //location.href = "login.html" ;
                }

            },

            error: function (e) {
                console.log(e);

            }

        });


    }

    this.get = function(actionUrl, callback){

        ajaxGet(actionUrl, callback);

    }

    function ajaxPost(userJson, actionUrl, locationUrl, callback, tips) {


        var url = SITE_URL + actionUrl; //ajax地址
        if (url.indexOf("?") > 0) {
            url += "&" + "orange-token=" + getToken();
        }
        else {
            url += "?orange-token=" + getToken();
        }

        $.ajax({
            url: url,
            data: JSON.stringify(userJson),
            type: 'post',
            cache: false,
            dataType: 'json',
            contentType: "application/json",
            beforeSend: function (request) {
                request.setRequestHeader("orange-token", getToken());
            },
            success: function (data) {

                if (data.code == "0") {
                    if (callback) { //如果有定义回调函数就执行回调函数
                        callback(data);
                    }
                    if (locationUrl) {
                        location.href = locationUrl;
                    }
                    if (tips) {
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

    this.post = function(userJson, actionUrl, locationUrl, callback, tips){

        ajaxPost(userJson, actionUrl, locationUrl, callback, tips)
    }






}