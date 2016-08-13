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
	<p align="center">员工管理</p>
	
<c:choose>
		<c:when test="${empty pb.beanList }">
			<table width="95%" align="center" cellpadding="0" cellspacing="0" style="line-height:50px;">
				<tr>
					<td>
						<span class="spanEmpty">没有员工</span>
					</td>
				</tr>
			</table>  
		</c:when>
		<c:otherwise>
		<div  align="center">员工列表</div>
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr bgcolor="#efeae5">
					<td>员工号</td>
					<td>员工名字</td>
					<td>操作</td>
					<td>操作</td>
				</tr>	
	
				<c:forEach items="${pb.beanList }" var="employee" varStatus="status">
					<tr>					
						<td>${employee.empId }</td>
						<td>${employee.empName }</td>
						<td>
							<a href="<c:url value='/deleteEmployee.action?empId=${employee.empId }'/>">删除该员工</a>
						</td>
						<td>
							<a href="<c:url value='/findEmpByEmpId.action?empId=${employee.empId }'/>">查看详细信息</a>
						</td>
	
					</tr>
				</c:forEach>
	
			</table>
	
		</c:otherwise>
	</c:choose>
	<c:if test="${!empty pb.beanList}">
		<div style="float:left; width: 100%; text-align: center;">
			<hr/>
			<br/>
			<%@include file="/jsp/user/jsps/pager.jsp" %>
		</div>
	</c:if>
  </body>
 
</html>