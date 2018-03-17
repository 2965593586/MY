<%--
  Created by IntelliJ IDEA.
  User: mycom
  Date: 2018/3/1
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/pages/js/jquery.js"></script>
    <script type="text/javascript">
        var num=1;
        $(function () {
            myAjax(num);
        })
        function myAjax(pageIndex){
            var html=[];
            $.ajax({
                url:"/ExamNews/NewsServlet",
                data:{
                    "pageIndex":pageIndex,
                    "oper":"page"
                },
                type:"post",
                success:function (json) {
                    var json=eval("("+json+")");
                    html[0]="<tr><td>编号</td><td>标题</td><td>访问量</td><td>评论次数</td></tr>"
                    $(json).each(function (i,item) {
                        html[i+1]+="<tr><td>"+item.newsId+"</td><td><a href='${pageContext.request.contextPath}/NewsServlet?oper=click&newsId="+item.newsId+"'>"+item.newsTitle+"</a></td><td>"+item.clickCount+"</td><td>"+item.talks.length+"</td></tr>";
                    });
                    $("table").html(html);
                }
            });
        }
        function add(){
            num++;
            myAjax(num);
        }
        function sub(){
            if(num>0){
                num--;
                myAjax(num);
            }
        }
    </script>
</head>
<body>
<div style="margin: 0 auto">
    <table style="margin: 0 auto" border="1px">

    </table>
    <div style="margin-inside: 100px;padding-left: 700px" border="1px">
        <a href="#" onclick="sub()">上一页</a>  <a href="#" onclick="add()">下一页</a>
    </div>
    </div>


</body>
</html>
