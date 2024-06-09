var trainingRId = getUrlParam("trainingRId");
var bt="";
var et="";
$(function () {
    bt=getDate();
    // alert("mkid="+mkid);
    //get EssayContent
    $.ajax({
        url:"/staff/essayContent",
        type:"GET",
        data:"trainingRId="+trainingRId,
        success:function (result) {
            $.each(result,function(index,item){
                var content= "<div class=\"form-group\">\n" +
                    "<label>Q"+(index+1)+":</label><span>"+item.taskQ+"</span>\n" +
                    "</div>\n" +
                    "<div class=\"form-group\">\n" +
                    "<label>Answer:</label><textarea name=\"answer\" class=\"form-control\" id=\"inputEssayAnswer"+index+"\" style=\"height:100px;\">"+item.answer+"</textarea></div>"
                $("<div></div>").append(content).appendTo("#essayContent");
            })

        }
    })
    //get ChoiceContent
    $.ajax({
        url:"/staff/choiceContent",
        type:"GET",
        data:"trainingRId="+trainingRId,
        success:function (result) {
            $.each(result,function(index,item){
                var content= "<div class=\"form-group\">\n" +
                    "<label>Q"+(index+1)+"：</label><span>"+item.taskQ+"</span></div>\n" +
                    "<div class=\"form-group\">\n" +
                    "<label>A:</label><span>"+item.taskChoiceA+"</span>&nbsp;&nbsp;\n" +
                    "<label>B:</label><span>"+item.taskChoiceB+"</span>&nbsp;&nbsp;\n" +
                    "<label>C:</label><span>"+item.taskChoiceC+"</span>&nbsp;&nbsp;\n" +
                    "<label>D:</label><span>"+item.taskChoiceD+"</span>\n" +
                    "</div>\n" +
                    "<div class=\"form-group\">\n" +
                    "<label>Answer</label><input type=\"text\" name=\"answer\" class=\"form-control\" id=\"inputChoiceAnswer"+index+"\" value=\""+item.answer+"\"></div>"
                $("<div></div>").append(content).appendTo("#choiceContent");
            })


        }
    })
    //save current processing and save answer
    $("#content_save_btn").click(function () {
        et=getDate();
        alert(et)
        //console.log("start save");
        //console.log(et);
        $.ajax({
            url: "/staff/essayContent",
            type: "GET",
            async: false,
            data: "trainingRId=" + trainingRId,
            success: function (result) {
                $.each(result, function (index, item) {
                    var essayAnswer = $("#inputEssayAnswer"+index).val();
                    $.ajax({
                        url: "/staff/saveEssayAnswer",
                        type: "GET",
                        async: false,
                        data: {"taskEssayId":item.taskEssayId, "answer": essayAnswer},
                        success: function (result) {
                            console.log("#inputEssayAnswer"+index+"---"+essayAnswer);
                            $.ajax({
                                url:"/staff/choiceContent",
                                type:"GET",
                                async: false,
                                data:"trainingRId="+trainingRId,
                                success:function (result) {
                                    $.each(result,function(index,item){

                                        var choiceAnswer=$("#inputChoiceAnswer"+index).val();
                                        // alert(wd_answer+we_answer);

                                        $.ajax({
                                            url:"/staff/saveChoiceAnswer",
                                            type:"GET",
                                            async: false,
                                            data:{"taskChoiceId":item.taskChoiceId,"answer":choiceAnswer},
                                            success:function (result) {
                                                console.log("#inputChoiceAnswer"+index+"---"+choiceAnswer);
                                                $.ajax({
                                                    url: "/staff/updateProcess",
                                                    type: "GET",
                                                    async: false,
                                                    data: "trainingRId=" + trainingRId,

                                                })
                                            }
                                        })
                                    })
                                }
                            })

                        }
                    })
                })
            }
        })


        alert("save success!");
        window.location.href="staff_index.html";
        /*$.ajax({
            url:"/staff/addTrainingRecord",
            type:"GET",
            data:{"trainingRId":trainingRId,"eTime":et},
            success:function (result) {

            }
        })*/
    })
    //点击提交按钮，提交结果，将题目状态改为已完成，并判断客观题对错
    $("#content_submit_btn").click(function () {

        $.ajax({
            url: "/staff/essayContent",
            type: "GET",
            data: "trainingRId=" + trainingRId,
            success: function (result) {
                $.each(result, function (index, item) {
                    $.ajax({
                        url:"/staff/finishEssay",
                        type:"GET",
                        data:"taskEssayId="+item.taskEssayId,
                        success:function (result) {

                        }
                    });
                })
            }
        })
        $.ajax({
            url:"/staff/choiceContent",
            type:"GET",
            data:"trainingRId="+trainingRId,
            success:function (result) {
                $.each(result,function(index,item){

                    $.ajax({
                        url:"/staff/finishChoice",
                        type:"GET",
                        data:"taskChoiceId="+item.taskChoiceId,
                        success:function (result) {

                        }
                    });
                })
            }
        })
        $.ajax({
            url: "/staff/finishTrainingRecord",
            type: "GET",
            data: "trainingRId=" + trainingRId,
            success: function (result) {

            }
        })
        alert("submit success!");
        window.location.href="staff_index.html";

    })

})



function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

function getDate() {
    var myDate = new Date();
    //获取当前年
    var year=myDate.getFullYear();
    //获取当前月
    var month=myDate.getMonth()+1;
    //获取当前日
    var date=myDate.getDate();
    var h=myDate.getHours();       //获取当前小时数(0-23)
    var m=myDate.getMinutes();     //获取当前分钟数(0-59)
    var s=myDate.getSeconds();
    var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
    return now;
}