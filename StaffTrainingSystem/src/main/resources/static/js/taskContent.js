$(function(){
    /*$("#taskChoice_save_edit_btn").click(function(){
        $.ajax({
            url: "/trainer/taskChoiceSaveEdit",
            type: "POST",
            data: $("#taskChoiceEditModal form").serialize(),
            success: function(result){
                alert("save success!!")

                $("#taskChoiceEditModal").modal('hide');
                window.location.reload();
            }
        });
    });*/

});


function taskChoiceEdit(taskChoiceId){
    //alert(taskChoiceId);
    $.ajax({
        url: "/trainer/getTaskChoiceByChoiceId",
        data: "taskChoiceId="+taskChoiceId,
        type: "GET",
        success: function(result){
            $("#taskChoiceId_edit_input").attr("value", taskChoiceId);
            $("#taskQ_edit_input").attr("value", result.taskQ);
            $("#taskChoiceA_edit_input").attr("value", result.taskChoiceA);
            $("#taskChoiceB_edit_input").attr("value", result.taskChoiceB);
            $("#taskChoiceC_edit_input").attr("value", result.taskChoiceC);
            $("#taskChoiceD_edit_input").attr("value", result.taskChoiceD);
            $("#correctAnswer_edit_input").attr("value", result.correctAnswer);
            $("#taskChoiceEditModal").modal({
                backdrop:"static"
            });
        }
    });

}

function taskEssayEdit(taskEssayId){
    alert(taskEssayId);
    $.ajax({
        url: "/trainer/getTaskEssayByEssayId",
        data: "taskEssayId="+taskEssayId,
        type: "GET",
        success: function(result){
            $("#taskEssayId_edit_input").attr("value", taskEssayId);
            $("#taskQ2_edit_input").attr("value", result.taskQ);

            $("#taskEssayEditModal").modal({
                backdrop:"static"
            });
        }
    });
}