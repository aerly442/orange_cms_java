$(function () {

    var leftMenuModel = new BaseModel("menu");
    leftMenuModel.getall(function(data){
     
        if (data.code && data.code=='0'){
            let aryData = data.data ;
            let leftMenuHtml = "";
            aryData.forEach(function(item) {
                if (item.parentid =="0"){
                   // <a href="javascript:void(0);" class="menu-toggle waves-effect waves-block"></a>
                    let sonMenuHtml = '' ;
                    for(let i=0;i<aryData.length;i++){
                        if (item.id == aryData[i].parentid){
                            let tempHtml = `<li>
                                                <a href="${aryData[i].linktext}" class=" waves-effect waves-block alinkMenu">${aryData[i].name}</a>
                                            </li>`;
                            sonMenuHtml +=tempHtml ;   
                        }
                    }
                    let menuHtml = `<li>
                        <a href="javascript:void(0);" class="menu-toggle waves-effect waves-block ">
                            <i class="material-icons">${item.cssclass}</i>
                            <span>${item.name}</span>
                        </a>
                        <ul class="ml-menu" style="display: none;">  
                            ${sonMenuHtml}
                        </ul>
                    </li>`;

                    leftMenuHtml +=menuHtml;
                }
            })
            $(".ulLeftMenu").append(leftMenuHtml);
            $('.menu-toggle').on('click', function (e) {
                var $this = $(this);
                var $content = $this.next();
    
                if ($($this.parents('ul')[0]).hasClass('list')) {
                    $(this).parents(0).addClass('active')
                    var $not = $(e.target).hasClass('menu-toggle') ? e.target : $(e.target).parents('.menu-toggle');
    
                    $.each($('.menu-toggle.toggled').not($not).next(), function (i, val) {
                        if ($(val).is(':visible')) {
                            $(val).prev().toggleClass('toggled');
                            $(val).slideUp();
                        }
                    });
                }
    
                $this.toggleClass('toggled');
                $content.slideToggle(320);
            });
            var href = window.location.href;
            $(".ulLeftMenu").find("li").each(function(index, item) {
                
                let leftHref = $(item).children("a")?$(item).children("a").attr("href"):"";
                if (leftHref!="" && href.indexOf(leftHref)>0) {

                    $(item).css("background-color","#e9e9e9");
                    $(item).parent("ul").css("display","block");

                }

            })
           
        }
     }
    )


  
    

})