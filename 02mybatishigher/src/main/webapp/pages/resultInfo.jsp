<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mycom
  Date: 2018/2/5
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>成绩的详细情况</title>
    <script type="text/javascript" src="/pages/lib/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("table tr:even").addClass("bg1");
            $("table tr:odd").addClass("bg2");
        })
    </script>
    <style type="text/css">
        .bg1{
            background-color: #99cdff;
        }
        .bg2{
            background-color: #0092DC;
        }
    </style>
</head>
<body>
<p>成绩最高分：<br><span style="background-color: #00ee00">${max.studentName}同学：&nbsp;${max.score}分</span></p>
<p>成绩最低分：<br><span style="background-color: #3c8b3c">${min.studentName}同学：&nbsp;${min.score}分</span></p>
<p>平均分：<br>&nbsp;<span style="background-color: #3c8b3c">${avg.score}分</span></p>
    <table>
        <tr>
            <td>题号</td><td>错误人数</td>
        </tr>
        <c:forEach items="${error}" var="items">
            <tr>
                <td>${items.tid}</td><td>${items.counts}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
