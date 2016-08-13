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
	<p align="center">结果</p>

			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr bgcolor="#efeae5">
					<td>员工号</td>
					<td>员工名</td>
					<td>性别</td>
					<td>出生时间</td>
					<td>入职时间</td>
					<td>薪水</td>
					<td>所属部门号</td>
				</tr>	
	
				<c:forEach items="${list }" var="employee" varStatus="status">
					<tr>					
						<td>${employee.empId }</td>
						<td>${employee.empName }</td>
						<td>${employee.sex }</td>
						<td>${employee.birth }</td>
						<td>${employee.hiredate }</td>
						<td>${employee.salary }</td>
						<td>${employee.depId }</td>
					</tr>
				</c:forEach>
			</table>

  </body>
 
</html>