<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:form    method="post">
	
	<%--<input type="hidden" name="staffId" value="2c9091c14c78e58b014c78e7ecd90007"/>--%>
	
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td>
		  <s:textfield name="loginName" ></s:textfield>
		</td>
	    <td>密码：</td>
	    <td>
			<s:password name="loginPwd" showPassword="true"/>
		</td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td>

		 	<s:textfield name="staffName" />
		</td>
	    <td>性别：</td>
	    <td>

			<s:radio list="{'男','女'}"  name="gender" />
			

			
	    </td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<select name="crmPost.crmDepartment.depId"  onchange="changePost(this)">
			    <option value="">----请--选--择----</option>
			    <option value="2c9091c14c78e58b014c78e67de10001" selected="selected">java学院</option>
			    <option value="2c9091c14c78e58b014c78e68ded0002">咨询部</option>
			</select>





	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<select name="crmPost.postId" id="postSelectId">
			    <option value="">----请--选--择----</option>
			    <option value="2c9091c14c78e58b014c78e6b34a0003">总监</option>
			    <option value="2c9091c14c78e58b014c78e6d4510004" selected="selected">讲师</option>
			</select>
	    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
			<%--格式话时间，并显示--%>
			<s:date name="onDutyDate" format="yyyy-MM-dd" var="myDate" />
			<s:textfield name="onDutyDate" readonly="true" value="%{#myDate}" onfocus="c.showMoreDay=true;c.show(this);"></s:textfield>
			<%--格式话时间，并显示完--%>

		</td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</s:form>

</body>
</html>