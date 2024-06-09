$(function(){
    addTaskId();
    $('#selectOrder').change(function(){
        List();
    });
    $('#selectTaskId').change(function(){
        //var s = $(this).val();
        List();
    });


});

function addTaskId(){
    $.ajax({
        url: "/trainer/getTaskIdForRes",
        type: "GET",
        success: function(result){
            $("#selectTaskId").empty();
            var taskIdTd = $("<option value='0' selected></option>").append("All");
            $("#selectTaskId").append(taskIdTd);
            $.each(result, function(index, item){
                var taskIdTd = $("<option value='" + item.taskId + "'></option>").append(item.taskName);
                $("#selectTaskId").append(taskIdTd);
            });
            List();
        }
    });
}

function List(){
    var taskId = $("#selectTaskId").val();
    var order = $("#selectOrder").val();
    var data = order + ' ' + taskId;
    $.ajax({
        url:"/trainer/listResultByOrder",
        data:"data="+data,
        type:"GET",
        success:function(result){
            //alert("1111");
            $("#result_table tbody").empty();
            $.each(result,function(index,item){


                var idTd = $("<td></td>").append(index);
                var userNameTd = $("<td></td>").append(item.staffName);
                var taskNameTd = $("<td></td>").append(item.taskName);
                var choiceScoreTd = $("<td></td>").append(item.choiceScore);
                var essayScoreTd = $("<td></td>").append(item.essayScore);
                var totalScoreTd = $("<td></td>").append(item.totalScore);


                $("<tr></tr>").append(idTd)
                .append(userNameTd)
                .append(taskNameTd)
                .append(choiceScoreTd)
                .append(essayScoreTd)
                .append(totalScoreTd)
                .appendTo("#result_table tbody");
            });
            //alert(s);
        },error:function(result){
            alert("error!!!");
        }
    });
}