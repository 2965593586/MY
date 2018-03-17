<%--
  Created by IntelliJ IDEA.
  User: mycom
  Date: 2018/1/31
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title></title>

    <style type="text/css">

        body{
            font-size:20px;
            background:#cde6c7;
            font-family:"宋体";
        }

        #container{
            margin:0px auto;
        }

        #box{
            /* border:1px solid red; */
            overflow:hidden;

        }

        #box label{
            margin-top:5px;
            background:#f6f6f6;
            width:80px;
            display:inline-block;
            text-align:right;
            margin-left:50px;
        }
    </style>
    <script type="text/javascript">
        //加载完所有的标签，图片和css后执行
        window.onload=function(){
            var row=15;
            var col=2;
            var mybody=document.getElementById('mybody');
            if(col>4){
                mybody.style.width=document.body.scrollWidth+(col-4)*350;
            }

            //mybody.style.width="3333px";
            initOptions(row,col);
            //alert(body.documentElement.clientWidth);
            // document.body.scrollWidth=3333;
            var cbxs=document.getElementsByName("rchoice");
            for ( var i = 0; i < cbxs.length; i++) {
                cbxs[i].style.cssText="margin-left:20px;";
            }
        };

        function shengcheng(){
            $("#box").empty();
            var row=document.getElementById("rows").value;
            var col=document.getElementById("cols").value;
            var mybody=document.getElementById('mybody');
            if(col>4){
                mybody.style.width=document.body.scrollWidth+(col-4)*350;
            }
            initOptions(row,col);
            var cbxs=document.getElementsByName("rchoice");
            for ( var i = 0; i < cbxs.length; i++) {
                cbxs[i].style.cssText="margin-left:20px;";
            }
        }

        //动态加载答题区控件！
        function initOptions(row,column) {
            var box = document.getElementById('box');
            //题目编号，从0开始
            var count = 0;
            var mytag; //CheckBox的Tag属性值
            //
            for (var i = 1; i <= row; i++) {  //默认i的值为15
                count++;
                var mydiv = document.createElement("div");
                box.appendChild(mydiv);
                //mydiv.style.border="1px solid blue";
                // mydiv.style.paddingRight="700px";
                mydiv.style.overflow = "auto";
                for (var j = 1; j <= column; j++) {   //默认j的值为2
                    //创建一个label
                    var label = document.createElement('label');
                    label.setAttribute("id", "tid");
                    //设置座位号
                    if (j == 1) {
                        label.innerHTML = count + "题";
                        mytag = count;
                    }
                    else {
                        //多列的情况下创建题目编号的方式
                        label.innerHTML = (count + row * (j - 1)) + "题";
                        mytag = count + row * (j - 1);
                    }
                    var littlediv = document.createElement("div");
                    littlediv.style.float = "left";

                    //littlediv.style.border="3px solid blue";
                    mydiv.appendChild(littlediv);
                    littlediv.appendChild(label);
                    //创建四个选项
                    var checkbox1 = document.createElement("input");
                    checkbox1.setAttribute("type", "checkbox");
                    checkbox1.setAttribute("value", "A");
                    checkbox1.setAttribute("name", "rchoice"+mytag);
                    var cbtxt = document.createTextNode("A");
                    littlediv.appendChild(checkbox1);
                    littlediv.appendChild(cbtxt);

                    //第二个checkbox
                    var checkbox2 = document.createElement("input");
                    checkbox2.setAttribute("type", "checkbox");
                    checkbox2.setAttribute("value", "B");
                    checkbox2.setAttribute("name", "rchoice"+mytag);
                    var cbtxt2 = document.createTextNode("B");
                    littlediv.appendChild(checkbox2);
                    littlediv.appendChild(cbtxt2);
                    //第三个checkbox
                    var checkbox3 = document.createElement("input");
                    checkbox3.setAttribute("type", "checkbox");
                    checkbox3.setAttribute("value", "C");
                    checkbox3.setAttribute("name", "rchoice"+mytag);
                    var cbtxt3 = document.createTextNode("C");
                    littlediv.appendChild(checkbox3);
                    littlediv.appendChild(cbtxt3);

                    //第四个checkbox
                    var checkbox4 = document.createElement("input");
                    checkbox4.setAttribute("type", "checkbox");
                    checkbox4.setAttribute("value", "D");
                    checkbox4.setAttribute("name", "rchoice"+mytag);
                    var cbtxt4 = document.createTextNode("D");
                    littlediv.appendChild(checkbox4);
                    littlediv.appendChild(cbtxt4);
                    var myline = document.createElement("br");

                    if (j == column) {
                        mydiv.appendChild(myline);
                    }
                }
            }


        }

    </script>

    <script type="text/javascript" src="lib/jquery-1.8.3.min.js"></script></head>

<body id="mybody">
<div id="container">
    <form action="${pageContext.request.contextPath}/servlet/StuAnswerServlet" method="post">
        <div id="box">

        </div>
        &nbsp;&nbsp;<input type="text" id="rows" name="row" size="1">行&nbsp;&nbsp;<input type="text" id="cols" name="col" size="1">列&nbsp;
        <input type="button" value="生成" onclick="shengcheng()">&nbsp;&nbsp;
        <input type="text" name="stuName" id="sName"/>请输入学生姓名&nbsp;&nbsp;
        <input type="text" name="className" id="cName"/>请输入班级名称
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>
