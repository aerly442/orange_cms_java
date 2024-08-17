$(document).ready(function () {
    $("article").fadeIn(0);

    var swiper = new Swiper('.swiper-container', {
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
        width: 733,
        heigth: 424,
        hashnav: true,
        autoplay: 5000,
        loop: true
    });

    var swiper1 = new Swiper('.swiper-container1', {
        heigth: 300,
        autoplay: 5000,
        loop: true
    });

    //瀵艰埅浜や簰
    /*
        $(window).scroll(function() {
            if ($(this).scrollTop() > 1000) {
                $(".pannel-qrcode").addClass("fixed");
            } else {
                $(".pannel-qrcode").removeClass("fixed");
            }
        })
    */
    $(".pannel-rank .rank-tit a").hover(function () {
        $(".pannel-rank .rank-tit a").removeClass('current');
        $(this).addClass('current');
        var a = $(this).text();
        if (a == '鏃ユ帓琛�') {
            $(".pannel-rank #day-list").show();
            $(".pannel-rank #week-list").hide();
        }
        if (a == '鍛ㄦ帓琛�') {
            $(".pannel-rank #day-list").hide();
            $(".pannel-rank #week-list").show();
        }
    })


    $(".menu-button").click(function () {
        if ($(".nav-overlay").css("display") == 'none') {
            $(".nav-overlay").css("display", "block");
        } else {
            $(".nav-overlay").css("display", "none");
        }
        $(".menu-mini-nav").slideToggle();
    })

    //鍙充晶绠ご瀵艰埅
    $('#shang').click(function () {
        $('body,html').animate({
            scrollTop: 0
        }, 500)
    });
    $("#xia").click(function () {
        $('body,html').animate({
            scrollTop: $(".footer").offset().top
        }, 500)

    });
    $('#go_top').click(function () {
        $('body,html').animate({
            scrollTop: 0
        }, 500)
    });

    var pageIndex = 1;
    $(".ajax-more-btn").on('click', function () {
        if (!$(".ajax-more-btn").hasClass('disabled')) {

            $(".ajax-more-btn").text("Loading...").addClass('loading');
            var cid = $("#Code").val();
            var limit_start = pageIndex+1;
            get_news_list(limit_start,cid) ;

        }
    });


    $(".article-nav-list a").on('click', function () {
        $(".article-nav-list a").removeClass('active');
        $(this).addClass('active');
        var cid = $(this).attr("cid");
        var box = '#box_' + cid;
        $(".news_box").hide();
        $(box).fadeIn(800);

        if ($(box).find('article').length > 0) {
            $(".page-nav").show();
        } else {
            $(".page-nav").hide();
        }
    })


    function get_news_list_html(item){

    let createtime = item.createtime.substring(0,10);
    let h = `  <article style="display:none">
            <figure class="thumbnail thumbnail-hiden">
                <span class="sort hidden-xs"><a href="/a/detail.html?id=${item.id}.html"
                        rel="category">文章</a></span>
                <a href="/a/detail.html?id=${item.id}.html" rel="bookmark" class="home-thumbnail hidden-xs"
                    target="_blank">
                    <img width="210"   src="${item.mainpic}"
                        alt="${item.title}" /></a>
            </figure>
            <div class="entry-content">
                <h2 class="entry-title"><a href="/a/detail.html?id=${item.id}.html"
                        rel="bookmark" target="_blank">${item.title}</a></h2>
                <div class="entry-site">${item.abstract1}</div>
                <div class="entry-meta">
                        <a href="" style='color:#b8b8b8'>阅读量：${item.visit}</a>&nbsp;&nbsp;
                        <a href='/a/list.html?tag=${item.title}' rel='tag' style='color:#94afbb'> ${item.title}</a>                                       
                    <div class="time"><i></i>${createtime}</div>
                    
                </div>
            </div>
        </article>`;


         return h ;

    }

    function get_news_list(pageIndex,cid){

        $.ajax({
            type: "GET",
            url: "/article/get_news_list?pageIndex=" + pageIndex + "&cid="+cid, //
            success: function (data) { //
                if (data != '-1') {
                    let aryData = data.data ;
                    let html = '';
                    for(let i=0;i<aryData.length;i++){
                        html += get_news_list_html(aryData[i]);
                    }
                    $(".ajax-more-btn").text("数据加载中").removeClass('loading');
                    $('.news_box').append(html);
                    $("article").fadeIn(800);
                } else {
                    $(".ajax-more-btn").addClass("disabled");
                    $(".ajax-more-btn").text("没有数据了");
                }
            }
        });

    }

    function get_tag_list(){

        $.ajax({
            type: "GET",
            url: "/article/get_tag_list", //
            success: function (data) { //
                if (data != '-1') {
                    let aryData = data.data ;
                    let html = '';
                   
                    for(let i=0;i<aryData.length;i++){
                        let item = aryData[i] ;
                        let temp = `<a href="/a/?tag=${item.name}" rel="tag" style='font-size: 14px;'>${item.name}</a> `;
                        html += temp;
                    }
                    
                    $('.tagcloud').append(html);
                   
                } else {
                    
                }
            }
        });

    }

    if (pageName && pageName ==="index"){
       get_news_list(1,"");
       get_tag_list();
    }



});