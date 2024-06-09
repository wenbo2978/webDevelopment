$(function () {
    var trainingResId=getUrlParam("trainingResId");
    $.ajax( {
        url:"/staff/findAdvice",
        type:"GET",
        data:"trainingResId="+trainingResId,
        success:function (result) {
            $("#inputComment").val(result.trainerFeedBack);
            //$("#InputfinalAdvice").val(result.finalAdvice);
        }
    })

    $("#advice_set_btn").click(function () {
        var staffAdvice=$("#inputStaffAdvice").val();
        var staffFeedBack=$("#inputStaffFeedBack").val();
        $.ajax( {
            url:"/staff/submitAdvice",
            type:"GET",
            data:{"trainingResId":trainingResId,"staffAdvice":staffAdvice,"staffFeedBack":staffFeedBack},
            success:function (result) {
                alert("submit success");
                window.location.href="staffEvaluate.html";
            }
        })
    })
})
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}