<%--
  Created by IntelliJ IDEA.
  User: mycom
  Date: 2018/2/1
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>教师录入答案</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/servlet/TeacherAnswerServlet" method="post">
        <p style="text-align: center">
            请输入答案：只用填写答案就可以，每题用”，“分割<br>
        <textarea rows="100" cols="100" style="width: 500px;height: 300px" name="answer"></textarea>
        </p>
        <p style="text-align: center">
         班级：<input type="text" name="className"/>
        </p>
        <p style="text-align: center">
            <input type="submit" value="提交"/>
        </p>
    </form>
</body>
</html>
