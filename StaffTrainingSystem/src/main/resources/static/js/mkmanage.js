
$(function() {
    to_page(1);
    //displayAll();

    $("#mk_add_modal_btn").click(function(){

        //弹出模态框 {dateFormat: "yy-mm-dd"}
        $("#mkAddModal").modal({
            backdrop:"static"
        });
    });

    $( "#Begin_time_add_input" ).datepicker({dateFormat: "yy-mm-dd"});
    $( "#End_time_add_input" ).datepicker({dateFormat: "yy-mm-dd"});

    $( "#Begin_time_edit_input" ).datepicker({dateFormat: "yy-mm-dd"});
    $( "#End_time_edit_input" ).datepicker({dateFormat: "yy-mm-dd"});
    //点击保存，完成新增
    $("#mk_save_btn").click(function(){
        var formData=new FormData($("#mkAddModal form")[0]);
        if($("Begin_time_add_input").val()>$("End_time_add_input").val()){
            alert("起始时间不能大于截止时间！");
            return ;
        }

        $.ajax({
            url:"/Tmk/addTrainingmk",
            type:"POST",
            contentType:false,
            processData:false,
            data:formData,
            success:function(result){
                if(result.code == 100){
                    //模块保存成功；
                    alert("save success!!")
                    //1、关闭模态框
                    $("#mkAddModal").modal('hide');
                    to_page(totalRecord);
                }else{
                    alert(result.msg);
                }
                //模块保存成功；
//                alert("save success!!")
//                //1、关闭模态框
//                $("#mkAddModal").modal('hide');
//
//                //displayAll();
//                to_page(totalRecord);

            }
        });
    });

    //点击保存，保存编辑。
    $("#mk_edit_btn").click(function(){
        var formData=new FormData($("#mkEditModal form")[0]);


        $.ajax({
            url:"/Tmk/updateTrainingmk",
            type:"POST",
            contentType:false,
            processData:false,
            data:formData,
            success:function(result){
                //alert(result.msg);
                // if(result.code == 100){
                    //模块编辑成功；
                    alert("edit success!!")
                    //1、关闭模态框
                    $("#mkEditModal").modal('hide');

                    //2、来到当前页，显示刚才编辑的数据

                    to_page(currentPage);
                // }else{
                //
                //     console.log(result);
                //     to_page(currentPage);
                // }
            }
        });
    });


});

//模块编辑
function editMK(e){
    var id=$(e).attr("edit-id");
    //getDepts("#mkEditModal select");
    //弹出模态框
    $("#mkEditModal").modal({
        backdrop:"static"
    });
    $.ajax({
        url:"/Tmk/findTrainingmkById",
        type:"GET",
        data:"mkid=" + id,
        success:function(result){
            //时间转换
            // var b_time = new Date(result.beginTime);
            // b_time=b_time.getUTCFullYear()+"-"+(b_time.getMonth()+1)+"-"+b_time.getDate();
            // var e_time = new Date(result.endTime);
            // e_time=e_time.getUTCFullYear()+"-"+(e_time.getMonth()+1)+"-"+e_time.getDate();
            document.getElementById("mkedit_form").reset()
            $("#mkId_edit_input").attr("value",id);
            $("#mkName_edit_input").attr("value",result.mkname);
            $("#Scope_edit_input").val(result.scope);
            $("#Begin_time_edit_input").attr("value",formatDate(result.beginTime));
            $("#End_time_edit_input").attr("value",formatDate(result.endTime));
            $("#Accessory_edit_input").attr("value",result.accessory);
            $("#category_edit_input").val(result.category);
        }

    });
};




//单个删除
function deleteMK(e){
    var id=$(e).attr("del-id");
    $.ajax({
        url:"/Tmk/deleteTrainingmk",
        type:"POST",
        data:"mkid=" + id,
        success:function(result){
            alert("delete success!!")
            to_page(currentPage);
        }

    });
}
//批量删除
function deleteMKs(){
    $(".check_item:checked").each(function (){
        var id=$(this).attr("check-id");
        $.ajax({
            url:"/Tmk/deleteTrainingmk",
            type:"POST",
            data:"mkid=" + id,
            success:function(result){
                to_page(currentPage);
            }
        });
    })
    alert("deleteMK success!!")
}

//批量发布，改变模块状态
function publicMKs(){
    $(".check_item:checked").each(function (){
        var id=$(this).attr("check-id");
        $.ajax({
            url:"/Tmk/publicMKs",
            type:"POST",
            data:"mkid=" + id,
            success:function(result){
                to_page(currentPage);
            }
        });
    })
}



//  function formatDate(value) {
//     var date = new Date(value);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
//     var Y = date.getFullYear() + '-';
//     var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
//     var D = date.getDate() + ' ';
//     var h = date.getHours() + ':';
//     var m = date.getMinutes() + ':';
//     var s = date.getSeconds();
//     return Y+M+D+h+m+s;
// }

function formatDate(value) {
    var date = new Date(value);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getUTCFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = date.getDate();

    return Y+M+D;
}


//分页显示
function to_page(pn){
    $.ajax({
        url:"/Tmk/queryAllMKByPage",
        data:"pn="+pn,
        type:"GET",
        success:function(result){
            //console.log(result);
            //1、解析并显示模块数据
            build_mk_table(result);
            //2、解析并显示分页信息
            build_page_info(result);
            //3、解析显示分页条数据
            build_page_nav(result);
        }
    });
}
function build_mk_table(result){
    //清空table表格
    $("#mk_table tbody").empty();
    var mk = result.pageInfo.list; //(真实数据)
    $.each(mk,function(index,item){
        var checkBox=$("<input type='checkbox' class='check_item'/>")
        checkBox.attr("check-id",item.mkid);
        var checkBoxTd = $("<td></td>").append(checkBox);


        //时间转换
        // var b_time = new Date(result.beginTime);
        // b_time=b_time.getUTCFullYear()+"-"+(b_time.getMonth()+1)+"-"+b_time.getDate();
        // var e_time = new Date(result.endTime);
        // e_time=e_time.getUTCFullYear()+"-"+(e_time.getMonth()+1)+"-"+e_time.getDate();
        var a="<a href=''></a>";
        var mknameTd ="";
        //alert("s");
        if(item.category=="专业"){
            //alert("1111");
            mknameTd = $("<td></td>").append($("<a href='MKSet_ReadMaterial.html?mkid="+item.mkid+"'></a>").append(item.mkname));
        }else{
            //alert("pp");
            mknameTd = $("<td></td>").append(item.mkname);
        }

        var scopeTd = $("<td></td>").append(item.scope);
        var beginTimeTd = $("<td></td>").append(formatDate(item.beginTime));
        var endTimeTd = $("<td></td>").append(formatDate(item.endTime));
        var accessoryTd = $("<td></td>").append($("<a href='/Tmk/mydownLoad/"+item.accessory+"'></a>").append(item.accessory));
        var categoryTd = $("<td></td>").append(item.category);
        var authorIdTd = $("<td></td>").append(item.authorId);
        var isPublicTd = $("<td></td>").append(item.isPublic);
        var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
            .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
        //为编辑按钮添加一个自定义的属性，来表示当前模块id
        editBtn.attr("edit-id", item.mkid);
        editBtn.attr("onclick", 'editMK(this)');
        var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
            .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
        //为删除按钮添加一个自定义的属性来表示当前删除的模块id
        delBtn.attr("del-id", item.mkid);
        delBtn.attr("onclick", 'deleteMK(this)');
        var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
        console.log("开始时间："+item.beginTime+"结束时间："+item.endTime);
        console.log("开始时间："+formatDate(item.beginTime)+"结束时间："+formatDate(item.endTime));
        //append方法执行完成以后还是返回原来的元素
        $("<tr></tr>").append(checkBoxTd)
            .append(mknameTd)
            .append(scopeTd)
            .append(beginTimeTd)
            .append(endTimeTd)
            .append(accessoryTd)
            .append(categoryTd)
            .append(authorIdTd)
            .append(isPublicTd)
            .append(btnTd)
            .appendTo("#mk_table tbody");
    });
}


function build_page_info(result) {
    $("#page_info_area").empty();
    $("#page_info_area").append("当前"+result.pageInfo.pageNum+"页,总"+
        result.pageInfo.pages+"页,总"+
        result.pageInfo.total+"条记录");
    totalRecord = result.pageInfo.total;
    currentPage = result.pageInfo.pageNum;
}

//解析显示分页条，点击分页要能去下一页....
function build_page_nav(result) {
    //page_nav_area
    $("#page_nav_area").empty();
    var ul = $("<ul></ul>").addClass("pagination");

    //构建元素
    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
    var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
    if (result.pageInfo.hasPreviousPage == false) {
        firstPageLi.addClass("disabled");
        prePageLi.addClass("disabled");
    } else {
        //为元素添加点击翻页的事件
        firstPageLi.click(function () {
            to_page(1);
        });
        prePageLi.click(function () {
            to_page(result.pageInfo.pageNum - 1);
        });
    }
    var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
    var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
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


    //添加首页和前一页 的提示
    ul.append(firstPageLi).append(prePageLi);
    //1,2，3遍历给ul中添加页码提示
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
    //添加下一页和末页 的提示
    ul.append(nextPageLi).append(lastPageLi);

    //把ul加入到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#page_nav_area");
}





