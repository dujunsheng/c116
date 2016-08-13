<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

<style type="text/css">
	body {
		background: #15B69A;
		margin: 0px;
		color: #ffffff;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">C116学校管理系统</h1>
<div style="font-size: 10pt; line-height: 10px;">

<%-- 根据用户是否登录，显示不同的链接 --%>
<c:choose>
	<c:when test="${empty sessionScope.role }">
		  <a href="<c:url value='/jsp/user/jsps/login.jsp'/>" target="_parent">用户登录</a> 
	</c:when>
	<c:otherwise>
		      欢迎你用户&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href=<c:url value='/findMe.action'/> target="body">我的个人信息</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href=<c:url value=''/> target="body">查看通知</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href=<c:url value='/jsp/user/jsps/editPw.jsp'/> target="body">修改密码</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/quit.action'/>" target="_parent">退出</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	</c:otherwise>
</c:choose>
</div>
