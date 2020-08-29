$(function(){
    //获取src值
    $(".main_left a").on("click",function(){
        var address =$(this).attr("data-src");
        $("iframe").attr("src",address);
    });
    //一下代码是根据窗口高度在设置iframe的高度
    var frame = $("#aa");

    var frameheight = $(window).height();
    console.log(frameheight);
    frame.css("height",frameheight);


})