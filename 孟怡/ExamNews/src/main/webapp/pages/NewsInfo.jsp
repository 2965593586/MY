<%--
  Created by IntelliJ IDEA.
  User: mycom
  Date: 2018/3/1
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/pages/js/jquery.js"></script>
    <script type="text/javascript">
        function cl() {
            var talkContent=$("#talkContent");
            alert(talkContent);
            $.ajax({
                url:"/ExamNews/NewsServlet",
                type:"post",
                data:{
                    "talkContent":talkContent,
                    "oper":"talk"
                },
                success:function (json) {
                    alert(json);
                }
            })
        }
    </script>
</head>
<body>
<div>
    <p>内容：${newsInfo.newsContent}</p>
    <table>
        <tr>
            <td>评论内容</td>
            <td>评论时间</td>
        </tr>
        <c:if test="${newsInfo.talks!=null}">
            <c:forEach items="${newsInfo.talks}" var="item">
                <tr>
                    <td>${item.content}</td>
                    <td>${item.tTime}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <form action="/ExamNews/NewsServlet" method="post">
        <input type="hidden" name="oper" value="talk">
        <textarea cols="50" rows="20" id="talkContent" name="talkContent"></textarea><br>
        <%--<input type="button" value="提交" id="btn">--%>
        <input type="submit" value="提交">
        <%--<button onclick="cl()">提交</button>--%>
    </form>


</div>

</body>
</html>
