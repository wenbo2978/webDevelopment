$(function(){



});

function essayScoreSave(taskEssayId){
    alert("taskEssayId");
    $.ajax({
        url: "/trainer/setEssayScore",
        type: "POST",
        data: $("#essayScoreSave_form" + taskEssayId).serialize(),
        success: function(result){
            $("#essayScore" + taskEssayId).attr("value", result);
            alert("change success:" + result);
        }
    });
}
