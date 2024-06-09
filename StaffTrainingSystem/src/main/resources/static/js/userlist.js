var totalRecord,currentPage;
$(function() {
    //show All users
    // displayAll();

    //Pagination，show first page
    to_page(1);

    $("#user_add_modal_btn").click(function(){

        //modal dialog popup
        $("#userAddModal").modal({
            backdrop:"static"
        });
    });

    //click save，finish user adding
    $("#user_save_btn").click(function(){
        $.ajax({
            url:"/admin/addUser",
            type:"POST",
            data:$("#userAddModal form").serialize(),
            success:function(result){

                //user info save success
                alert("save success!!")
                //close modal
                $("#userAddModal").modal('hide');

                //displayAll();
                to_page(totalRecord);

            }
        });
    });

    //click save, finish edit
    $("#user_edit_btn").click(function(){

        $.ajax({
            url:"/admin/updateUser",
            type:"POST",
            data:$("#useredit_form").serialize(),
            success:function(result){

                alert("edit success!!")
                //close modal
                $("#userEditModal").modal('hide');

                //goto current page show edition info

                to_page(currentPage);

            }
        });
    });

});

//single deletion
function deleteUser(e){
    var id=$(e).attr("del-id");
    $.ajax({
        url:"/admin/deleteUser",
        type:"POST",
        data:"userId=" + id,
        success:function(result){
            alert("delete success!!")
            to_page(currentPage);
        }

    });
}
//multi deletion
function deleteUsers(){
    $(".check_item:checked").each(function (){
        var id=$(this).attr("check-id");
        $.ajax({
            url:"/admin/deleteUser",
            type:"POST",
            data:"userId=" + id,
            success:function(result){
                to_page(currentPage);
            }
        });
    })
    alert("deleteUsers success!!")
}

function editUser(e){
    var id=$(e).attr("edit-id");
    //show modal
    $("#userEditModal").modal({
        backdrop:"static"
    });
    $.ajax({
        url:"/admin/findUserById",
        type:"GET",
        data:"userId=" + id,
        success:function(result){

            document.getElementById("useredit_form").reset()
            $("#userId_edit_input").attr("value",id);
            $("#username_edit_input").attr("value",result.username);
            $("#password_edit_input").val(result.password);
            $("#realname_edit_input").attr("value",result.realname);
            $("#phone_edit_input").attr("value",result.phone);
            $("#email_edit_input").attr("value",result.email);
            $("#authority_edit_input").val(result.authority);
        }

    });
};
//Pagination
function to_page(pn){
    $.ajax({
        url:"/admin/queryAllByPage",
        data:"pn="+pn,
        type:"GET",
        success:function(result){
            //console.log(result);
            //show user info
            build_user_table(result);
            //show pagination info
            build_page_info(result);
            //show page info
            build_page_nav(result);
        }
    });
}
function build_user_table(result){
    //make table empty
    $("#user_table tbody").empty();
    var user = result.pageInfo.list;
    $.each(user,function(index,item){
        var checkBox=$("<input type='checkbox' class='check_item'/>")
        checkBox.attr("check-id",item.userid);
        var checkBoxTd = $("<td></td>").append(checkBox);


        var usernameTd = $("<td></td>").append(item.username);
        var passwordTd = $("<td></td>").append(item.password);
        var realnameTd = $("<td></td>").append(item.realname);
        var phoneTd = $("<td></td>").append(item.phone);
        var emailTd = $("<td></td>").append(item.email);
        var authorityTd = $("<td></td>").append(item.authority);
        var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
            .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("Edit");
        //add new attribution
        editBtn.attr("edit-id",item.userid);
        editBtn.attr("onclick",'editUser(this)');
        var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
            .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("Delete");
        //add new attribution
        delBtn.attr("del-id",item.userid);
        delBtn.attr("onclick",'deleteUser(this)');
        var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);

        //append
        $("<tr></tr>").append(checkBoxTd)
            .append(usernameTd)
            .append(passwordTd)
            .append(realnameTd)
            .append(phoneTd)
            .append(emailTd)
            .append(authorityTd)
            .append(btnTd)
            .appendTo("#user_table tbody");
    });
}


function build_page_info(result) {
    $("#page_info_area").empty();
    $("#page_info_area").append("Page: "+result.pageInfo.pageNum+",Total Page: "+
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


    //add first and previous page
    ul.append(firstPageLi).append(prePageLi);
    //
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
    //add last and next page
    ul.append(nextPageLi).append(lastPageLi);

    //add ul into nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#page_nav_area");
}


