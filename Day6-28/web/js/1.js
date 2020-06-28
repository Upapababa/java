$(".box").hover(function () {
    $(this).css("background","#daeeed")
})
$(".box").mouseout(function () {
     $(this).css("background","white")
})
$(".box").click(function () {
    debugger;
    var a=$(this).index()/2;
    if($(".box img").eq(a).prop("src").substring(35,49)=="img/+.jpg"){
        $(".box img").eq(a).prop("src","img/-.jpg");
        $(".jd").eq(a).slideToggle();
    }else{
        $(".box img").eq(a).prop("src","img/+.jpg");
        $(".jd").eq(a).slideToggle();
    }
})
