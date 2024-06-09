$(function () {
  $(function(){
    $('.c_div').mouseover(function(){
      <!--            $(this).css("border-bottom","2px gray solid");-->
      $(this).css("background", "lightgray");
    }).mouseout(function (){
      <!--            $(this).css("border-bottom","1px gray solid");-->
      $(this).css("background", "none");
    });

  });
  //员工端循环获取模块
  $.ajax( {
    url:"/staff/showTasks",
    type:"GET",
    success:function (result) {
      $("#taskContent").empty();
      $.each(result,function(index,item){
        var id=item.trainingRId;
        var content="";
        //alert(item.category);
        //if(item.trainingmk.category=="Professional"){
          content="<div class=\"form-group\">\n" +
                  "            <div class=\"c_div\" style=\"border-width:1px;border-bottom:2px solid gray;border-style:solid; border-color:gray;border-top-left-radius:40px;\n" +
                  "                        border-top-right-radius:40px;border-bottom-right-radius:40px;border-bottom-left-radius:40px\">\n" +
                  "              <br>\n" +
                  "              <div class=\"form-group\">\n" +
                  "                &nbsp;<label>TaskName:</label><span>"+item.taskName+"</span>&nbsp;&nbsp;&nbsp;<a id=\"enterTask_href"+id+"\" href=\"enterTask.html?trainingRId="+id+"\">enter</a>\n" +
                  "              </div>\n" +
                  "              <div class=\"form-group\">\n" +
                  "                &nbsp;<label>EndTime:</label><span>"+ formatDate(item.end_Time)+"</span>\n" +
                  "              </div>\n" +
                  "              <div class=\"form-group\">\n" +
                  "                &nbsp;<label>DownLoad:</label><a href=\"/Tmk/mydownLoad/"+item.taskId+"\">"+ item.taskName+"</a>\n" +
                  "              </div>\n" +
                  "              <div class=\"form-group\">\n" +
                  "                &nbsp;<label>Process:</label><label id=\"status_bar"+id+"\">Finish "+item.process+"%</label>\n" +
                  "                &nbsp;<progress style=\"width: 600px;\" value=\""+item.process+"\" max=\"100\">\n"+
                  "              </div>\n" +
                  "            </div>\n" +
                  "          </div>"
         //}else{
           /*content="<div class=\"form-group\">\n" +
                    "            <div class=\"c_div\" style=\"border-width:1px;border-bottom:2px solid gray;border-style:solid; border-color:gray;border-top-left-radius:40px;\n" +
                    "                        border-top-right-radius:40px;border-bottom-right-radius:40px;border-bottom-left-radius:40px\">\n" +
                    "              <br>\n" +
                    "              <div class=\"form-group\">\n" +
                    "                &nbsp;<label>TaskName:</label><span>"+item.mkName+"</span>\n" +
                    "              </div>\n" +
                    "              <div class=\"form-group\">\n" +
                    "                &nbsp;<label>BeginTime:</label><span>"+ formatDate(item.trainingmk.beginTime)+"</span>&nbsp;<em>|</em>\n" +
                    "                &nbsp;<label>EndTime:</label><span>"+ formatDate(item.trainingmk.endTime)+"</span>\n" +
                    "              </div>\n" +
                    "              <div class=\"form-group\">\n" +
                    "                &nbsp;<label>Download:</label><a href=\"/Tmk/mydownLoad/"+item.trainingmk.mkid+"\">"+ item.trainingmk.accessory+"</a>\n" +
                    "              </div>\n" +
                    "            </div>\n" +
                    "          </div>"*/



        $("<div></div>").append(content).appendTo("#taskContent");

        $.ajax({
          url:"/staff/findTaskStatus",
          type:"GET",
          data:"trainingRId="+id,
          success:function(data){
            if(data==true){
              $("#enterTask_href"+id).attr("disabled",true).css("pointer-events","none").css("color","gray");
              $("#status_bar"+id).text("Finished").css("color","blue");
            }

          }
        })
        })

      }

    })




})
function formatDate(value) {
  var date = new Date(value);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
  var Y = date.getUTCFullYear() + '-';
  var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
  var D = date.getDate();

  return Y+M+D;
}
