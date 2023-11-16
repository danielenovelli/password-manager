$(".input-text").focus(function () { 
    $(this).prev('.fa').addClass("glowIcon");
});
$(".input-text").focusout(function () { 
    $(this).prev('.fa').removeClass("glowIcon");
});
$("#login-button").hover(function() {
    $(this).addClass("button-group");
});
$("#login-button").mouseleave(function() {
    /*
    setTimeout(()=>{
        $(this).addClass("button-group");
    },100);
    */
    $(this).addClass("button-group");
});