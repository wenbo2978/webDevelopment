var totalRecord,currentPage;
$(function(){

    //Pagination，show first page
    to_page(1);

    //click save adding finish
    $("#task_save_btn").click(function(){
        var formData = new FormData($("#taskAddModal form")[0]);
        $.ajax({
            url:"/trainer/addTask",
            type:"POST",
            data:formData,
            processData: false, // Prevents jQuery from automatically transforming the data into a query string
            contentType: false, // Prevents jQuery from setting the Content-Type header, letting the browser set it with the boundary
            success:function(result){

                //task save success；
                alert("save success!!")
                //close modal
                $("#taskAddModal").modal('hide');

                //displayAll();
                to_page(totalRecord);

            }
        });
    });

    //click save, edit finish
    $("#task_save_edit_btn").click(function(){
        alert("save edit");
        var formData = new FormData($("#taskEditModal form")[0]);
        $.ajax({
            url:"/trainer/updateTask",
            type:"POST",
            //data:$("#useredit_form").serialize(),
            data:formData,
            processData: false,
            contentType: false,
            success:function(result){

                alert("edit success!!")
                //1、关闭模态框
                $("#taskEditModal").modal('hide');

                //2、来到当前页，显示刚才编辑的数据

                to_page(currentPage);

            }
        });
    });

    //save taskChoice
    $("#taskChoice_save_btn").click(function(){
        alert("save Choice");
        //var formData = new FormData($("#taskChoiceAddModal form")[0]);
        $.ajax({
            url: "/trainer/addTaskChoice",
            data: $("#taskChoiceAddModal form").serialize(),
            type: "POST",
            success: function(result){
                alert("add success!!")
                //1、关闭模态框
                $("#taskChoiceAddModal").modal('hide');
            }
        });
    });

    //save taskEssay
    $("#taskEssay_save_btn").click(function(){
        alert("save Essay");
        //var formData = new FormData($("#taskChoiceAddModal form")[0]);
        $.ajax({
            url: "/trainer/addTaskEssay",
            data: $("#taskEssayAddModal form").serialize(),
            type: "POST",
            success: function(result){
                alert("add success!!")
                //close modal
                $("#taskEssayAddModal").modal('hide');
            }
        });
    });
});





function addTask(e){
    alert("add");
    //modal dialog popup
    $("#taskAddModal").modal({
        backdrop:"static"
    });
}

function addTaskChoice(e){
    alert("addChoiceQ");
    //modal dialog popup
    $.ajax({
        url: "/trainer/getTaskIdByUserId",
        type: "GET",
        success: function(result){
            $("#taskIdChoiceQ_add_input").empty();
            var content = "";
            $.each(result, function(index, item){
                content += "<option value='" + item.taskId + "'>" + item.taskName + "</option>";
            });
            $("#taskIdChoiceQ_add_input").append(content);
            $("#taskChoiceAddModal").modal({
                backdrop:"static"
            });
        }
    });

}

function addTaskEssay(e){
    alert("addEssayQ");
    //modal dialog popup
    $.ajax({
        url: "/trainer/getTaskIdByUserId",
        type: "GET",
        success: function(result){
            $("#taskIdEssayQ_add_input").empty();
            var content = "";
            $.each(result, function(index, item){
                content += "<option value='" + item.taskId + "'>" + item.taskName + "</option>";
            });
            $("#taskIdEssayQ_add_input").append(content);
            $("#taskEssayAddModal").modal({
                backdrop:"static"
            });
        }


    });

}

//single delete
function deleteTask(e){
    var id=$(e).attr("del-id");
    $.ajax({
        url:"/trainer/deleteTask",
        type:"POST",
        data:"taskId=" + id,
        success:function(result){
            alert("delete success!!")
            to_page(currentPage);
        }

    });
}

//multiple delete
function deleteTasks(){
    $(".check_item:checked").each(function (){
        var id=$(this).attr("check-id");
        $.ajax({
            url:"/trainer/deleteTask",
            type:"POST",
            data:"taskId=" + id,
            success:function(result){
                to_page(currentPage);
            }
        });
    })
    alert("deleteTasks success!!")
}


function publishTask(e){
    alert("task publish");
    var id=$(e).attr("publish-id");
    $.ajax({
        url:"/trainer/taskPublish",
        type:"POST",
        data:"taskId=" + id,
        success:function(result){
            alert("publish success!!")
            to_page(currentPage);
        }

    });
}

function editTask(e){
    var id=$(e).attr("edit-id");
    //getDepts("#mkEditModal select");
    //modal popup
    $("#taskEditModal").modal({
        backdrop:"static"
    });
    $.ajax({
        url:"/trainer/findTaskById",
        type:"GET",
        data:"taskId=" + id,
        success:function(result){

            document.getElementById("taskEdit_form").reset()
            $("#taskId_edit_input").attr("value",id);
            $("#taskName_edit_input").attr("value",result.taskName);
            $("#scope_edit_input").val(result.scope);
            $("#category_edit_input").attr("value",result.category);
            $("#begin_Time_Edit").attr("value",result.Begin_Time);
            $("#end_Time_Edit").attr("value",result.End_Time);
            $("#attachmentEdit").attr("value",result.attachment);
        }

    });
};

//Pagination
function to_page(pn){
    $.ajax({
        url:"/trainer/queryAllByPage",
        data:"pn="+pn,
        type:"GET",
        success:function(result){
            //console.log(result);
            //show task info
            build_task_table(result);
            //show pagination info
            build_page_info(result);
            //show page info
            build_page_nav(result);
        }
    });
}

function build_task_table(result){
    //empty table

    $("#task_table tbody").empty();
    var task = result.pageInfo.list;
    $.each(task,function(index,item){
        var checkBox=$("<input type='checkbox' class='check_item'/>")
        checkBox.attr("check-id",item.taskId);
        var checkBoxTd;
        if(item.isPublished == "unPublished")
            checkBoxTd = $("<td></td>").append(checkBox);
        else
            checkBoxTd = $("<td></td>").append("X");
        var $anchor = $('<a></a>');
        $anchor.attr('href', '/trainer/taskContent/' + item.taskId);
        $anchor.text(item.taskName);
        var taskNameTd = $("<td></td>").append($anchor);
        //var $anchor = $('<a></a>');
        var scopeTd = $("<td></td>").append(item.scope);
        var beginTimeTd = $("<td></td>").append(item.begin_Time);
        var endTd = $("<td></td>").append(item.end_Time);
        var attachmentTd = $("<td></td>").append(item.attachment);
        var isPublishedTd = $("<td></td>");
        if(item.isPublished == "unPublished"){
            $isPublishedTd = $("<a></a>");
            $isPublishedTd.attr('href', 'javascript:void(0);');
            $isPublishedTd.attr('onclick', 'publishTask(this)');
            $isPublishedTd.attr("publish-id", item.taskId);
            $isPublishedTd.text(item.isPublished);
            isPublishedTd.append($isPublishedTd);
        }else{
            isPublishedTd.append(item.isPublished);
        }
        var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
            .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("Edit");
        //
        editBtn.attr("edit-id",item.taskId);
        editBtn.attr("onclick",'editTask(this)');
        var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
            .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("Delete");
        //
        delBtn.attr("del-id",item.taskId);
        delBtn.attr("onclick",'deleteTask(this)');
        var btnTd;
        if(item.isPublished == "unPublished")
            btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
        else
            btnTd = $("<td></td>").append("Locked");
        //
        $("<tr></tr>").append(checkBoxTd)
            .append(taskNameTd)
            .append(scopeTd)
            .append(beginTimeTd)
            .append(endTd)
            .append(attachmentTd)
            .append(isPublishedTd)
            .append(btnTd)
            .appendTo("#task_table tbody");
    });
}

function build_page_info(result) {
    $("#page_info_area").empty();
    $("#page_info_area").append("Page: "+result.pageInfo.pageNum+", Total Page: "+
        result.pageInfo.pages+", Total info: "+
        result.pageInfo.total);
    totalRecord = result.pageInfo.total;
    currentPage = result.pageInfo.pageNum;
}

//show pagination info, go to next by click ">"
function build_page_nav(result) {
    //page_nav_area
    $("#page_nav_area").empty();
    var ul = $("<ul></ul>").addClass("pagination");


    var firstPageLi = $("<li></li>").append($("<a></a>").append("First").attr("href", "#"));
    var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
    if (result.pageInfo.hasPreviousPage == false) {
        firstPageLi.addClass("disabled");
        prePageLi.addClass("disabled");
    } else {

        firstPageLi.click(function () {
            to_page(1);
        });
        prePageLi.click(function () {
            to_page(result.pageInfo.pageNum - 1);
        });
    }
    var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
    var lastPageLi = $("<li></li>").append($("<a></a>").append("Last").attr("href","#"));
    if(result.pageInfo.hasNextPage == false){
        nextPageLi.addClass("disabled");
        lastPageLi.addClass("disabled");
    }else{
        nextPageLi.click(function(){
            to_page(result.pageInfo.pageNum +1);
        });
        lastPageLi.click(function(){
            to_page(result.pageInfo.pages);
        });
    }



    ul.append(firstPageLi).append(prePageLi);

    $.each(result.pageInfo.navigatepageNums,function(index,item){

        var numLi = $("<li></li>").append($("<a></a>").append(item));
        if(result.pageInfo.pageNum == item){
            numLi.addClass("active");
        }
        numLi.click(function(){
            to_page(item);
        });
        ul.append(numLi);
    });

    ul.append(nextPageLi).append(lastPageLi);


    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#page_nav_area");
}