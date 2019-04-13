
/**
 * Created by dzl on 2015/12/18.
 */
var totalNumber1;
var pageSize1;
var pageNumber1
function pagination(totalNumber,pageSize,pageNumber){
    //window.location.search :?号后面部分
    //window.location.pathname : area/index
    //window.location.href 完整的
    totalNumber1 = totalNumber;
    pageSize1 = pageSize;
    pageNumber1 = pageNumber;

    var fenyeDiv = document.getElementById("pagination_page");
    var fenyehtml = "<div class='col-sm-6'><ul class='pagination' id='pagination'></ul></div><div class='col-sm-offset-5'><label style='margin: 30px;'>共计"+totalNumber+"条记录</label></div>";
    fenyeDiv.innerHTML=fenyehtml;


    var pageCount = Math.ceil(totalNumber/pageSize);//共计页数
    var html = '';
    if(pageNumber==1){
        html = "<li class='disabled'><a  href='#'  aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>";
    }else{
        html = "<li><a href=\"javascript:getJsUrl("+(pageNumber-1)+")\";  aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>";
    }
    if(pageCount<=10){//小于10的，全展示
        for(var i = 0;i<pageCount;i++){
            if(pageNumber==i+1){
                var link_Url = "<li class='active'><a href=\"javascript:getJsUrl("+(i+1)+");\">"+(i+1)+"</a></li>";
            }else
                var link_Url = "<li><a href=\"javascript:getJsUrl("+(i+1)+");\">"+(i+1)+"</a></li>";
            html += link_Url;
        }
    }else{
        if(pageNumber<5){
            for(var i = 0;i<pageCount;i++){
                if(i<5){
                    if(pageNumber==i+1){
                        var link_Url = "<li class='active'><a href=\"javascript:getJsUrl("+(i+1)+");\">"+(i+1)+"</a></li>";
                    }else {
                        var link_Url = "<li><a href=\"javascript:getJsUrl("+(i+1)+");\">" + (i + 1) + "</a></li>";
                    }
                    html += link_Url;
                }
            }
            html += "<li><a>...</a></li>";
            html += "<li><a href=\"javascript:getJsUrl("+(i)+");\">"+(i)+"</a></li>";
        }else if(pageNumber>=5 && pageNumber<pageCount-3){
            html += "<li><a href=\"javascript:getJsUrl("+(1)+");\">"+1+"</a></li>";
            html += "<li><a>...</a></li>";
            for(var i = 0;i<pageCount;i++){

                if(i>=pageNumber-2 && i <= pageNumber +0 ){
                    if(pageNumber==i+1){
                        var link_Url = "<li class='active'><a href=\"javascript:getJsUrl("+(i+1)+");\">"+(i+1)+"</a></li>";
                    }else {
                        var link_Url = "<li><a href=\"javascript:getJsUrl("+(i+1)+");\">" + (i + 1) + "</a></li>";
                    }
                    html += link_Url;
                }
            }
            html += "<li><a>...</a></li>";
            html += "<li><a href=\"javascript:getJsUrl("+(i)+");\">"+i+"</a></li>";
        }else{
            html += "<li><a href=\"javascript:getJsUrl("+1+");\">"+(1)+"</a></li>";
            html += "<li><a>...</a></li>";
            for(var i = 0;i<pageCount;i++){

                if(i>=pageCount-5){
                    if(pageNumber==i+1){
                        var link_Url = "<li class='active'><a href=\"javascript:getJsUrl("+(i+1)+");\">"+(i+1)+"</a></li>";
                    }else{
                        var link_Url = "<li><a href=\"javascript:getJsUrl("+(i+1)+");\">"+(i+1)+"</a></li>";
                    }
                    html += link_Url;
                }
            }


        }

    }
    if(i==pageNumber){
        html += "<li  class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
    }else{
        html += "<li><a href=\"javascript:getJsUrl("+(pageNumber+1)+")\"; aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
    }

    html += "<li style='width: 50px;float: left;margin-left: 10px'><input id='paginationGo'" +
        " type='text' class='form-control'/></li>" +
        "<li style='width: 50px;float: left;margin-left: 10px'><a href=\"javascript:paginationGo();\" text-align:center;>Go</a></li>";
    var fenyeUL = document.getElementById("pagination");
    fenyeUL.innerHTML=html;
}
//go 跳转到指定页面
function paginationGo(){
    var pageCount = Math.ceil(totalNumber1/pageSize1);//共计页数
    var inputNum = $("#paginationGo").val();//输入的要跳转的页面

    if(isNaN(inputNum)){
        showMessageWindow("info", "提示", "请输入有效数字", 2000, false, "right");
        return;
    }

    if(isEmpty(inputNum)){
        showMessageWindow("info", "提示", "跳转参数不可为空", 2000, false, "right");
        return;
    }

    if (inputNum.indexOf(" ") != -1 || inputNum.indexOf(".") != -1) {
        showMessageWindow("info", "提示", "跳转参数参数非法", 2000, false, "right");
        return;
    }

    if(inputNum > pageCount){

        getJsUrl(pageNumber1);
    }else{
        getJsUrl(inputNum);
    }

}

function getJsUrl(pageNo) {
    var pos, str, para, parastr;
    var tempurl = '';
    str = location.href;
    //alert(str);
    str = str.replace("&operation=delete","");//广告管理页面 微改动
    //alert(str);
    if (str.indexOf("?") < 0) {
        tempurl = str + "?pageNumber=" + pageNo;
    } else {
        parastr = str.split("?")[1];
        var arr = parastr.split("&");
        var has = false;
        for (var i = 0; i < arr.length; i++) {
            if (arr[i].split("=")[0] == 'pageNumber') {
                tempurl = str.replace(arr[i],'pageNumber='+pageNo);
                has = true;
            }
            //array[arr[i].split("=")[0]]=arr[i].split("=")[1];
        }
        if(!has){
            tempurl = str + "&pageNumber="+pageNo;
        }
    }

    window.location.href=tempurl;
}