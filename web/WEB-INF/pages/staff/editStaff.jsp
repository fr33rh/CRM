<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[员工管理]</td>

        <td width="52%" align="right">
            <!-- 提交表单 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="javascript:void(0)" onclick="window.history.go(-1)"><img
                    src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<s:form method="post"  action="staffAction_edit" namespace="/">

    <%--用于回传员工staffId，实现数据库的更新--%>
    <s:hidden name="staffId" value="%{staffId}" ></s:hidden>
    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>登录名：</td>
            <td>
                <s:textfield name="loginName"></s:textfield>
            </td>
            <td>密码：</td>
            <td>
                <s:password name="loginPwd" showPassword="true"/>
            </td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>

                <s:textfield name="staffName"/>
            </td>
            <td>性别：</td>
            <td>

                <s:radio list="{'男','女'}" name="gender"/>


            </td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">


                    <%--选择所属部门--%>
                <s:select list="allDepartment" name="post.department.depId" onchange="showPost(this)"
                          listKey="depId" listValue="depName"
                          headerKey="" headerValue="----请--选--择----">

                </s:select>


            </td>
            <td width="8%">职务：</td>
            <td width="62%">


                    <%--避免post为null --%>
                <s:select list="post !=null ? post.department.postSet:{}" name="post.postId"
                          listKey="postId" listValue="postName"
                          headerKey="" headerValue="----请--选--择----"
                          id="postSelectId"
                >
                </s:select>


            </td>
        </tr>
        <tr>
            <td width="10%">入职时间：</td>
            <td width="20%">
                    <%--格式话时间，并显示--%>
                <s:date name="onDutyDate" format="yyyy-MM-dd" var="myDate"/>
                <s:textfield name="onDutyDate" readonly="true" value="%{#myDate}"
                             onfocus="c.showMoreDay=true;c.show(this);"></s:textfield>
                    <%--格式话时间，并显示完--%>

            </td>
            <td width="8%"></td>
            <td width="62%"></td>
        </tr>
    </table>
</s:form>


<script>
    function showPost(obj) {
//         获得险种的部门
        var depId = obj.value;


//         发送ajax，通过部门查询职务

//         1.获得引擎
        var xmlhttp = null;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else if (window.ActiveXObject) {

            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }


//         设置回调函数
        xmlhttp.onreadystatechange = function () {

            if (xmlhttp.readyState == 4) {
                if (xmlhttp.status == 200) {

//                    返回的json字符串为：
//                    [{"postId":"2c9091c14c78e58b014c78e6f2340005","postName":"主管"}]
///                      将json字符串解析为js对象

                    var jsonData = JSON.parse("{\"sss\":" + xmlhttp.responseText + "}");
//                    该js对象的json字符串为：
//                    {
//                        "sss":[
//                        {
//                            "postId":"2c9091c14c78e58b014c78e6b34a0003",
//                            "postName":"总监"
//                        },
//                        {
//                            "postId":"2c9091c14c78e58b014c78e6d4510004",
//                            "postName":"讲师"
//                        }
//                    ]
//                    }

                    // 也可以使用eval函数
                    //  var jsonData = eval("("+xmlhttp.responseText+")");


//                       // 获得select对象，职务选择
                    var postSelectElement = document.getElementById("postSelectId");

//                    先清空 ，等价于初始化
                    postSelectElement.innerHTML =  "<option value=''>----请--选--择----</option>";

                    var arry = jsonData.sss;
//                    遍历
                    for ( var i = 0; i < arry.length; i++){
                        var postObj = arry[i];
                        var postId = postObj.postId;

                        var postName = postObj.postName;

                        //3.3 将数显示到select标签
                        postSelectElement.innerHTML += "<option value='"+postId+"'>"+postName+"</option>";
                    }


                }
            }

        };


        //2.3 创建连接
        var url = "${pageContext.request.contextPath}/postAction_findAllWithDepartment?department.depId=" + depId;
        xmlhttp.open("GET", url);
        //2.4 发送请求
        xmlhttp.send(null);


    }


</script>

</body>
</html>
