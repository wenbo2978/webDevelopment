$(function() {
    $("#staff_username_hide").focusout(function(){
        var username = $(this).val();
        if(username==''){
            $("#user_errorMsg").html("userName cannot be NULL");
        }else{
            $("#user_errorMsg").html("");
        }
    });

    $("#staff_password_hide").focusout(function(){
            var username = $(this).val();
            if(username==''){
                $("#user_errorMsg").html("password cannot be NULL");
            }else{
                $("#user_errorMsg").html("");
            }
    });


    $("#login_btn").click(function () {
            //alert("2323");
            $.post("/user/user_login", $("#user_loginForm").serialize(), function (data) {
                if (data.flag) {
                    //alert(data.authority);
                    location.href =data.authority;
                } else {
                    //alert("fail");
                    $("#user_errorMsg").html(data.errorMsg);
                }
            });
            return false;
    });


    $(".screenbg ul li").each(function(){
    		$(this).css("opacity","0");
    });
    $(".screenbg ul li:first").css("opacity","1");
    var index = 0;
    var t;
    var li = $(".screenbg ul li");
    var number = li.size();
    function change(index){
        li.css("visibility","visible");
        li.eq(index).siblings().animate({opacity:0},3000);
        li.eq(index).animate({opacity:1},3000);
    }
    function show(){
        index = index + 1;
        if(number - 1 >= index){
            change(index);
        }else{
            index = 0;
            change(index);
        }
    }
    t = setInterval(show,8000);
    //generate the background according to the window size
    var width = $(window).width();
    $(".screenbg ul img").css("width",width+"px");
});





