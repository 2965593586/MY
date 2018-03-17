<%--
  Created by IntelliJ IDEA.
  User: mycom
  Date: 2018/2/3
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<html>
<head>

    <title>查看班级成绩</title>
    <script type="text/javascript" src="/pages/lib/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        function zzz(){
            //获取班级名称
            var cName=$("#cName").val();
            var html="";
            var mytable=$("#mytable");
            $.ajax({
                url:"/servlet/ResultServlet",
                type:"post",
                data:{
                    cName:cName,
                    action:"select"
                },
                success:function(json){
                    html="<tr><td>姓名</td><td>班级</td><td>成绩</td><td>考试日期</td></tr>";
                    var e=eval("("+json+")");
                    $.each(e,function (i,item) {
                        html+="<tr><td>"+item.studentName+"</td><td>"+item.className+"</td><td>"+item.score+"</td><td>"+item.dateTime+"</td></tr>";
                    });
                    mytable.html(html);
                }
            })
            mytable.css({"border": "1px solid"},{"text-align": "center"});
        }
    function  info() {
        var cName=$("#cName").val();
        window.location="${pageContext.request.contextPath}/servlet/ResultServlet?action=info&cName="+cName;
    }

    </script>
    <style type="text/css">
        tr,td{
            border: 1px solid;
            text-align: center;
        }
        table{
            width:500px;
            margin: 0px auto;
        }
    </style>
    </head>
<body>
<p style="text-align: center">
    请输入班级名称：<input type="text" name="className" id="cName"/>
    <input type="button" value="查看" id="select" name="selectClass" onclick="zzz()">&nbsp;
    <input type="button" value="查看成绩的详细情况" onclick="info()">&nbsp;
    <table id="mytable">

    </table>
</p>
</body>
</html>
