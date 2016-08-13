<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/css/pager.css'/>" />
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<style type="text/css">
		li {float: left; width: 240px; list-style:none;height: 319px; line-height: 18px; position: relative; border-bottom: solid 1px #e5e5e5; }
		li div {margin-bottom:1px;margin-left: 10px;}
	</style>
  </head>
  
  <body>
	<p align="center">部门管理</p>
	
		<div  align="center">修改部门名字</div>
		<form action="">
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
					<tr>					
						<td></td>
						<td><% =request.getParameter("depName") %></td>
						<td>${department.depName }</td>
						<td>${pb.pageNum }
						<td>11111111111111111</td>
					</tr>
				<tr>
					<td align="center">
						<input type="submit" value="提交"/>
						<input type="reset" value="重置"/>				
					</td>
				</tr>
			</table>
		</form>
	
  </body>
 
</html>