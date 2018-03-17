<%--
  Created by IntelliJ IDEA.
  User: mycom
  Date: 2018/3/10
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <td>标题</td>
        <td>链接</td>
    </tr>
    <c:if test="${cnblogs!=null}">
        <c:forEach items="${cnblogs}" var="item">
            <tr>
                <td>${item.context}</td>
                <td>${item.address}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
