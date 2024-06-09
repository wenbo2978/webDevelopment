$(function () {
    $.ajax( {
        url:"/staff/findResult",
        type:"GET",
        success:function (result) {

            $.each(result,function(index,item){
                var content="<div class=\"form-group\">\n" +
                    "                <div style=\"border-bottom:1px gray solid\">\n" +
                    "                    <div class=\"form-group\">\n" +
                    "                        <label>TaskName:</label><a id=\"adviceHref"+item.trainingResId+"\" href=\"staffAdvice.html?trainingResId="+item.trainingResId+"\" >"+item.taskName+"</a>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"form-group\">\n" +
                    "                        <label>Choice Score:</label><span>"+item.choiceScore+"</span>&nbsp;<em>|</em>&nbsp;\n" +
                    "                        <label>Essay Score:</label><span>"+item.essayScore+"</span>&nbsp;<em>|</em>&nbsp;\n" +
                    "                        <label>Total Score:</label><span>"+item.totalScore+"</span>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"form-group\">\n" +
                    "                        <label>State:</label><label id=\"adviceStatus"+item.trainingResId+"\">unSubmitted</label>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>"
                $("<div></div>").append(content).appendTo("#resultContent");
                if(item.staffAdvice!="" && item.staffAdvice!=null){
                    $("#adviceHref"+item.trainingResId).attr("disabled",true).css("pointer-events","none").css("color","gray");
                    $("#adviceStatus"+item.trainingResId).text("Submitted").css("color","blue");
                }
            })
        }
    })
})