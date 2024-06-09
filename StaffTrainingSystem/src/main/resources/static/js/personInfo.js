$(function() {
    $("#info_edit_btn").click(function () {

        $.post("/staff/personInfoedit", $("#staff_edit_form").serialize(), function (data) {
            if (data.flag) {
                alert("提交成功");
                window.location.reload();
                // location.href = "/personInfo.html";
            } else {
                alert("提交失败");
            }
        });
        return false;
        //如果这个方法没有返回值，或者返回为true，则表单提交，如果返回为false，则表单不提交
    });
});