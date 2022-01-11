$(function(){
    $('.main_banner_menubar').hover(()=>{
            $('.menu_img').removeClass('active');
            $('.menu_img_hover').addClass('active');
        },
        ()=>{
            $('.menu_img').addClass('active');
            $('.menu_img_hover').removeClass('active');
        });
    var lastScrollTop = 0;
    $(window).scroll(()=>{
        var scrollTop = $(this).scrollTop();    //스크롤바 수직 위치 가져옴.
        if(scrollTop > 0){
            if((scrollTop > lastScrollTop) ** (lastScrollTop > 0)){
                $('.main_banner_menubar').css("top","-80px");
            }
            else {
                $('.main_banner_menubar').css("top","0px");
                $('.main_banner_menubar').addClass('drop');
                $('.menu_img').removeClass('active');
                $('.menu_img_hover').addClass('active');
            }
            lastScrollTop = scrollTop;
        }
        else {
            $('.main_banner_menubar').removeClass('drop');
            $('.menu_img').addClass('active');
            $('.menu_img_hover').removeClass('active');
        }
    })
    $('.trainer_img').click(function(){
        var tab_id = $(this).attr('data-tab');
        $('.main_trainer_info_detail').removeClass('active');

        $("#"+tab_id).addClass('active');
    })
    $('.header_menu li').click(function() {
        var click_id = $(this).attr('data-id')
        location.href=click_id+'.html'
    })
})