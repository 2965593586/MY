<%--
  Created by IntelliJ IDEA.
  User: mycom
  Date: 2018/2/6
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/jquery.easyui.min.js"></script>

    <script type="text/javascript">
        $(function () {
            /*$.messager.alert('My Title','Here is a question message!','question');*/
            /*$.messager.show({
                title:'My Title',
                msg:'Message will be closed after 4 seconds.',
                showType:'show'
            });*/

            $('#dd').datebox( {
                currentText : '今天',
                closeText : '关闭',
                disabled : false,
                required : true,
                missingMessage : '必填',
                formatter : formatDate

            });
            function formatDate(v) {
                if (v instanceof Date) {
                    var y = v.getFullYear();
                    var m = v.getMonth() + 1;
                    var d = v.getDate();
                    var h = v.getHours();
                    var i = v.getMinutes();
                    var s = v.getSeconds();
                    var ms = v.getMilliseconds();
                    if (ms > 0)
                        return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s
                            + '.' + ms;
                    if (h > 0 || i > 0 || s > 0)
                        return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s;
                    return y + '-' + m + '-' + d;
                }
                return '';
            }
            function disable() {
                $('#dd').datebox('disable');
            }
            function enable() {
                $('#dd').datebox('enable');
            }

        });

    </script>
</head>
<body>
<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"
       data-options="singleSelect:true,collapsible:true,url:'${pageContext.request.contextPath}/servlet/UserInfoServlet',method:'get'">
    <thead>
    <tr>
        <th data-options="field:'uId',width:80">用户编号</th>
        <th data-options="field:'uName',width:100">用户名称</th>
        <th data-options="field:'uStatus',width:60,align:'center'">状态</th>
        <th data-options="field:'attr1',width:250">操作</th>

    </tr>
    </thead>


    <h1>DateBox</h1>
    <div style="margin-bottom: 10px;"><a href="#" onclick=
            disable();
    >disable</a>
        <a href="#" onclick=
                enable();
        >enable</a></div>
    <input id="dd"></input>
</table>
</body>
</html>
